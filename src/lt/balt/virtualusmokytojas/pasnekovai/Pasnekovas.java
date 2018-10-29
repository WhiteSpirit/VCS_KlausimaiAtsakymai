package lt.balt.virtualusmokytojas.pasnekovai;

import java.util.ArrayList;
import lt.balt.virtualusmokytojas.Klausimas;

public class Pasnekovas {

	private String vardas = "Pasnekovas";
	private String isvaizda = "src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/PasnekovasSenolis.jpg";
	private ArrayList<Klausimas> visiKlausimai;

	public Pasnekovas() {
		this.visiKlausimai = new ArrayList<Klausimas>();
	}

	public Klausimas isrinktiAtsitiktiniKlausima() {
		int klausimoVieta = (int) (Math.random() * visiKlausimai.size());
		Klausimas atsitiktinisKlausimas = visiKlausimai.get(klausimoVieta);
		return atsitiktinisKlausimas;
	}

	public Klausimas uzduotiKlausima() {
		Klausimas klausimas = isrinktiAtsitiktiniKlausima();
		return klausimas;
	}

	public String pateiktiUzuomina(Klausimas klausimas) {
		return klausimas.getUzuomina();
	}

	public String pateiktiAtsakyma(Klausimas klausimas) {
		return klausimas.getAtsakymas();
	}

	public void itrauktiNaujaKlausima(String klausimoFormuluote, String papildomaInformacija, String uzuomina,
			String atsakymas, String mokytojas) {
		Klausimas naujasKlausimas = new Klausimas(klausimoFormuluote, papildomaInformacija, uzuomina, atsakymas,
				mokytojas);
		visiKlausimai.add(naujasKlausimas);
	}

	public void istrintiKlausima(int klausimoIrasoVieta) {
		visiKlausimai.remove(klausimoIrasoVieta);
	}

	public void istrintiKlausima(Klausimas klausimas) {
		visiKlausimai.remove(klausimas);
	}
	
	@Override
	public String toString (){
		return this.getVardas();
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
