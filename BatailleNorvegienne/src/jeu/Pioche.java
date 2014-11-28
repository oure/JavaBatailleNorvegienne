package jeu;

import java.util.*;

public class Pioche {
	LinkedList<Carte> listeDeCarte = new LinkedList<Carte>();

	public Pioche() {
	}

	public Pioche(LinkedList<Carte> lcc) {
		listeDeCarte = lcc;
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

	public LinkedList<Carte> getLkc() {
		return listeDeCarte;
	}

	public void setLkc(LinkedList<Carte> lkc) {
		this.listeDeCarte = lkc;
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
