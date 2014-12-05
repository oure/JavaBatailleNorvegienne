package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class CartesFacesCachees {
	private HashSet<Carte> hs = new HashSet<Carte>();

	@Override
	public String toString() {
		return hs.toString();
	}
	public Carte prendreAuhasard(){
		int compteur=1;
		Carte carteQueLonApris;
		Random r=new Random();
		int occurenceCiblee=1 + r.nextInt(hs.size() - 1);
		for (Iterator<Carte> iterator = hs.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (compteur==occurenceCiblee){
				carteQueLonApris= carte;
				hs.remove(carteQueLonApris);
				return carteQueLonApris;
			}
		}
		return null;
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
