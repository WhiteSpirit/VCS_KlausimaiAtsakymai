package lt.balt.virtualusmokytojas;

import java.util.ArrayList;

public abstract class KlausimuKlase {

	// private static Connection connection = null;
	// private static Statement statement = null;

	private static ArrayList<Klausimas> klausimaiMatematikui;
	private static ArrayList<Klausimas> klausimaiMuzikui;
	private static ArrayList<Klausimas> klausimaiSenoliui;
	private static ArrayList<Klausimas> klausimaiStiuardesei;
	private static ArrayList<Klausimas> klausimaiEruditui;

	//http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv
	
	public static ArrayList<Klausimas> getKlausimaiMatematikui() {
		if (klausimaiMatematikui == null) {
			klausimaiMatematikui = new ArrayList<Klausimas>();
			klausimaiMatematikui.add(new Klausimas("1 + 0 = ... ?", "resources/images/VienasNamuose.jpg", "VIENAS", "1", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("1 + 1 = ... ?", "resources/images/DuBatai.jpg", "DU", "2", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("2 + 1 = ... ?", "resources/images/TrysParsiukai.jpg", "TRYS", "3", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("2 + 2 = ... ?", "resources/images/KeturiRatai.jpeg", "KETURI", "4", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("2 + 3 = ... ?", "resources/images/Delnas.jpg", "PENKI", "5", "Matematikas"));			
			klausimaiMatematikui.add(new Klausimas("3 + 3 = ... ?", "resources/images/Sesi.jpg", "ŠEŠI", "6", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("3 + 4 = ... ?", "resources/images/SeptyniDrambliai.jpg", "SEPTYNI", "7", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("4 + 4 = ... ?", "resources/images/Voras.jpg", "AŠTUONI", "8", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("5 + 5 = ... ?", "resources/images/DesimtTomukoAtradimu.jpg", "DEŠIMT", "10", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("6 + 6 = ... ?", "resources/images/DvylikaKedziu.jpeg", "DVYLIKA", "12", "Matematikas"));
/*			klausimaiMatematikui
					.add(new Klausimas("7 + 7 = ... ?", "# # # # # # # + # # # # # # #", "KETURIOLIKA", "14", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("8 + 8 = ... ?", "## ## ## ## + ## ## ## ##", "ŠEŠIOLIKA", "16", "Matematikas"));
			*/klausimaiMatematikui
					.add(new Klausimas("Penki kartai po penkis", "resources/images/DvidesimtPenki.jpg", "DVIDEŠIMT PENKI", "25", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("10 + 10 = ... ?", "resources/images/DvidesimtLitu.jpg", "DVIDEŠIMT", "20", "Matematikas"));
		}
		return klausimaiMatematikui;
	}

	public static void setKlausimaiMatematikui(ArrayList<Klausimas> klausimaiMatematikui) {
		KlausimuKlase.klausimaiMatematikui = klausimaiMatematikui;
	}

	public static ArrayList<Klausimas> getKlausimaiMuzikui() {
		if (klausimaiMuzikui == null) {
			klausimaiMuzikui = new ArrayList<Klausimas>();
			klausimaiMuzikui.add(new Klausimas("Kas sukūrė Lietuvos himną?", "resources/videos/LietuvosHimnas.mp4", "V. K.",
					"Vincas Kudirka", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos instrumentas?", "resources/images/Smuikas.jpg", "Styginis muzikos instrumentas",
					"Smuikas", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos instrumentas?", "resources/images/Pianinas.jpg", "Klavišinis muzikos instrumentas",
					"Pianinas", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos instrumentas?", "resources/images/Violoncele.jpg", "V.",
					"Violončelė", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos instrumentas?", "resources/images/Akordeonas.jpg", "A.",
					"Akordeonas", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos stilius?", "resources/videos/Jonis.mp4", "Festivalis Visagine",
					"Kantri muzika", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos instrumentas?", "resources/videos/Vargonai.mp4", "Bažnytinis muzikos instrumentas",
					"Vargonai", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Kas šios dainos autorius ir atlikėjas?", "resources/videos/VytautasKernagis.mp4", "V. K.",
					"Vytautas Kernagis", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai renginys?", "resources/videos/Eurovizija.mp4", "Europoje",
					"Eurovizija", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai kūrinys?", "resources/videos/JohannesBrahmsHungarianDance.mp4", "Vengriškas...",
					"Johannes Brahms - Hungarian Dance", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Kas šis žmogus?", "resources/videos/Queen.mp4", "Queen lyderis",
					"Freddie Mercury", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Apie ką ši daina?", "resources/videos/ZalgirioMusis.mp4", "1410 m.",
					"Žalgirio mūšis", "Muzikas"));
		}
		return klausimaiMuzikui;
	}

	public static void setKlausimaiMuzikui(ArrayList<Klausimas> klausimaiMuzikui) {
		KlausimuKlase.klausimaiMuzikui = klausimaiMuzikui;
	}

	public static ArrayList<Klausimas> getKlausimaiSenoliui() {
		if (klausimaiSenoliui == null) {
			klausimaiSenoliui = new ArrayList<Klausimas>();
			klausimaiSenoliui.add(new Klausimas("Žalia žolė, bet ne žolė, su uodega, bet ne pelė. Kas?", "resources/images/Agurkas.jpg",
					"Žalia daržovė", "Agurkas", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Be kojų, be rankų duris atidaro. Kas?", "https://www.segodnya.ua/img/article/2896/55_main.jpg",
					"Gamtos reiškinys", "Vėjas", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Be rankų, be kojų tiltą pastato. Kas?", "resources/images/Saltis.jpg",
					"Žiema", "Šaltis ir ledas", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Kai mėlynas, juokiasi. Kai pilkas, verkia. Kas?", "resources/images/RodykleAukstyn.jpg",
					"Viršuje", "Dangus", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Penki tvartai, vieni vartai. Kas?", "resources/images/Pirstines.jpg",
					"Apranga", "Pirštinė", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Žemiau už gyvates šliaužioja. Aukščiau už paukščius skraido. Kas?", "resources/images/Vanduo.jpg",
					"Iš vandenilio ir deguonies", "Vanduo", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Ant kojytės kepurytė. Kas?", "resources/images/KepureAntBato.jpg",
					"Valgomas arba nevalgomas", "Grybas", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Kas audžia be staklių?", "https://g3.dcdn.lt/images/pix/780x439/Q22u_tEBmjw/1jpg-69650044.jpg",
					"Musių siaubas", "Voras", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Už žirnį mažesnis, už šunį piktesnis. Kas?", "resources/images/Bomba.jpg",
					"Aštrus", "Pipiras", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Dešimt uždirba, trisdešimt du pradirba. Kas?", "resources/images/DantysIrPirstai.jpg",
					"Apie žmones", "Pirštai ir dantys", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Atlekia be sparnų. Įkanda be dantų. Kas?", "resources/images/Kulka.jpg",
					"Metalas", "Kulka", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Koks tai šokis?", "resources/videos/RockAndRoll.mp4",
					"XX a. vidurys", "Rock & Roll'as", "Senolis"));
		}
		return klausimaiSenoliui;
	}

	public static void setKlausimaiSenoliui(ArrayList<Klausimas> klausimaiSenoliui) {
		KlausimuKlase.klausimaiSenoliui = klausimaiSenoliui;
	}

	public static ArrayList<Klausimas> getKlausimaiStiuardesei() {
		if (klausimaiStiuardesei == null) {
			klausimaiStiuardesei = new ArrayList<Klausimas>();
			klausimaiStiuardesei.add(new Klausimas("Didžiausias Lietuvos miestas",
					"resources/images/VilniausOroUostas1.jpg", "Lietuvos sostinė", "Vilnius",
					"Stiuardese"));
			klausimaiStiuardesei.add(new Klausimas("Miestas su Eifelio bokštu",
					"resources/videos/Paryzius.mp4", "Prancūzijos sostinė",
					"Paryžius", "Stiuardese"));
			klausimaiStiuardesei.add(new Klausimas("Miestas su Brandenburgo vartais",
					"resources/images/BrandenburgoVartai.jpg", "Vokietijos sostinė", "Berlynas", "Stiuardese"));
			klausimaiStiuardesei.add(new Klausimas("Kas šie žmonės?", "resources/images/DesimtLitu.jpg", "Lakūnai",
					"Steponas Darius ir Stasys Girėnas", "Stiuardese"));
			klausimaiStiuardesei.add(new Klausimas("Kas šis žmogus?", "resources/images/JurgisKairys.jpg", "Lakūnas",
					"Jurgis Kairys", "Stiuardese"));
			klausimaiStiuardesei.add(new Klausimas("Kas šis žmogus?",
					"resources/images/KonstantinasCiolkovskisKosmonautikosPradininkas.jpg",
					"Rusų mokslininkas, kosmonautikos pradininkas", "Konstantinas Ciolkovskis", "Stiuardese"));
			klausimaiStiuardesei.add(new Klausimas("Kas vairuoja lėktuvus?", "resources/images/Pilotai.jpg", "P.",
					"Pilotai", "Stiuardese"));
			klausimaiStiuardesei.add(new Klausimas("Kokia tai vieta?", "resources/images/VilniausOroUostas2.jpg", "Vieta Vilniuje",
					"Vilniaus oro uostas", "Stiuardese"));
		}
		return klausimaiStiuardesei;
	}

	public static void setKlausimaiStiuardesei(ArrayList<Klausimas> klausimaiStiuardesei) {
		KlausimuKlase.klausimaiStiuardesei = klausimaiStiuardesei;
	}

	public static ArrayList<Klausimas> getKlausimaiEruditui() {
		if (klausimaiEruditui == null) {
			klausimaiEruditui = new ArrayList<Klausimas>();
			klausimaiEruditui.addAll(getKlausimaiMatematikui());
			klausimaiEruditui.addAll(getKlausimaiMuzikui());
			klausimaiEruditui.addAll(getKlausimaiSenoliui());
			klausimaiEruditui.addAll(getKlausimaiStiuardesei());
		}
		return klausimaiEruditui;
	}

	public static void setKlausimaiEruditui(ArrayList<Klausimas> klausimaiEruditui) {
		KlausimuKlase.klausimaiEruditui = klausimaiEruditui;
	}

}
