package jeu;

import java.util.HashSet;

public class CartesFacesCachees {
	private HashSet<Carte> hs = new HashSet<Carte>();

	public void addAll(HashSet<Carte> s) {
		hs.addAll(s);
	}

	public void ajouterUnecarteFaceCachee(Carte car) {
		hs.add(car);
	}
}
