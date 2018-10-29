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

	public static ArrayList<Klausimas> getKlausimaiMatematikui() {
		if (klausimaiMatematikui == null) {
			klausimaiMatematikui = new ArrayList<Klausimas>();
			klausimaiMatematikui.add(new Klausimas("1 + 1 = ... ?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/DuBatai.jpg", "DU", "2", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("2 + 2 = ... ?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/KeturiRatai.jpg", "KETURI", "4", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("3 + 3 = ... ?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/Sesi.jpg", "ŠEŠI", "6", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("4 + 4 = ... ?", "## ## + ## ##", "AŠTUONI", "8", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("5 + 5 = ... ?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/DesimtTomukoAtradimu.jpg", "DEŠIMT", "10", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("6 + 6 = ... ?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/DvylikaKedziu.jpeg", "DVYLIKA", "12", "Matematikas"));
			klausimaiMatematikui
					.add(new Klausimas("7 + 7 = ... ?", "# # # # # # # + # # # # # # #", "KETURIOLIKA", "14", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("8 + 8 = ... ?", "## ## ## ## + ## ## ## ##", "ŠEŠIOLIKA", "16", "Matematikas"));
			klausimaiMatematikui
					.add(new Klausimas("9 + 9 = ... ?", "# # # # # # # # # + # # # # # # # # #", "AŠTUONIOLIKA", "18", "Matematikas"));
			klausimaiMatematikui.add(new Klausimas("10 + 10 = ... ?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/DvidesimtLitu.jpg", "DVIDEŠIMT", "20", "Matematikas"));
		}
		return klausimaiMatematikui;
	}

	public static void setKlausimaiMatematikui(ArrayList<Klausimas> klausimaiMatematikui) {
		KlausimuKlase.klausimaiMatematikui = klausimaiMatematikui;
	}

	public static ArrayList<Klausimas> getKlausimaiMuzikui() {
		if (klausimaiMuzikui == null) {
			klausimaiMuzikui = new ArrayList<Klausimas>();
			klausimaiMuzikui.add(new Klausimas("Kas sukūrė Lietuvos himną?", "Lietuva, Tėvyne mūsų, Tu didvyrių žeme...", "V. K.",
					"Vincas Kudirka", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos instrumentas?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/Smuikas.jpg", "Styginis muzikos instrumentas",
					"Smuikas", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos instrumentas?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/Pianinas.jpg", "Klavišinis muzikos instrumentas",
					"Pianinas", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos instrumentas?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/Violoncele.jpg", "V.",
					"Violončelė", "Muzikas"));
			klausimaiMuzikui.add(new Klausimas("Koks tai muzikos instrumentas?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/Akordeonas.jpg", "A.",
					"Akordeonas", "Muzikas"));
		}
		return klausimaiMuzikui;
	}

	public static void setKlausimaiMuzikui(ArrayList<Klausimas> klausimaiMuzikui) {
		KlausimuKlase.klausimaiMuzikui = klausimaiMuzikui;
	}

	public static ArrayList<Klausimas> getKlausimaiSenoliui() {
		if (klausimaiSenoliui == null) {
			klausimaiSenoliui = new ArrayList<Klausimas>();
			klausimaiSenoliui.add(new Klausimas("Žalia žolė, bet ne žolė, su uodega, bet ne pelė. Kas?", "",
					"Žalia daržovė", "Agurkas", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Be kojų, be rankų duris atidaro. Kas?", "Mįslė",
					"Gamtos reiškinys", "Vėjas", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Be rankų, be kojų tiltą pastato. Kas?", "Mįslė",
					"Žiema", "Šaltis ir ledas", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Kai mėlynas, juokiasi. Kai pilkas, verkia. Kas?", "Mįslė",
					"Viršuje", "Dangus", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Penki tvartai, vieni vartai. Kas?", "Mįslė",
					"Apranga", "Pirštinė", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Žemiau už gyvates šliaužioja. Aukščiau už paukščius skraido. Kas?", "Mįslė",
					"Iš vandenilio ir deguonies", "Vanduo", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Ant kojytės kepurytė. Kas?", "Mįslė",
					"Valgomas arba nevalgomas", "Grybas", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Kas audžia be staklių?", "Mįslė",
					"Musių siaubas", "Voras", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Už žirnį mažesnis, už šunį piktesnis. Kas?", "Mįslė",
					"Aštrus", "Pipiras", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Dešimt uždirba, trisdešimt du pradirba. Kas?", "Mįslė",
					"Apie žmones", "Pirštai ir dantys", "Senolis"));
			klausimaiSenoliui.add(new Klausimas("Atlekia be sparnų. Įkanda be dantų. Kas?", "Mįslė",
					"Metalas", "Kulka", "Senolis"));
		}
		return klausimaiSenoliui;
	}

	public static void setKlausimaiSenoliui(ArrayList<Klausimas> klausimaiSenoliui) {
		KlausimuKlase.klausimaiSenoliui = klausimaiSenoliui;
	}

	public static ArrayList<Klausimas> getKlausimaiStiuardesei() {
		if (klausimaiStiuardesei == null) {
			klausimaiStiuardesei = new ArrayList<Klausimas>();
			klausimaiStiuardesei
					.add(new Klausimas("Didžiausias Lietuvos miestas", "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv", "Lietuvos sostinė", "Vilnius", "Stiuardese"));
			klausimaiStiuardesei.add(
					new Klausimas("Miestas su Eifelio bokštu", "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv", "Prancūzijos sostinė", "Paryžius", "Stiuardese"));
			klausimaiStiuardesei.add(
					new Klausimas("Miestas su Brandenburgo vartais", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/BrandenburgoVartai.jpg", "Vokietijos sostinė", "Berlynas", "Stiuardese"));
			klausimaiStiuardesei.add(
					new Klausimas("Kas šie žmonės?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/DesimtLitu.jpg", "Lakūnai", "Steponas Darius ir Stasys Girėnas", "Stiuardese"));
			klausimaiStiuardesei.add(
					new Klausimas("Kas šis žmogus?", "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/JurgisKairys.jpg", "Lakūnas", "JurgisKairys", "Stiuardese"));
		
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
