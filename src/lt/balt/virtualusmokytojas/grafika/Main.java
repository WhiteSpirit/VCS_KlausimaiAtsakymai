package lt.balt.virtualusmokytojas.grafika;

import java.io.File;

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

public class Main extends Application {

	private Scene pradinisLangas, klausimuLangas, naujuKlausimuLangas;
	
	private PokalbiuKambarys kambarys = new PokalbiuKambarys();
	private Pasnekovas dabartinisPasnekovas = kambarys.isrinktiAtsitiktiniPasnekova();
	private Klausimas dabartinisKlausimas = dabartinisPasnekovas.isrinktiAtsitiktiniKlausima();

//--- Pirmos scenos kintamieji ---

	private Button pabendravimoMygtukas = new Button("PABENDRAUKIME");
	private Button naujoKlausimoMygtukas = new Button("PRIDĖTI SAVO KLAUSIMĄ");
	private Button programosUzdarymoMygtukas = new Button("UŽDARYTI PROGRAMĄ");

	private HBox hbox1 = new HBox(pabendravimoMygtukas, naujoKlausimoMygtukas, programosUzdarymoMygtukas);

//--- Antros scenos kintamieji ---

	private Label klausimoKortele = new Label(dabartinisKlausimas.getKlausimoFormuluote());
	private VBox vbox211 = new VBox();
	
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
	
	private Button kitoKlausimoMygtukas = new Button("Kitas klausimas");
	private Button uzuominosMygtukas = new Button("Užuomina");
	private Button atsakymoMygtukas = new Button("Atsakymas");
	private HBox mygtukuTrio = new HBox(kitoKlausimoMygtukas, uzuominosMygtukas, atsakymoMygtukas);
	private VBox vbox212 = new VBox();
	
	private Button klausimoTrynimoMygtukas = new Button("Ištrinti klausimą");
	private Button klausimoPridejimoMygtukas = new Button("Pridėti naują klausimą");
	private VBox vbox213 = new VBox(15);
	
	private File pasnekovoIsvaizda;
	private Image image;
	private ImageView imageView;
	private VBox paveikslelioLangas = new VBox();
	private Label pasnekovoKortele = new Label("Pabendrauti su kitu pašnekovu:");
	private ChoiceBox<Pasnekovas> pasnekovoPasirinkimas = new ChoiceBox<Pasnekovas>();
	private Button atsisveikinimoMygtukas = new Button("Atsisveikinti");

	private VBox vbox21 = new VBox(15);
	private VBox vbox22 = new VBox(15);
	private HBox hbox2 = new HBox();

//--- Trecios scenos kintamieji ---
	
	private Label klausimoPridejimoInfo = new Label("Pridėkite savo klausimą:");
	
	private Label klausimoPrierasas = new Label("Klausimas:");
	private TextField klausimoTekstas = new TextField("Rašykite klausimą");
	private HBox naujoKlausimoHbox1;
	
	private Label videoUrlPrierasas = new Label("Video nuoroda:");
	private TextField videoUrlTekstas = new TextField("Pridėkite video nuorodą");
	private HBox naujoKlausimoHbox2;
	
	private Label paveiksloUrlPrierasas = new Label("Paveikslėlio nuoroda:");
	private TextField paveiksloUrlTekstas = new TextField("Pridėkite paveikslėlio nuorodą");
	private HBox naujoKlausimoHbox3;
	
	private Label uzuominosPrierasas = new Label("Užuomina:");
	private TextField uzuominosTekstas = new TextField("Rašykite užuominą");
	private HBox naujoKlausimoHbox4;
	
	private Label atsakymoPrierasas = new Label("Atsakymas:");
	private TextField atsakymoTekstas = new TextField("Rašykite atsakymą");
	private HBox naujoKlausimoHbox5;
	
	private Label mokytojoPasirinkimoPrierasas = new Label("Pašnekovas:");
	private ChoiceBox<Pasnekovas> mokytojoPasirinkimas = new ChoiceBox<Pasnekovas>();
	private HBox naujoKlausimoHbox6;
	
	private Button issaugojimoMygtukas = new Button("Išsaugoti klausimą");
	private Button isejimoMygtukas = new Button("Išeiti");
	private HBox mygtukuDuetas = new HBox(issaugojimoMygtukas, isejimoMygtukas);
	
	private VBox naujoKlausimoInformacija = new VBox(5);
	
//--- --- ---

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Application.setUserAgentStylesheet(getClass().getResource("mokytojas.css").toExternalForm());
		primaryStage.setTitle("Virtualus Chroniškas Klausinėtojas su jumis");

// Pirma scena - pradinis startinis langas		

		pabendravimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(klausimuLangas);
			}
		});

		naujoKlausimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(naujuKlausimuLangas);
			}
		});

		programosUzdarymoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

		this.pradinisLangas = new Scene(hbox1);

// Antra scena - klausimu ir atsakymu langas
		
		rodytiKlausimoPapildomaInformacija();

		kitoKlausimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				uzduotiKitaKlausima();
			}
		});

		uzuominosMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				alternativeText.setText(dabartinisKlausimas.getUzuomina());
				textOn = true;
			}
		});

		atsakymoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				alternativeText.setText(dabartinisKlausimas.getAtsakymas());
				textOn = true;				
			}
		});
		
		klausimoTrynimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!(dabartinisPasnekovas.getVisiKlausimai().size() <= 1)) {
					alternativeText.setText("Klausimas trinamas");
					textOn = true;
					dabartinisPasnekovas.getVisiKlausimai().remove(dabartinisKlausimas);
					uzduotiKitaKlausima();
				} else {
					alternativeText.setText("Tai paskutinis šio pašnekovo klausimas. Prieš trinant šį klausimą, prašome pašnekovui pridėti naujų klausimų.");
					textOn = true;
				}
			}
		});

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
			paveikslelioLangas.getChildren().add(imageView);
		} catch (Exception ePasnekovoIsvaizda) {
			paveikslelioLangas.getChildren().add(new Label("Puikiai atrodantis pašnekovas"));
		}

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
	
		atsisveikinimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(pradinisLangas);
			}
		});

		vbox211.getChildren().add(klausimoKortele);
		vbox212.getChildren().addAll(videoLangas, mygtukuTrio);
		vbox213.getChildren().addAll(klausimoTrynimoMygtukas, klausimoPridejimoMygtukas);
		
		vbox21.getChildren().addAll(vbox211, vbox212, vbox213);
		vbox22.getChildren().addAll(paveikslelioLangas, pasnekovoKortele, pasnekovoPasirinkimas, atsisveikinimoMygtukas);
		hbox2.getChildren().addAll(vbox21, vbox22);
		
		klausimuLangas = new Scene(hbox2);

// Trecia scena - nauju klausimu pridejimo langas
		
		naujoKlausimoHbox1 = new HBox(klausimoPrierasas, klausimoTekstas);
		naujoKlausimoHbox2 = new HBox(videoUrlPrierasas, videoUrlTekstas);
		naujoKlausimoHbox3 = new HBox(paveiksloUrlPrierasas, paveiksloUrlTekstas);
		naujoKlausimoHbox4 = new HBox(uzuominosPrierasas, uzuominosTekstas);
		naujoKlausimoHbox5 = new HBox(atsakymoPrierasas, atsakymoTekstas);

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
		
		naujoKlausimoHbox6 = new HBox(mokytojoPasirinkimoPrierasas, mokytojoPasirinkimas);

		isejimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(pradinisLangas);
			}
		});
		
		issaugojimoMygtukas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Klausimas pridedamasKlausimas = new Klausimas(klausimoTekstas.getText(), videoUrlTekstas.getText(), uzuominosTekstas.getText(), atsakymoTekstas.getText(), dabartinisPasnekovas.getVardas());
				dabartinisPasnekovas.getVisiKlausimai().add(pridedamasKlausimas);
			}
		});
		
		naujoKlausimoInformacija = new VBox(klausimoPridejimoInfo, naujoKlausimoHbox1, naujoKlausimoHbox2,
				naujoKlausimoHbox3, naujoKlausimoHbox4, naujoKlausimoHbox5, naujoKlausimoHbox6, mygtukuDuetas);
		naujuKlausimuLangas  = new Scene(naujoKlausimoInformacija);
				
		primaryStage.setScene(pradinisLangas);
		primaryStage.show();
	}
	
	//--- Metodai ---
	
	private void isvalytiKlausimoPapildomosInformacijosLaukus() {
		if (videoOn) {
			mediaPlayer.stop();
			videoOn = false;
		}
		if (imageOn) {
			alternativeImageView.setVisible(false);
			imageOn = false;
		}
		if (textOn) {
			alternativeText.setText("");
			textOn = false;
		}
	}

	private void rodytiKlausimoPapildomaInformacija() {
		if (videoUrl == null) {
			alternativeText.setText("Papildomos informacijos nėra.");
			textOn = true;
		} else {
			try {
				videoUrl = dabartinisKlausimas.getPapildomaInformacija();
				media = new Media(videoUrl);
				mediaPlayer = new MediaPlayer(media);
				if (mediaView == null) {
				mediaView = new MediaView(mediaPlayer);
				mediaView.setPreserveRatio(true);
				}
				else {mediaView.setMediaPlayer(mediaPlayer);}
				if (!videoLangas.getChildren().contains(mediaView)) {
					videoLangas.getChildren().add(mediaView);
				}
				mediaView.setVisible(true);
				mediaPlayer.play();
				videoOn = true;
			} catch (Exception eMedia) {
				
				
				
				
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

	private void uzduotiKitaKlausima() {
		dabartinisKlausimas = dabartinisPasnekovas.uzduotiKlausima();
		klausimoKortele.setText(dabartinisKlausimas.getKlausimoFormuluote());
		isvalytiKlausimoPapildomosInformacijosLaukus();
		videoUrl = dabartinisKlausimas.getPapildomaInformacija();
		rodytiKlausimoPapildomaInformacija();
	}

}
