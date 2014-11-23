package jeu;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 
 */
public class Distributeur extends JoueurIA {

	public Distributeur(String nom, int degreeStrat) {
		super(nom, degreeStrat);
		// TODO Auto-generated constructor stub
	}
	public void distribuer(HashSet<JeuDeCartes> setJeuDeCartes,LinkedList<Joueur> lj){
		distribuer_cartes_main();
		distribuer_cartes_visibles();
		distribuer_cartes_cachees();
	}
	public void distribuer_cartes_visibles() {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public void distribuer_cartes_cachees() {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public void distribuer_cartes_main() {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public void melanger() {
		// TODO implement here
	}

}
