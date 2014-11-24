package jeu;

import java.util.*;

public class Pioche {
	LinkedList<Carte> listeDeCarte = new LinkedList<Carte>();
	
	public Pioche() {
	}

	public Pioche(LinkedList<Carte> lcc) {
		listeDeCarte = lcc;
	}
	public String toString(){
		String s="";
		for (Iterator iterator = listeDeCarte.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			s+=" "+carte.getValeur();
		}
		return "Pioche "+s;
	}
	public LinkedList<Carte> getLkc() {
		return listeDeCarte;
	}

	public void setLkc(LinkedList<Carte> lkc) {
		this.listeDeCarte = lkc;
	}

	public void vider_pioche() {
		// TODO implement here
	}

	public Carte prendre_carte() {
		// TODO implement here
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object remove(int j) {
		// TODO Auto-generated method stub
		return null;
	}

}
