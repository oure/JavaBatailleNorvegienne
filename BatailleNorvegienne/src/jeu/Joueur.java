package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Joueur {
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Carte> getSet() {
		return set;
	}

	public void setSet(Set<Carte> set) {
		this.set = set;
	}

	String nom;
	Set<Carte> set = new HashSet<Carte>();

	public Joueur(String nom) {
		this.nom = nom;
	}

	public void recevoirCarte(Carte carte) {
		set.add(carte);
	}

	public String toString() {
		String ss = "";
		for (Iterator<Carte> iterator=set.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			ss += carte.getValeur() + " ";
		}
		if (ss != "")
			return "Nom : " + nom + ", Carte(s) : "+ss;
		else 
			return "Nom : "+" pas de carte";
	}
}
