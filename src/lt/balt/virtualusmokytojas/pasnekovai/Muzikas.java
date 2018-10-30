package lt.balt.virtualusmokytojas.pasnekovai;

import lt.balt.virtualusmokytojas.KlausimuKlase;

public class Muzikas extends Pasnekovas {

	public Muzikas() {
		super.setVisiKlausimai(KlausimuKlase.getKlausimaiMuzikui());
		super.setVardas("Muzikas");
		super.setIsvaizda("src/lt/balt/virtualusmokytojas/grafika/paveiksleliai/PasnekovasMuzikas.jpg");
	}

}
