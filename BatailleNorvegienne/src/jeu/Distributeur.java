package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Distributeur extends JoueurIA {

	private LinkedList<Carte> ListeDeCarte = new LinkedList<Carte>();

	public Distributeur(String nom, int degreeStrat) {
		super(nom, degreeStrat);
		// TODO Auto-generated constructor stub
	}

	public Pioche distribuer(HashSet<JeuDeCartes> setJeuDeCartes,
			LinkedList<Joueur> lj) {
		for (Iterator<JeuDeCartes> iterator = setJeuDeCartes.iterator(); iterator
				.hasNext();) {
			JeuDeCartes jdc = (JeuDeCartes) iterator.next();
			ListeDeCarte.addAll((LinkedList<Carte>) jdc.getLs());
		}
		for (Iterator<Carte> it = ListeDeCarte.iterator(); it.hasNext();) {
			Carte carte = (Carte) it.next();
			System.out.print(carte.getValeur() + "-");

		}
		Pioche pioche = new Pioche();
		distribuerCartesEnmMain(lj);
		distribuerCartesVisibles(lj);
		distribuerCartesCachees(lj);
		pioche.setListeDeCarte(ListeDeCarte);
		return pioche;
	}

	public LinkedList<Carte> getL() {
		return ListeDeCarte;
	}

	public void setL(LinkedList<Carte> l) {
		this.ListeDeCarte = l;
	}

	public void distribuerCartesVisibles(LinkedList<Joueur> lj) {
		for (int i = 1; i <= 3; i++) {
			for (Iterator<Joueur> it = lj.iterator(); it.hasNext();) {
				Joueur joueur = (Joueur) it.next();
				joueur.ajouterCartefacsVisible((ListeDeCarte.pop()));
			}
		}
	}

	/**
	 * @return
	 */
	public void distribuerCartesCachees(LinkedList<Joueur> lj) {
		for (int i = 1; i <= 3; i++) {
			for (Iterator<Joueur> it = lj.iterator(); it.hasNext();) {
				Joueur joueur = (Joueur) it.next();
				joueur.ajouterCarteFaceCachee(ListeDeCarte.pop());
			}
		}
	}

	/**
	 * @return
	 */
	public void distribuerCartesEnmMain(LinkedList<Joueur> lj) {
		for (int i = 1; i <= 3; i++) {
			for (Iterator<Joueur> it = lj.iterator(); it.hasNext();) {
				Joueur joueur = (Joueur) it.next();
				joueur.ajouterCarteEnMain(ListeDeCarte.pop());
			}
		}
	}
}
