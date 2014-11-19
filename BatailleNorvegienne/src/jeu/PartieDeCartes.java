package jeu;

import java.util.HashSet;
import java.util.Iterator;

public class PartieDeCartes {
	public static void main(String[] args) {
		JeuDeCartes jeuDeCarte=new JeuDeCartes();
		System.out.println("Jeu de 32 cartes : "+jeuDeCarte);
		jeuDeCarte.melanger();
		System.out.println("Jeu de 32 cartes melange : "+jeuDeCarte);
		HashSet<Joueur> lj = new HashSet<Joueur>();
		lj.add(new Joueur("Micky"));
		lj.add(new Joueur("Johnny"));
		lj.add(new Joueur("Joel"));
		jeuDeCarte.distribuer(lj);
		for (Iterator iterator = lj.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			System.out.println(joueur);
		}
	}
}
