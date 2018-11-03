package lt.balt.virtualusmokytojas.pasnekovai;

import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Senolis extends Pasnekovas {

	public Senolis() {
		super.setVardas("Senolis");
		super.setVisiKlausimai(KlausimuKlase.gautiKlausimusPasnekovuiIsDB(this.getVardas()));
		super.setIsvaizda("resources/images/PasnekovasSenolis.jpg");
	}

}
