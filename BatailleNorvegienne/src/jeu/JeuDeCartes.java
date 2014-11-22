package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class JeuDeCartes {
	public List<Carte> getLs() {
		return ls;
	}

	public void setLs(List<Carte> ls) {
		this.ls = ls;
	}

	List<Carte> ls = new ArrayList<Carte>();

	public JeuDeCartes() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				ls.add(new Carte(i + 1,0+1));
			}
		}
	}

	public void melanger() {
		Collections.shuffle((List<?>) ls);
	}

	public Carte prendre() {
		Carte carte = ls.get(ls.size() - 1);
		ls.remove(ls.size() - 1);
		return carte;
	}

	public void distribuer(HashSet<Joueur> lj) {
		while (!ls.isEmpty()) {
			for (Iterator<Joueur> iterator = lj.iterator(); iterator.hasNext();) {
				Joueur joueur = (Joueur) iterator.next();
				if (ls.isEmpty())
					break;
				joueur.recevoirCarte(prendre());
			}
		}
	}

	public String toString() {
		String ss = "";
		for (int i = 0; i < ls.size(); i++) {
			ss += " " + ls.get(i).getValeur();
		}
		return ss;
	}
}
