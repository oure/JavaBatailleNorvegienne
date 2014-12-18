package jeu;
/**
 * La classe Cartes de face cachee 
 * c'est l'ensemble des cartes  a face cachee qu'un joueur dispose sur la table 
 */
import java.util.HashSet;
import java.util.Iterator;

public class CartesfacesVisibles {
	/**
	 * cette classe prend un seul attribut de type hashset
	 */
	private HashSet<Carte> cartesVisibles = new HashSet<Carte>();

	/**cette methode permet d'ajouter  des cartes  sur la classe carte visible
	 * @ param s : un hashset
	 */
	public void addAll(HashSet<Carte> s) {
		cartesVisibles.addAll(s);
	}

	public HashSet<Carte> getCartesVisibles() {
		return cartesVisibles;
	}

	public void setHs(HashSet<Carte> hs) {
		this.cartesVisibles = hs;
	}
	/**cette methode permet d'ajouter une seule carte  sur les cartes visibles
	 * @ param c : une carte
	 */
	public void ajouterCarteVisible(Carte car) {
		cartesVisibles.add(car);
	}
	
	/**la methode  qui permet de supprimer des cartes  sur la classe carte visible
	 * @ param valeur : la valeur de la carte a supprimer
	 * @ param nombreOccurence: le nombre de cartes a supprimer
	  */
	

	public HashSet<Carte> supCarteVisible(int valeur, int nombreOccurence) {
		int i = 0;
		HashSet<Carte> hc = new HashSet<Carte>();
		for (Iterator<Carte> iterator = cartesVisibles.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (i >= nombreOccurence)
				break;
			if (carte.getValeur() == valeur) {
				i++;
				hc.add(carte);
			}
		}
		cartesVisibles.removeAll(hc);
		return hc;
	}
	/**la methode  pour afficher des cartes
	 * 	  */
	public void afficherCarteVisibles() {
		for (Iterator<Carte> iterator = cartesVisibles.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.print(carte.getValeur() + " " + carte.getCouleur()
					+ "  ");
		}
	}

	@Override
	public String toString() {
		return cartesVisibles.toString();
	}

	public boolean isEmpty() {
		return cartesVisibles.isEmpty();
	}

	public void clear() {
		this.getCartesVisibles().clear();
	}
}
