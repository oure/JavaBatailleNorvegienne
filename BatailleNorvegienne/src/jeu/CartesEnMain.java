package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CartesEnMain {
	private HashSet<Carte> cartemain = new HashSet<Carte>();

	public void addAll(Table tas) {
		for (Iterator<Carte> it = tas.getListe().iterator(); it.hasNext();) {
			Carte carte = (Carte) it.next();
			ajouterCarteMain(carte);

		}
	}

	public void add(Carte c) {
		cartemain.add(c);
	}

	public void remplacer(Carte c) {

	}

	public void ajouterCarteMain(Carte car) {
		cartemain.add(car);
	}

	public HashSet<Carte> supCarteMain(int valeur, int nombreOccurence) {
		int i = 0;
		System.out.println("supCarteMain : "+valeur+"  "+nombreOccurence);
		HashSet<Carte> hc=new HashSet<Carte>();
		for (Iterator<Carte> iterator = cartemain.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (i>=nombreOccurence) break;
			if (carte.getValeur() == valeur) {
				i++;
			hc.add(carte);
			}
		}
		cartemain.removeAll(hc);
		System.out.println(hc);
		return hc;
	}

	public HashSet<Carte> getCartemain() {
		return cartemain;
	}

	public void setCartemain(HashSet<Carte> cartemain) {
		this.cartemain = cartemain;
	}

	public void afficherCarteMain() {
		for (Iterator<Carte> iterator = cartemain.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.print(carte.getValeur() + " " + carte.getCouleur()
					+ "  ");

		}
	}

	@Override
	public String toString() {
		return cartemain.toString();
	}

	public boolean isEmpty() {
		return cartemain.isEmpty();
	}

}
