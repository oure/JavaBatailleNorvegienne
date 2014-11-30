package jeu;

import java.util.HashSet;
import java.util.Iterator;



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
	public void supCarteMain(Carte car) {
		cartemain.remove(car);
	}
	public HashSet<Carte> getCartemain() {
		return cartemain;
	}
	
	public void setCartemain(HashSet<Carte> cartemain) {
		this.cartemain = cartemain;
	}

	public void afficherCarteMain(){
	for (Iterator<Carte> iterator = cartemain.iterator(); iterator.hasNext();) {
		Carte carte = (Carte) iterator.next();
		System.out.print(carte.getValeur()+" "+carte.getCouleur()+"  ");

	}
}
	@Override
	public String toString() {
		
		return "CartesEnMain [cartemain=" + cartemain + "]";
	}
	public boolean isEmpty(){
		return cartemain.isEmpty();
	}
	
}
