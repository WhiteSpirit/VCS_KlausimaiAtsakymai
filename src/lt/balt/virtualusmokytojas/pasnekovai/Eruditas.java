package lt.balt.virtualusmokytojas.pasnekovai;

import java.util.ArrayList;
import lt.balt.virtualusmokytojas.Klausimas;
import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Eruditas extends Pasnekovas {

	private String vardas = "Eruditas";
	private String isvaizda = "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/PasnekovasEruditas.jpg";
	private ArrayList<Klausimas> visiKlausimai;

	public Eruditas() {
		this.visiKlausimai = KlausimuKlase.getKlausimaiEruditui();
	}

	@Override
	public Klausimas isrinktiAtsitiktiniKlausima() {
		int klausimoVieta = (int) (Math.random() * visiKlausimai.size());
		Klausimas atsitiktinisKlausimas = visiKlausimai.get(klausimoVieta);
		return atsitiktinisKlausimas;
	}

	@Override
	public Klausimas uzduotiKlausima() {
		Klausimas klausimas = isrinktiAtsitiktiniKlausima();
		return klausimas;
	}

	@Override
	public String pateiktiUzuomina(Klausimas klausimas) {
		return klausimas.getUzuomina();
	}

	@Override
	public String pateiktiAtsakyma(Klausimas klausimas) {
		return klausimas.getAtsakymas();
	}

	public String getVardas() {
		return vardas;
	}

	public String getIsvaizda() {
		return isvaizda;
	}

	public ArrayList<Klausimas> getVisiKlausimai() {
		return visiKlausimai;
	}

	public void setVisiKlausimai(ArrayList<Klausimas> visiKlausimai) {
		this.visiKlausimai = visiKlausimai;
	}

}
