package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Distributeur extends JoueurIA {

	public Distributeur(String nom, int degreeStrat) {
		super(nom, degreeStrat);
		// TODO Auto-generated constructor stub
	}

	public Pioche distribuer(HashSet<JeuDeCartes> setJeuDeCartes,
			LinkedList<Joueur> lj) {
		LinkedList<Carte> l = new LinkedList<Carte>();
		for (Iterator<JeuDeCartes> iterator = setJeuDeCartes.iterator(); iterator
				.hasNext();) {
			JeuDeCartes jdc = (JeuDeCartes) iterator.next();
			l.addAll((LinkedList<Carte>) jdc.getLs());
		}
		Pioche pioche = new Pioche();
		distribuerCartesEnmMain(l, lj);
		distribuerCartesVisibles(l, lj);
		distribuerCartesCachees(l, lj);
		return pioche;
	}

	public void distribuerCartesVisibles(LinkedList<Carte> l,
			LinkedList<Joueur> lj) {
		for (int i = 1; i <= 3; i++) {
			for (Iterator<Joueur> it = lj.iterator(); it.hasNext();) {
				Joueur joueur = (Joueur) it.next();
				joueur.ajouterCartefacsVisible((l.pop()));
			}
		}
	}

	/**
	 * @return
	 */
	public void distribuerCartesCachees(LinkedList<Carte> l,
			LinkedList<Joueur> lj) {
		for (int i = 1; i <= 3; i++) {
			for (Iterator<Joueur> it = lj.iterator(); it.hasNext();) {
				Joueur joueur = (Joueur) it.next();
				joueur.ajouterCarteFaceCachee(l.pop());
			}
		}
	}

	/**
	 * @return
	 */
	public void distribuerCartesEnmMain(LinkedList<Carte> l,
			LinkedList<Joueur> lj) {
		for (int i = 1; i <= 3; i++) {
			for (Iterator<Joueur> it = lj.iterator(); it.hasNext();) {
				Joueur joueur = (Joueur) it.next();
				joueur.ajouterCarteEnMain(l.pop());
			}
		}
	}
 }
