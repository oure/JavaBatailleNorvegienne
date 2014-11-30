package jeu;

import java.util.HashSet;
import java.util.LinkedList;
import jeu.Carte.Couleur;

public class Test {

	public static void main(String[] args) {
		 HashSet<Carte> mm = new HashSet<Carte>();
		  HashSet<Carte> l = new HashSet<Carte>();
		LinkedList<Carte> n=new LinkedList<Carte>();
		n.add(new Carte(1, Couleur.Pique));
		n.add(new Carte(8, Couleur.Pique));
		n.add(new Carte(13, Couleur.Pique));

		mm.add(new Carte(1, Couleur.Pique));
		mm.add(new Carte(8, Couleur.Coeur));
		mm.add(new Carte(10, Couleur.Carreau));
		l.add(new Carte(2, Couleur.Pique));
		l.add(new Carte(2, Couleur.Coeur));
		l.add(new Carte(2, Couleur.Carreau));
		 
		// print the list
	     
		System.out.println(n);
		System.out.println(n.getLast());

	  
	      
		
		
		}
	
}
