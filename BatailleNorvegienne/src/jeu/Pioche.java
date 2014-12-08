package jeu;

import java.util.*;

public class Pioche {

	/** Instance unique non preinitialisee */

	private static LinkedList<Carte> listeDeCarte = null;

	/** Constructeur prive */
	public Pioche() {
	}

	public static LinkedList<Carte> getListeDeCarte() {
		return listeDeCarte;
	}

	public void setListeDeCarte(LinkedList<Carte> listeDeCarte) {
		Pioche.listeDeCarte = listeDeCarte;
	}

	/** Point d'acc�s pour l'instance unique du singleton */

	public static LinkedList<Carte> getPioche() {

		if (listeDeCarte == null) {
			listeDeCarte = new LinkedList<Carte>();
		} else {
			System.out.println("la pioche est deja creer");
		}
		return listeDeCarte;

	}

	public String toString() {
		String s = "";
		for (Iterator<Carte> iterator = listeDeCarte.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			s += " " +carte;
		}
		return "Pioche : " + s;
	}

	/*
	 * Cette methode supprime tous les elements de cette liste .
	 */
	public void viderPioche() {
		listeDeCarte.clear();
	}

	public Carte prendreCarte() { // r�cup�rer et supprimer le dernier �l�ment
									// de la liste
		return listeDeCarte.pollLast();
	}

	/*
	 * Retourne vrai si la liste est vide
	 */
	public boolean isEmpty() {
		return listeDeCarte.isEmpty();

	}
}
