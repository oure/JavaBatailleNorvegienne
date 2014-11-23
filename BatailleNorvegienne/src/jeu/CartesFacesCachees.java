package jeu;

import java.util.HashSet;

public class CartesFacesCachees {
	@Override
	public String toString() {
		return "CartesFacesCachees [hs=" + hs + "]";
	}

	private HashSet<Carte> hs = new HashSet<Carte>();

	public void addAll(HashSet<Carte> s) {
		hs.addAll(s);
	}

	public void ajouterUnecarteFaceCachee(Carte car) {
		hs.add(car);
	}
}
