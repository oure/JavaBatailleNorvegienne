package jeu;

import java.util.*;

public class Pioche {

	/** Instance unique non preinitialisee */

	private static  LinkedList<Carte> listeDeCarte = null;
	
	/** Constructeur prive */
	public Pioche()
	{}
	
	public static LinkedList<Carte> getListeDeCarte() {
		return listeDeCarte;
	}

	public void setListeDeCarte(LinkedList<Carte> listeDeCarte) {
		Pioche.listeDeCarte = listeDeCarte;
	}

	/** Point d'acc�s pour l'instance unique du singleton */

	private  LinkedList<Carte> getPioche() {
			return  listeDeCarte;
		
	}

	public String toString() {
		String s = "";
		for (Iterator<Carte> iterator = listeDeCarte.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			s += " " + carte.getValeur();
		}
		return "Pioche " + s;
	}

	/*
	 * Cette methode supprime tous les elements de cette liste .
	 */
	public void viderPioche() {
		listeDeCarte.clear();
	}

	/*
	 * recuperer et supprimer le dernier element de la liste
	 */
	public Carte prendreCarte() {
		return listeDeCarte.pollLast();
	}
	/*
	 * Retourne vrai si la liste est vide
	 */
	public boolean isEmpty() {
		return listeDeCarte.isEmpty();

	}
}
