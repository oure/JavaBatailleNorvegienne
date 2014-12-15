package jeu;

import java.util.HashSet;
import java.util.Iterator;

public class CartesfacesVisibles {
	private HashSet<Carte> cartesVisibles = new HashSet<Carte>();

	public void addAll(HashSet<Carte> s) {
		cartesVisibles.addAll(s);
	}

	public HashSet<Carte> getCartesVisibles() {
		return cartesVisibles;
	}

	public void setHs(HashSet<Carte> hs) {
		this.cartesVisibles = hs;
	}

	public void ajouterCarteVisible(Carte car) {
		cartesVisibles.add(car);
	}

	public HashSet<Carte> supCarteVisible(int valeur, int nombreOccurence) {
		int i = 0;
		HashSet<Carte> hc = new HashSet<Carte>();
		for (Iterator<Carte> iterator = cartesVisibles.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (i >= nombreOccurence)
				break;
			if (carte.getValeur() == valeur) {
				i++;
				hc.add(carte);
			}
		}
		cartesVisibles.removeAll(hc);
		return hc;
	}

	public void afficherCarteVisibles() {
		for (Iterator<Carte> iterator = cartesVisibles.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.print(carte.getValeur() + " " + carte.getCouleur()
					+ "  ");
		}
	}

	@Override
	public String toString() {
		return cartesVisibles.toString();
	}

	public boolean isEmpty() {
		return cartesVisibles.isEmpty();
	}
}
