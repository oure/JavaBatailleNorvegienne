package jeu;

import java.util.HashSet;

public class CartesFacesCachees {
	private HashSet<Carte> hs = new HashSet<Carte>();

	@Override
	public String toString() {
		return "CartesFacesCachees [hs=" + hs + "]";
	}

	public void addAll(HashSet<Carte> s) {
		hs.addAll(s);
	}

	public boolean isEmpty() {
		return hs.isEmpty();
	}

	public void ajouterUnecarteFaceCachee(Carte car) {
		hs.add(car);
	}
}
