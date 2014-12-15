package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class CartesFacesCachees {
	private HashSet<Carte> cartesCachees = new HashSet<Carte>();

	@Override
	public String toString() {
		return cartesCachees.toString();
	}

	public HashSet<Carte> getCartesCachees() {
		return cartesCachees;
	}

	public void setCartesCachees(HashSet<Carte> cartesCachees) {
		this.cartesCachees = cartesCachees;
	}

	public Carte prendreAuhasard(){
		int compteur=1;
		int occurenceCiblee;
		if (cartesCachees.size()>1){
			Random r=new Random();
			occurenceCiblee=1 + r.nextInt(cartesCachees.size() - 1);
		}
		else 
			occurenceCiblee=1;
		for (Iterator<Carte> iterator = cartesCachees.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.println(" \t " + carte);
			if (compteur==occurenceCiblee){
				cartesCachees.remove(carte);
				return carte;
			}
			compteur++;
		}
		return null;
	}

	public void addAll(HashSet<Carte> s) {
		cartesCachees.addAll(s);
	}

	public boolean isEmpty() {
		return cartesCachees.isEmpty();
	}

	public void afficherCarteRetournees() {
		for (Iterator<Carte> iterator = cartesCachees.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.print(carte.getValeur() + " " + carte.getCouleur()
					+ "  ");
		}
	}

	public void ajouterUnecarteFaceCachee(Carte car) {
		cartesCachees.add(car);
	}
}
