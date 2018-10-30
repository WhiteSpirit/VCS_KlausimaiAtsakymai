package lt.balt.virtualusmokytojas.pasnekovai;

import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Senolis extends Pasnekovas {

	public Senolis() {
		super.setVisiKlausimai(KlausimuKlase.getKlausimaiSenoliui());
		super.setVardas("Senolis");
		super.setIsvaizda("src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/PasnekovasSenolis.jpg");
	}

}
