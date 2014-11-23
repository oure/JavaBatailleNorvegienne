package jeu;

import java.util.HashSet;

public class CartesfacesVisibles {
	HashSet<Carte> hs=new HashSet<Carte>();
	public void addAll(HashSet<Carte> s) {
		hs.addAll(s);
	}

	public void ajouterCarteMain(Carte car) {
		hs.add(car);
	}

	@Override
	public String toString() {
		return "CartesfacesVisibles [hs=" + hs + "]";
	}
	
}
