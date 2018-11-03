package lt.balt.virtualusmokytojas.grafika;

import java.io.File;
import java.net.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import lt.balt.virtualusmokytojas.PokalbiuKambarys;
import lt.balt.virtualusmokytojas.pasnekovai.Pasnekovas;
import lt.balt.virtualusmokytojas.Klausimas;
import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Main extends Application {
	
	private Scene pradinisLangas, klausimuLangas, naujuKlausimuLangas;
	
	private PokalbiuKambarys kambarys = new PokalbiuKambarys();
	private Pasnekovas dabartinisPasnekovas = kambarys.isrinktiAtsitiktiniPasnekova();
	private Klausimas dabartinisKlausimas = dabartinisPasnekovas.isrinktiAtsitiktiniKlausima();

	private Label klausimoKortele = new Label(dabartinisKlausimas.getKlausimoFormuluote());
	private String videoUrl = dabartinisKlausimas.getPapildomaInformacija();
	private Media media;
	private MediaPlayer mediaPlayer;
	private MediaView mediaView;
	private boolean videoOn = false;
	private ImageView alternativeImageView;
	private boolean imageOn = false;
	private Label alternativeText = new Label("");
	private boolean textOn = false;
	private VBox videoLangas = new VBox(alternativeText);
	
	private File pasnekovoIsvaizda;
	private Image image;
	private ImageView imageView;
	VBox paveikslelioLangas = new VBox();
	
	private Image imagePrieNaujuKlausimu;
	private ImageView imageViewPrieNaujuKlausimu;
			
//--- --- --- --- --- --- ---

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Application.setUserAgentStylesheet(getClass().getClassLoader().getResource("mokytojas.css").toExternalForm());
		primaryStage.setTitle("Virtualus Chroniškas Klausinėtojas su jumis");

// Pirma scena - pradinis startinis langas
		
		Button pabendravimoMygtukas = new Button("PABENDRAUKIME");
		pabendravimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(klausimuLangas);
			}
		});

		Button naujoKlausimoMygtukas = new Button("PRIDĖTI SAVO KLAUSIMĄ");
		naujoKlausimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(naujuKlausimuLangas);
			}
		});

		Button programosUzdarymoMygtukas = new Button("UŽDARYTI PROGRAMĄ");
		programosUzdarymoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

		HBox hbox1 = new HBox(pabendravimoMygtukas, naujoKlausimoMygtukas, programosUzdarymoMygtukas);
		pradinisLangas = new Scene(hbox1);
		
// Antra scena - klausimu ir atsakymu langas
		
		rodytiKlausimoPapildomaInformacija();

		Button kitoKlausimoMygtukas = new Button("Kitas klausimas");
		kitoKlausimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				uzduotiKitaKlausima();
			}
		});

		Button uzuominosMygtukas = new Button("Užuomina");
		uzuominosMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				alternativeText.setText(dabartinisKlausimas.getUzuomina());
				textOn = true;
			}
		});

		Button atsakymoMygtukas = new Button("Atsakymas");
		atsakymoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				alternativeText.setText(dabartinisKlausimas.getAtsakymas());
				textOn = true;				
			}
		});
		
		HBox mygtukuTrio = new HBox(kitoKlausimoMygtukas, uzuominosMygtukas, atsakymoMygtukas);
		
		Button klausimoTrynimoMygtukas = new Button("Ištrinti klausimą");
		klausimoTrynimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!(dabartinisPasnekovas.getVisiKlausimai().size() <= 1)) {
					alternativeText.setText("Klausimas trinamas");
					textOn = true;
					dabartinisPasnekovas.getVisiKlausimai().remove(dabartinisKlausimas);
					KlausimuKlase.istrintiKlausimaIsDB(dabartinisKlausimas);
					uzduotiKitaKlausima();
				} else {
					alternativeText.setText("Tai paskutinis šio pašnekovo klausimas.\nPrieš trinant šį klausimą, prašome pašnekovui pridėti naujų klausimų.");
					textOn = true;
				}
			}
		});

		Button klausimoPridejimoMygtukas = new Button("Pridėti naują klausimą");
		klausimoPridejimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(naujuKlausimuLangas);
			}
		});

		try {
			pasnekovoIsvaizda = new File(dabartinisPasnekovas.getIsvaizda());
			image = new Image(pasnekovoIsvaizda.toURI().toString());
			imageView = new ImageView(image);
			paveikslelioLangas = new VBox(imageView);
		} catch (Exception ePasnekovoIsvaizda) {
			paveikslelioLangas = new VBox(new Label("Puikiai atrodantis pašnekovas"));
		}

		Label pasnekovoKortele = new Label("Pabendrauti su kitu pašnekovu:");
		
		ChoiceBox<Pasnekovas> pasnekovoPasirinkimas = new ChoiceBox<Pasnekovas>();
		ChoiceBox<Pasnekovas> mokytojoPasirinkimas = new ChoiceBox<Pasnekovas>();
		
		for (int pasnekovoNr = 0; pasnekovoNr < kambarys.getVisiPasnekovai().size(); pasnekovoNr++) {
			pasnekovoPasirinkimas.getItems().add(kambarys.getVisiPasnekovai().get(pasnekovoNr));
		}

		pasnekovoPasirinkimas.getSelectionModel().select(dabartinisPasnekovas);
		pasnekovoPasirinkimas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pasnekovas>() {
			@Override
			public void changed(ObservableValue<? extends Pasnekovas> observable, Pasnekovas oldValue,
					Pasnekovas newValue) {
				dabartinisPasnekovas = newValue;
				try {
					pasnekovoIsvaizda = new File(dabartinisPasnekovas.getIsvaizda());
					image = new Image(pasnekovoIsvaizda.toURI().toString());
					imageView.setImage(image);
				} catch (Exception ePasnekovoIsvaizda) {
					paveikslelioLangas.getChildren().add(new Label("Puikiai atrodantis pašnekovas"));
				}
				uzduotiKitaKlausima();
				mokytojoPasirinkimas.getSelectionModel().select(dabartinisPasnekovas);
			}
		});
	
		Button atsisveikinimoMygtukas = new Button("Atsisveikinti");
		atsisveikinimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(pradinisLangas);
			}
		});

		VBox vbox211 = new VBox(klausimoKortele);
		VBox vbox212 = new VBox(videoLangas, mygtukuTrio);
		VBox vbox213 = new VBox(15);
		vbox213.getChildren().addAll(klausimoTrynimoMygtukas, klausimoPridejimoMygtukas);
		VBox vbox21 = new VBox(15);
		vbox21.getChildren().addAll(vbox211, vbox212, vbox213);
		VBox vbox22 = new VBox(15);
		vbox22.getChildren().addAll(paveikslelioLangas, pasnekovoKortele, pasnekovoPasirinkimas, atsisveikinimoMygtukas);
		HBox hbox2 = new HBox(vbox21, vbox22);
		
	    ScrollPane scrollPane = new ScrollPane();
	    scrollPane.setContent(hbox2);
	    scrollPane.setPannable(true);
	    scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	    scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

		klausimuLangas = new Scene(scrollPane);

// Trecia scena - nauju klausimu pridejimo langas
		
		Label klausimoPridejimoInfo = new Label("Pridėkite savo klausimą:");
		Label klausimoPrierasas = new Label("Klausimas:");
		TextField klausimoTekstas = new TextField("Rašykite klausimą");
		Label videoUrlPrierasas = new Label("Video nuoroda:");
		TextField videoUrlTekstas = new TextField("Pridėkite video nuorodą");
		Label paveiksloUrlPrierasas = new Label("Paveikslėlio nuoroda:");
		TextField paveiksloUrlTekstas = new TextField("Pridėkite paveikslėlio nuorodą");
		Label uzuominosPrierasas = new Label("Užuomina:");
		TextField uzuominosTekstas = new TextField("Rašykite užuominą");
		Label atsakymoPrierasas = new Label("Atsakymas:");
		TextField atsakymoTekstas = new TextField("Rašykite atsakymą");
		Label mokytojoPasirinkimoPrierasas = new Label("Pašnekovas:");
		
		HBox naujoKlausimoHbox1 = new HBox(klausimoPrierasas, klausimoTekstas);
		HBox naujoKlausimoHbox2 = new HBox(videoUrlPrierasas, videoUrlTekstas);
		HBox naujoKlausimoHbox3 = new HBox(paveiksloUrlPrierasas, paveiksloUrlTekstas);
		HBox naujoKlausimoHbox4 = new HBox(uzuominosPrierasas, uzuominosTekstas);
		HBox naujoKlausimoHbox5 = new HBox(atsakymoPrierasas, atsakymoTekstas);

		for (int mokytojoNr = 0; mokytojoNr < kambarys.getVisiPasnekovai().size(); mokytojoNr++) {
			mokytojoPasirinkimas.getItems().add(kambarys.getVisiPasnekovai().get(mokytojoNr));
		}
		
		mokytojoPasirinkimas.getSelectionModel().select(dabartinisPasnekovas);
		mokytojoPasirinkimas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pasnekovas>() {
			@Override
			public void changed(ObservableValue<? extends Pasnekovas> observable, Pasnekovas oldValue,
					Pasnekovas newValue) {
				dabartinisPasnekovas = newValue;
				try {
					pasnekovoIsvaizda = new File(dabartinisPasnekovas.getIsvaizda());
					image = new Image(pasnekovoIsvaizda.toURI().toString());
					imageView.setImage(image);
				} catch (Exception ePasnekovoIsvaizda) {
					paveikslelioLangas.getChildren().add(new Label("Puikiai atrodantis pašnekovas"));
				}
				uzduotiKitaKlausima();
				pasnekovoPasirinkimas.getSelectionModel().select(dabartinisPasnekovas);
			}
		});
		
		HBox naujoKlausimoHbox6 = new HBox(mokytojoPasirinkimoPrierasas, mokytojoPasirinkimas);

		Button isejimoMygtukas = new Button("Išeiti");
		isejimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(pradinisLangas);
			}
		});
		
		Button issaugojimoMygtukas = new Button("Išsaugoti klausimą");
		issaugojimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Klausimas pridedamasKlausimas = new Klausimas(klausimoTekstas.getText(), videoUrlTekstas.getText(), uzuominosTekstas.getText(), atsakymoTekstas.getText(), dabartinisPasnekovas.getVardas());
				dabartinisPasnekovas.getVisiKlausimai().add(pridedamasKlausimas);
				KlausimuKlase.itrauktiKlausimaIDB(pridedamasKlausimas);
			}
		});
		
		HBox mygtukuDuetas = new HBox(issaugojimoMygtukas, isejimoMygtukas);
		VBox naujoKlausimoInformacija = new VBox(5);
		naujoKlausimoInformacija = new VBox(klausimoPridejimoInfo, naujoKlausimoHbox1, naujoKlausimoHbox2,
				naujoKlausimoHbox3, naujoKlausimoHbox4, naujoKlausimoHbox5, naujoKlausimoHbox6, mygtukuDuetas);

		HBox naujoKlausimoInformacijaSuPaveiksleliu = new HBox();
		try {
			imagePrieNaujuKlausimu = new Image(new File("resources/images/DelnasPrieFormos.jpg").toURI().toString());
			imageViewPrieNaujuKlausimu = new ImageView(imagePrieNaujuKlausimu);
			naujoKlausimoInformacijaSuPaveiksleliu = new HBox(naujoKlausimoInformacija, imageViewPrieNaujuKlausimu);
		} catch (Exception eImagePrieNaujuKlausimu) {
			naujoKlausimoInformacijaSuPaveiksleliu = new HBox(naujoKlausimoInformacija);
		}

	    ScrollPane scrollPane2 = new ScrollPane();
	    scrollPane2.setContent(naujoKlausimoInformacijaSuPaveiksleliu);
	    scrollPane2.setPannable(true);
	    scrollPane2.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	    scrollPane2.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
	    
		naujuKlausimuLangas  = new Scene(scrollPane2);
		
		primaryStage.setScene(pradinisLangas);
		primaryStage.show();
	}
	
	//--- Metodai ---
	
	private void isvalytiKlausimoPapildomosInformacijosLaukus() {
		if (videoOn) {
			isvalytiPapildomosInformacijosVideoLaukus();
		}
		if (imageOn) {
			isvalytiPapildomosInformacijosPaveiksleliuLaukus();
		}
		if (textOn) {
			isvalytiPapildomosInformacijosTekstuLaukus();
		}
	}
	
	private void isvalytiPapildomosInformacijosVideoLaukus() {
		mediaPlayer.stop();
		mediaView.setVisible(false);
		mediaView.setFitWidth(10);
		mediaView.setFitHeight(10);
		videoOn = false;
	}
	
	private void isvalytiPapildomosInformacijosPaveiksleliuLaukus() {
		alternativeImageView.setVisible(false);
		alternativeImageView.setFitWidth(10);
		alternativeImageView.setFitHeight(10);
		imageOn = false;
	}
	
	private void isvalytiPapildomosInformacijosTekstuLaukus() {
		alternativeText.setText("");
		textOn = false;
	}

	private void rodytiKlausimoPapildomaInformacija() {
		if (videoUrl == null) {
			alternativeText.setText("Papildomos informacijos nėra.");
			textOn = true;
		} else {

			try {
				URI myURI = new URI(videoUrl);
				media = new Media(myURI.toString());
				mediaPlayer = new MediaPlayer(media);
				if (mediaView == null) {
					mediaView = new MediaView(mediaPlayer);
					mediaView.setPreserveRatio(true);
				} else {
					mediaView.setMediaPlayer(mediaPlayer);
				}
				mediaView.setFitWidth(600);
				mediaView.setFitHeight(360);
				if (!videoLangas.getChildren().contains(mediaView)) {
					videoLangas.getChildren().add(mediaView);
				}
				mediaView.setVisible(true);
				mediaPlayer.play();
				videoOn = true;
			} catch (Exception netMedia) {

				try {
					File mFile = new File(videoUrl);
					media = new Media(mFile.toURI().toString());
					mediaPlayer = new MediaPlayer(media);
					if (mediaView == null) {
						mediaView = new MediaView(mediaPlayer);
						mediaView.setPreserveRatio(true);
					} else {
						mediaView.setMediaPlayer(mediaPlayer);
					}
					mediaView.setFitWidth(600);
					mediaView.setFitHeight(360);
					if (!videoLangas.getChildren().contains(mediaView)) {
						videoLangas.getChildren().add(mediaView);
					}
					mediaView.setVisible(true);
					mediaPlayer.play();
					videoOn = true;
				} catch (Exception eMedia) {

					try {
						URI myURI = new URI(videoUrl);
						Image iImage = new Image(myURI.toString());
						if (alternativeImageView == null) {
							alternativeImageView = new ImageView(iImage);
							alternativeImageView.setPreserveRatio(true);
						} else {
							alternativeImageView.setImage(iImage);
						}
						alternativeImageView.setFitWidth(600);
						alternativeImageView.setFitHeight(360);
						if (!videoLangas.getChildren().contains(alternativeImageView)) {
							videoLangas.getChildren().add(alternativeImageView);
						}
						alternativeImageView.setVisible(true);
						imageOn = true;
					} catch (Exception netImage) {

						try {
							File iFile = new File(videoUrl);
							Image iImage = new Image(iFile.toURI().toString());
							if (alternativeImageView == null) {
								alternativeImageView = new ImageView(iImage);
								alternativeImageView.setPreserveRatio(true);
							} else {
								alternativeImageView.setImage(iImage);
							}
							alternativeImageView.setFitWidth(600);
							alternativeImageView.setFitHeight(360);
							if (!videoLangas.getChildren().contains(alternativeImageView)) {
								videoLangas.getChildren().add(alternativeImageView);
							}
							alternativeImageView.setVisible(true);
							imageOn = true;
						} catch (Exception eImage) {

							try {
								alternativeText.setText(videoUrl);
								textOn = true;
							} catch (Exception eText) {

								alternativeText.setText("Papildomos informacijos nėra.");
								textOn = true;

							}
						}
					}
				}
			}
		}
	}

	private void uzduotiKitaKlausima() {
		Klausimas senasKlausimas = dabartinisKlausimas;
		if (!(dabartinisPasnekovas.getVisiKlausimai().size() <= 1)) {
			while (dabartinisKlausimas == senasKlausimas) {
				dabartinisKlausimas = dabartinisPasnekovas.uzduotiKlausima();
			}
		} else {dabartinisKlausimas = dabartinisPasnekovas.uzduotiKlausima();}
		klausimoKortele.setText(dabartinisKlausimas.getKlausimoFormuluote());
		isvalytiKlausimoPapildomosInformacijosLaukus();
		videoUrl = dabartinisKlausimas.getPapildomaInformacija();
		rodytiKlausimoPapildomaInformacija();
	}

}
