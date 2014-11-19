package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Joueur {
	String nom;
	Set<Carte> set = new HashSet<Carte>();

	public Joueur(String nom) {
		this.nom = nom;
	}

	public void recevoirCarte(Carte carte) {
		set.add(carte);
	}

	public String toString() {
		String ss = null;
		for (Iterator<Carte> iterator=set.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			ss += carte.getValeur() + " ";
		}
		return "Nom : " + nom + ", Carte(s) : "+ss;
	}
}
