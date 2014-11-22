package jeu;

public class JoueurIA extends Joueur {
	int degreeStrat;

	public JoueurIA(String nom, int degreeStrat) {
		super(nom);
		this.degreeStrat = degreeStrat;
		// TODO Auto-generated constructor stub
	}

	public void jouer(Carte c, int i) {
		super.jouer(c, i);
	}
}
