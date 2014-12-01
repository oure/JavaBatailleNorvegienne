package jeu;

import java.util.*;

public class Pioche {
	
	/** Instance unique non preinitialisee */

	private static  LinkedList<Carte> listeDeCarte = null;
	
	/** Constructeur prive */
	public Pioche()
	{}
	
	/** Point d'acc�s pour l'instance unique du singleton */

	public static  LinkedList<Carte> getPioche() {
				
			if (listeDeCarte == null)
			{ 	listeDeCarte = new LinkedList<Carte>();
			}
			else{System.out.println("la pioche est d�ja creer");
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

	public void vider_pioche() {  //Cette m�thode supprime tous les �l�ments de cette liste .
	      listeDeCarte.clear();

	}

	public Carte prendreCarte() { //r�cup�rer et supprimer le dernier �l�ment de la liste
		return listeDeCarte.pollLast();
	}

	public boolean isEmpty() {
    return listeDeCarte.isEmpty();
		  
	}

	public Carte remove(int j) { //Cette methode supprime et retourne le dernier �l�ment de cette liste 
	      listeDeCarte.removeLast();
		return null;
	}
	public static void main(String[] args) {
		
		Pioche  pio = new Pioche();
		Pioche che =new Pioche();
		System.out.println(pio);
		System.out.println(che);

		
		
	}
	  
}
