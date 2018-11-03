package lt.balt.virtualusmokytojas.pasnekovai;

import java.util.ArrayList;

import lt.balt.virtualusmokytojas.Klausimas;
import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Eruditas extends Pasnekovas {

	public Eruditas() {
		super.setVardas("Eruditas");
		ArrayList<Klausimas> klausimaiEruditui = new ArrayList<Klausimas>();
		klausimaiEruditui.addAll(KlausimuKlase.gautiKlausimusPasnekovuiIsDB("Matematikas"));
		klausimaiEruditui.addAll(KlausimuKlase.gautiKlausimusPasnekovuiIsDB("Muzikas"));
		klausimaiEruditui.addAll(KlausimuKlase.gautiKlausimusPasnekovuiIsDB("Senolis"));
		klausimaiEruditui.addAll(KlausimuKlase.gautiKlausimusPasnekovuiIsDB("Stiuardesė"));
		super.setVisiKlausimai(klausimaiEruditui);
		super.setIsvaizda("resources/images/PasnekovasEruditas.jpg");
	}

}
