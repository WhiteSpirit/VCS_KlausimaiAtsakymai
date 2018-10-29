package lt.balt.virtualusmokytojas;

import java.util.ArrayList;
import lt.balt.virtualusmokytojas.pasnekovai.*;

public class PokalbiuKambarys {

	private ArrayList<Pasnekovas> visiPasnekovai;

	public PokalbiuKambarys() {
		this.visiPasnekovai = new ArrayList<Pasnekovas>();
		this.visiPasnekovai.add(new Matematikas());
		this.visiPasnekovai.add(new Muzikas());
		this.visiPasnekovai.add(new Senolis());
		this.visiPasnekovai.add(new Stiuardese());
		this.visiPasnekovai.add(new Eruditas());
	}

	public Pasnekovas isrinktiAtsitiktiniPasnekova() {
		int pasnekovoVieta = (int) (Math.random() * visiPasnekovai.size());
		Pasnekovas atsitiktinisPasnekovas = visiPasnekovai.get(pasnekovoVieta);
		return atsitiktinisPasnekovas;
	}

	void istrintiPasnekova(int pasnekovoVieta) {
		visiPasnekovai.remove(pasnekovoVieta);
	}

	public ArrayList<Pasnekovas> getVisiPasnekovai() {
		return visiPasnekovai;
	}

	public void setVisiPasnekovai(ArrayList<Pasnekovas> visiPasnekovai) {
		this.visiPasnekovai = visiPasnekovai;
	}

}
