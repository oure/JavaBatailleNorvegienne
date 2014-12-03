package jeu;

import java.util.*;

/**
 * 
 */
public class Table {
	private LinkedList<Carte> liste = new LinkedList<Carte>();

	public void viderTas() {
		liste.clear();
	}

	/**
	 * @return
	 */
	public Carte afficherDerniereCarteDuTas() {
		return liste.getLast();
	}

	public void ajouterCarteALaTable(Carte ca) {
		liste.add(ca);
	}

	public LinkedList<Carte> getListe() {
		return liste;
	}

	/**
	 * @param Carte
	 */
	public void ajouterCarteTable(HashSet<Carte> ca) {
		for (Iterator<Carte> iterator = ca.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			liste.add(carte);
			ca.remove(carte);
		}
	}

	public void setListe(LinkedList<Carte> liste) {
		this.liste = liste;
	}

	@Override
	public String toString() {
		return "Table [liste=" + liste + "]";

	}
}
