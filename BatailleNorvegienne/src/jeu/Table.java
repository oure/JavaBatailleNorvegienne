package jeu;

import java.util.*;

/**
 * 
 */
public class Table {
private	LinkedList<Carte> liste = new LinkedList<Carte>();

    /**
     * @return
     */
    public void viderTable() {
    	  liste.clear();  
    }

    /**
     * @return
     */
    public Carte afficherDerniereCarteDuTas() {
        return liste.getLast();
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

	public LinkedList<Carte> getListe() {
		return liste;
	}

	public void setListe(LinkedList<Carte> liste) {
		this.liste = liste;
	}

}