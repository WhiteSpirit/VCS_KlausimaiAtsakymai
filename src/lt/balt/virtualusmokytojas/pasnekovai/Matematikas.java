package lt.balt.virtualusmokytojas.pasnekovai;

import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Matematikas extends Pasnekovas {

	public Matematikas() {
		super.setVisiKlausimai(KlausimuKlase.getKlausimaiMatematikui());
		super.setVardas("Matematikas");
		super.setIsvaizda("resources/images/PasnekovasMatematikas.jpg");
	}

}
