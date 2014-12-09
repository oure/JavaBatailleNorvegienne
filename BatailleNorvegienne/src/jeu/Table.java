package jeu;

import java.util.*;

/**
 * 
 */
public class Table {
	private LinkedList<Carte> liste = new LinkedList<Carte>();
	private HashSet<Carte> derniereCartesPoses=new HashSet<Carte>();
	
	public void viderTas() {
		liste.clear();
	}

	public HashSet<Carte> getDerniereCartesPoses() {
		return derniereCartesPoses;
	}

	public void setDerniereCartesPoses(HashSet<Carte> derniereCartesPoses) {
		this.derniereCartesPoses = derniereCartesPoses;
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
	public void ajouterCarteTable(HashSet<Carte> hashSetCartes) {
		for (Iterator<Carte> iterator = hashSetCartes.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			liste.add(carte);
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
