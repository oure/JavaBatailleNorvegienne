package jeu;

import java.util.HashSet;

public class CartesEnMain {
	private HashSet<Carte> cartemain = new HashSet<Carte>();

	public void addAll(HashSet<Carte> s) {
		cartemain.addAll(s);
	}

	public void ajouterCarteMain(Carte car) {
		cartemain.add(car);
	}

	@Override
	public String toString() {
		return "CartesEnMain [cartemain=" + cartemain + "]";
	}
	
}
