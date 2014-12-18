package jeu;
/**
 * La classe Cartes de face visible 
 * c'est l'ensemble des cartes  a face decouverte qu'un joueur dispose sur la table 
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class CartesFacesCachees {
	/**
	 * cette classe prend un seul attribut de type Hashset
	 */
	
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
	/**la methode qui permet de prendre au hasard une carte de face cach�e pour l'ajouter sur les cartes en main
	 *
	 */

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

	/** cette methode return vrai si la collection  de cartes cachees est  vide
	 * @return un booleen
	 */
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
