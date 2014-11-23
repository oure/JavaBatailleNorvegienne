package jeu;
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import jeu.Carte.Couleur;

public class JeuDeCartes {

	LinkedList<Carte> ls = new LinkedList<Carte>();
	public List<Carte> getLs() {
		return ls;
	}

	public void setLs(LinkedList<Carte> ls) {
		this.ls = ls;
	}


	public JeuDeCartes() {
		for (int i = 1; i <= 13; i++) {
			for (int j = 1; j <= 4; j++) {
				switch (j) {
				case 1:
					ls.add(new Carte(i, Couleur.Pique));
					break;
				case 2:
					ls.add(new Carte(i, Couleur.Coeur));

					break;
				case 3:
					ls.add(new Carte(i, Couleur.Carreau));

					break;
				case 4:
					ls.add(new Carte(i, Couleur.Trefle));

					break;
				}

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

	public String toString() {
		String ss = "";
		for (int i = 0; i < ls.size(); i++) {
			ss += " " + ls.get(i).getValeur();
		}
		return ss;
	}
}
