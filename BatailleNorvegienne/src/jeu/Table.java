package jeu;

import java.util.*;

/**
 * 
 */
public class Table {
private	HashSet<Carte> liste = new HashSet<Carte>();

    /**
     * @return
     */
    public void viderTas() {
    	  liste.clear();  
    }

    /**
     * @return
     */
    public Carte afficherDerniereCarteDuTas() {
        return liste.getLast();
    }
    

    public HashSet<Carte> getListe() {
		return liste;
	}

	public void setListe(HashSet<Carte> liste) {
		this.liste = liste;
	}

	/**
     * @param Carte 
     */
    public void ajouterCarteAuTas(HashSet<Carte> ca) {
    for (Iterator<Carte> iterator = ca.iterator(); iterator.hasNext();) {
	Carte carte = (Carte) iterator.next();
		liste.add(carte);
		ca.remove(carte);
    }
    }

}