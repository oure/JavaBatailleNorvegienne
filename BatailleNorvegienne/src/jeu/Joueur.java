package jeu;

public class Joueur {
	private String nom;
	private CartesEnMain cartesEnMain;
	private CartesfacesVisibles cartefaceVisibles;
	private CartesFacesCachees carteFacesCachees;

	public CartesEnMain getCem() {
		return cartesEnMain;
	}

	public void setCem(CartesEnMain cem) {
		this.cartesEnMain = cem;
	}

	public CartesfacesVisibles getCfv() {
		return cartefaceVisibles;
	}

	public void setCfv(CartesfacesVisibles cfv) {
		this.cartefaceVisibles = cfv;
	}

	public CartesFacesCachees getCfc() {
		return carteFacesCachees;
	}

	public void setCfc(CartesFacesCachees cfc) {
		this.carteFacesCachees = cfc;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Joueur(String nom) {
		this.nom = nom;
	}

//	public String toString() {
//		String ss = "";
//		for (Iterator<Carte> iterator = cartesEnMain.iterator(); iterator.hasNext();) {
//			Carte carte = (Carte) iterator.next();
//			ss += carte.getValeur() + " ";
//		}
//		if (ss != "")
//			return "Nom : " + nom + ", Carte(s) : " + ss;
//		else
//			return "Nom : " + " pas de carte";
//	}
}
