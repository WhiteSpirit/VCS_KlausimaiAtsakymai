package lt.balt.virtualusmokytojas;

public class Klausimas {

	private String klausimoFormuluote;
	private String papildomaInformacija;
	private String uzuomina;
	private String atsakymas;
	private String mokytojas;

	public Klausimas(String klausimoFormuluote, String papildomaInformacija, String uzuomina, String atsakymas, String mokytojas) {
		this.klausimoFormuluote = klausimoFormuluote;
		this.papildomaInformacija = papildomaInformacija;
		this.uzuomina = uzuomina;
		this.atsakymas = atsakymas;
		this.mokytojas = mokytojas;
	}

	public String getKlausimoFormuluote() {
		return klausimoFormuluote;
	}

	public void setKlausimoFormuluote(String klausimoFormuluote) {
		this.klausimoFormuluote = klausimoFormuluote;
	}

	public String getPapildomaInformacija() {
		return papildomaInformacija;
	}

	public void setPapildomaInformacija(String papildomaInformacija) {
		this.papildomaInformacija = papildomaInformacija;
	}

	public String getUzuomina() {
		return uzuomina;
	}

	public void setUzuomina(String uzuomina) {
		this.uzuomina = uzuomina;
	}

	public String getAtsakymas() {
		return atsakymas;
	}

	public void setAtsakymas(String atsakymas) {
		this.atsakymas = atsakymas;
	}

	public String getMokytojas() {
		return mokytojas;
	}

	public void setMokytojas(String mokytojas) {
		this.mokytojas = mokytojas;
	}

}
