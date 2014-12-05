package jeu;

import java.util.HashSet;
import java.util.Iterator;

public class CartesfacesVisibles {
	private HashSet<Carte> hs = new HashSet<Carte>();

	public void addAll(HashSet<Carte> s) {
		hs.addAll(s);
	}

	public HashSet<Carte> getHs() {
		return hs;
	}

	public void setHs(HashSet<Carte> hs) {
		this.hs = hs;
	}

	public void ajouterCarteVisible(Carte car) {
		hs.add(car);
	}

	public HashSet<Carte> supCarteVisible(int valeur, int nombreOccurence) {
		int i = 0;
		HashSet<Carte> hc = new HashSet<Carte>();
		for (Iterator<Carte> iterator = hs.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (i >= nombreOccurence)
				break;
			if (carte.getValeur() == valeur) {
				i++;
				hc.add(carte);
			}
		}
		hs.removeAll(hc);
		return hc;
	}

	public void afficherCarteVisibles() {
		for (Iterator<Carte> iterator = hs.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.print(carte.getValeur() + " " + carte.getCouleur()
					+ "  ");
		}
	}

	@Override
	public String toString() {
		return hs.toString();
	}

	public boolean isEmpty() {
		return hs.isEmpty();
	}
}
