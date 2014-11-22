package jeu;

import java.util.Iterator;
import java.util.LinkedList;

public class Carte {
	int valeur, couleur;

	public Carte(int v, int c) {
		if (v >= 1 && v < 15) {
			valeur = v;
		} else {
			System.out.println("Erreur: problème de valeurs !");
			System.exit(0);
		}
		if (c >= 0 && c < 5) {
			couleur = c;
		} else {
			System.out.println("Erreur: problème de valeurs !");
			System.exit(0);
		}
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
