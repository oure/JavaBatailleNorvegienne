package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 */
public class Distributeur extends JoueurIA {

	public Distributeur(String nom, int degreeStrat) {
		super(nom, degreeStrat);
		// TODO Auto-generated constructor stub
	}
	public Pioche distribuer(HashSet<JeuDeCartes> setJeuDeCartes,LinkedList<Joueur> lj){
		Pioche pioche = new Pioche();
		distribuer_cartes_main(setJeuDeCartes,lj);
		distribuer_cartes_visibles(setJeuDeCartes,lj);
		distribuer_cartes_cachees(setJeuDeCartes,lj);
		return pioche;
	}
	public void distribuer_cartes_visibles(HashSet<JeuDeCartes> setJeuDeCartes,LinkedList<Joueur> lj) {
	}

	/**
	 * @return
	 */
	public void distribuer_cartes_cachees(HashSet<JeuDeCartes> setJeuDeCartes,LinkedList<Joueur> lj) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public void distribuer_cartes_main(HashSet<JeuDeCartes> setJeuDeCartes,LinkedList<Joueur> lj) {
		for (Iterator<Joueur> it = lj.iterator(); it.hasNext();) {
			Joueur j = (Joueur) it.next();
			
		}
	}
}
