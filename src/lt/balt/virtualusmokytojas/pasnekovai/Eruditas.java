package lt.balt.virtualusmokytojas.pasnekovai;

import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Eruditas extends Pasnekovas {

	public Eruditas() {
		super.setVisiKlausimai(KlausimuKlase.getKlausimaiEruditui());
		super.setVardas("Eruditas");
		super.setIsvaizda("resources/images/PasnekovasEruditas.jpg");
	}

}
