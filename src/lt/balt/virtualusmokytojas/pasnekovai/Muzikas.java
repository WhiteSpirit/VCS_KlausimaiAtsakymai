package lt.balt.virtualusmokytojas.pasnekovai;

import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Muzikas extends Pasnekovas {

	public Muzikas() {
		super.setVardas("Muzikas");
		super.setVisiKlausimai(KlausimuKlase.gautiKlausimusPasnekovuiIsDB(this.getVardas()));
		super.setIsvaizda("resources/images/PasnekovasMuzikas.jpg");
	}

}
