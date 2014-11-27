package jeu;

import java.util.HashSet;
import java.util.Iterator;

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

	public void ajouterCarteVisible(Carte car) {
		hs.add(car);
	}
	public void supCarteVisible(Carte car) {
		hs.remove(car);
	}
public void afficherCarteVisibles(){
	for (Iterator<Carte> iterator = hs.iterator(); iterator.hasNext();) {
		Carte carte = (Carte) iterator.next();
		System.out.print(carte.getValeur()+" "+carte.getCouleur()+"  ");
	}
}
	@Override
	public String toString() {
		return "CartesfacesVisibles [hs=" + hs + "]";
	}
	public boolean isEmpty(){
		return hs.isEmpty();
	}
}
