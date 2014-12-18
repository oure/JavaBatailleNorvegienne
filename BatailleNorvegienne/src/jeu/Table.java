package jeu;
/**
 * La classe table
 *C'est la table constitue par les cartes jouees pas les joueurs 
 */
import java.util.*;


public class Table {
	/**
	 * attributs de la classe table
	 */
	private LinkedList<Carte> liste = new LinkedList<Carte>();
	private HashSet<Carte> derniereCartesPoses=new HashSet<Carte>();
	/**
	 * Vider la table de toute ses cartes
	 */
	public void viderTable() {
		liste.clear();
	}

	public HashSet<Carte> getDerniereCartesPoses() {
		return derniereCartesPoses;
	}

	public void setDerniereCartesPoses(HashSet<Carte> derniereCartesPoses) {
		this.derniereCartesPoses = derniereCartesPoses;
	}

	/**
	 * affichage de la derniere carte jouee sur la table
	 * @return une carte
	 */
	public Carte afficherDerniereCarteDelaTable() {
		return liste.getLast();
	}
/**
 * Un joueur peut jouer sur la table grace  a cette methode
 * @param ca
 */
	public void ajouterCarteALaTable(Carte ca) {
		liste.add(ca);
		derniereCartesPoses.clear();
		derniereCartesPoses.add(ca);
	}

	public LinkedList<Carte> getListe() {
		return liste;
	}

	/**
	 * @param Carte
	 */
	/**
	 * cette methode servira au joueur qui veut jouer plus d une carte
	 * @param hashSetCartes
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
