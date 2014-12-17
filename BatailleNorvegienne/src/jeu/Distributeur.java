package jeu;
/**
 * La classe Distributeur
 *le distributeur est,en plus d'un joueur, celui qui melange et distribue les cartes 
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Distributeur extends JoueurIA {
/**
 * constructeur de la classe  Distributeur qui appelle le constructeur de sa classe mère
 * @param strat
 */
	public Distributeur(Strategie strat) {
		super(strat);
	}
	/**
	 * cette classe prend un  attribut de type linkedlist
	 */

	private LinkedList<Carte> ListeDeCarte = new LinkedList<Carte>();

	/**
	 * Ceci est  la methode pour la distribution des cartes
	 * @param setJeuDeCartes de type hashset
	 * @param lj: de type linkedlist, est la liste des joueurs
	 * @return une pioche
	 */
	public Pioche distribuer(HashSet<JeuDeCartes> setJeuDeCartes, LinkedList<Joueur> lj) {
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
/**
 * Cette methode distribue des cartes de face visible a une liste de joueurs
 * @param lj
 */
	public void distribuerCartesVisibles(LinkedList<Joueur> lj) {
		for (int i = 1; i <= 3; i++) {
			for (Iterator<Joueur> it = lj.iterator(); it.hasNext();) {
				Joueur joueur = (Joueur) it.next();
				joueur.ajouterCartefacsVisible((ListeDeCarte.pop()));
			}
		}
	}

	/**
	 *  * Methode pour distribuer des cartes de face cachee a une liste de joueurs
	 * @param lj
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
	 * Methode pour distribuer des cartes en main a une liste de joueurs
	 * @param lj
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
