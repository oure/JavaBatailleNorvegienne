package jeu;

import java.util.HashSet;

public class CartesEnMain {
	private HashSet<Carte> cartemain = new HashSet<Carte>();

	public void addAll(HashSet<Carte> s) {
		cartemain.addAll(s);
	}
	public void remplacer(Carte c){
		
	}
	public void ajouterCarteMain(Carte car) {
		cartemain.add(car);
	}
	
	public HashSet<Carte> getCartemain() {
		return cartemain;
	}

	public void setCartemain(HashSet<Carte> cartemain) {
		this.cartemain = cartemain;
	}

	@Override
	public String toString() {
		return "CartesEnMain [cartemain=" + cartemain + "]";
	}
	public boolean isEmpty(){
		return cartemain.isEmpty();
	}
	
}
