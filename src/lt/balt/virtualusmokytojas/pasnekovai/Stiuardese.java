package lt.balt.virtualusmokytojas.pasnekovai;

import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Stiuardese extends Pasnekovas {

	public Stiuardese() {
		super.setVardas("Stiuardesė");
		super.setVisiKlausimai(KlausimuKlase.gautiKlausimusPasnekovuiIsDB(this.getVardas()));
		super.setIsvaizda("resources/images/PasnekoveStiuardese.jpg");
	}

}
