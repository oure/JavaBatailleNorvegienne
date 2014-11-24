package jeu;

import java.util.HashSet;

public class CartesfacesVisibles {
	private HashSet<Carte> hs=new HashSet<Carte>();
	
	public void addAll(HashSet<Carte> s) {
		hs.addAll(s);
	}

	public HashSet<Carte> getHs() {
		return hs;
	}

	public void setHs(HashSet<Carte> hs) {
		this.hs = hs;
	}

	public void ajouterCarteMain(Carte car) {
		hs.add(car);
	}

	@Override
	public String toString() {
		return "CartesfacesVisibles [hs=" + hs + "]";
	}
	public boolean isEmpty(){
		return hs.isEmpty();
	}
}
