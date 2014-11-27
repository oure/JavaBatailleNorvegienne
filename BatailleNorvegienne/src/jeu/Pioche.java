package jeu;

import java.util.*;

public class Pioche {
	
	/** Instance unique non preinitialisee */

	private static  LinkedList<Carte> listeDeCarte = null;
	
	/** Constructeur privé */
	private Pioche()
	{}
	
	/** Point d'accès pour l'instance unique du singleton */

	private static  LinkedList<Carte> getPioche() {
				
			if (listeDeCarte == null)
			{ 	listeDeCarte = new LinkedList<Carte>();
			}
			return  listeDeCarte;
		
	}

	/*public Pioche(LinkedList<Carte> lcc) {
		listeDeCarte = lcc;
	}*/
	
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

	public void vider_pioche() {  //Cette méthode supprime tous les éléments de cette liste .
	      listeDeCarte.clear();

	}

	public Carte prendre_carte() { //récupérer et supprimer le dernier élément de la liste
		return listeDeCarte.pollLast();
	}

	public boolean isEmpty() {
    return listeDeCarte.isEmpty();
		  
	}

	public Carte remove(int j) { //Cette méthode supprime et retourne le dernier élément de cette liste 
	      listeDeCarte.removeLast();
		return null;
	}
	  
}
