package lt.balt.virtualusmokytojas.pasnekovai;

import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Stiuardese extends Pasnekovas {

	public Stiuardese() {
		super.setVisiKlausimai(KlausimuKlase.getKlausimaiStiuardesei());
		super.setVardas("Stiuardesė");
		super.setIsvaizda("resources/images/PasnekoveStiuardese.jpg");
	}

}
