package jeu;

public class Carte {
	int valeur, couleur;
	private boolean estVisible;

	public Carte(int v, int c) {
		if (v >= 1 && v <= 13) {
			valeur = v;
		} else {
			System.out.println("Erreur: problème de valeurs !");
			System.exit(0);
		}
		if (c >= 0 && c < 5) {
			couleur = c;
		} else {
			System.out.println("Erreur: problème de valeurs !");
			System.exit(0);
		}
	}

	public int getValeur() {
		return valeur;
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
}
