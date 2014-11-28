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
		for (Iterator<Carte> iterator = listeDeCarte.iterator(); iterator.hasNext();) {
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

	public void vider_pioche() {  //Cette m�thode supprime tous les �l�ments de cette liste .
	      listeDeCarte.clear();

	}

	public Carte prendre_carte() { //r�cup�rer et supprimer le dernier �l�ment de la liste
		return listeDeCarte.pollLast();
	}

	public boolean isEmpty() {
    return listeDeCarte.isEmpty();
		  
	}

	public Carte remove(int j) { //Cette m�thode supprime et retourne le dernier �l�ment de cette liste 
	      listeDeCarte.removeLast();
		return null;
	}
	  
}
