package jeu;

public class Carte {
	enum Couleur {
		Pique, Coeur, Carreau, Trefle
	};

	int valeur;
	Couleur couleur;
	private boolean estVisible;

	public Carte(int v, Couleur c) {
		if (v >= 1 && v <= 13) {
			valeur = v;
		} else {
			System.out.println("Erreur: problème de valeurs !");
			System.exit(0);
		}
		if (c == Couleur.Pique || c == Couleur.Coeur || c == Couleur.Carreau
				|| c == Couleur.Trefle) {
			couleur = c;
		} else {
			System.out.println("Erreur: probleme de valeurs !");
			System.exit(0);
		}
	}

	public Carte(int v) {

		valeur = v;
	}

	public int getValeur() {
		return valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public boolean isEstVisible() {
		return estVisible;
	}

	public void setEstVisible(boolean estVisible) {
		this.estVisible = estVisible;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return valeur + " " + couleur;
	}

}
