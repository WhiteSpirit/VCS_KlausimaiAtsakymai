package lt.balt.virtualusmokytojas.pasnekovai;

import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Matematikas extends Pasnekovas {

	public Matematikas() {
		super.setVardas("Matematikas");
		super.setVisiKlausimai(KlausimuKlase.gautiKlausimusPasnekovuiIsDB(this.getVardas()));
		super.setIsvaizda("resources/images/PasnekovasMatematikas.jpg");
	}

}
