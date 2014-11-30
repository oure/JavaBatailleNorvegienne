package jeu;

import java.util.HashSet;
import java.util.Iterator;

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

	public void afficherCarteRetournees(){
	for (Iterator<Carte> iterator = hs.iterator(); iterator.hasNext();) {
		Carte carte = (Carte) iterator.next();
		System.out.print(carte.getValeur()+" "+carte.getCouleur()+"  ");
		}
	}
	public void ajouterUnecarteFaceCachee(Carte car) {
		hs.add(car);
	}
}
