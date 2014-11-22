package jeu;

import java.util.Iterator;
import java.util.LinkedList;

public class Carte {
	
	int valeur;
	public Carte(int v){
		valeur=v;
	}
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	/**
	 * Retourne le joueur qui a la carte la plus grosse
	 * sinon renvoie -1
	 **/
	public int comparer(LinkedList<Carte> st){
		int val;
		for (Iterator<Carte> iterator = st.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			val=carte.getValeur();
			if(val>carte.getValeur())
				
		}
		return val; 
	}
	
}
