package jeu;
/**
 * La classe Carte en main 
 * c'est l'ensemble des cartes qu'un joueur dispose dans sa main 
 */
import java.util.HashSet;
import java.util.Iterator;

public class CartesEnMain {
	/**
	 * cette classe prend un seul attribut de type hashset
	 */
	
	private HashSet<Carte> cartemain = new HashSet<Carte>();

	/**cette methode permet d'ajouter  des cartes  sur les cartes en main
	 * @ param table : instance de la classe Table 
	 */
	
	
	public void addAll(Table table) {
		for (Iterator<Carte> it = table.getListe().iterator(); it.hasNext();) {
			Carte carte = (Carte) it.next();
			ajouterCarteMain(carte);

		}
	}
	
	
	/**
	 * cette methode permet d'ajouter une seule carte  sur les cartes  en main
	 * @ param c : une carte
	 */
	
	public void ajouterCarteMain(Carte car) {
		cartemain.add(car);
	}

	/**
	 * la methode  qui permet de supprimer des cartes  en main
	 * @ param valeur : la valeur de la carte a supprimer
	 * @ param nombreOccurence: le nombre de cartes a supprimer
<<<<<<< HEAD
	 * @return 
=======
	 * @return une collection de cartes de type Hashset. ce sont les cartes que l'on vient de supprimer de la main
>>>>>>> refs/remotes/oure/master
	  */
	
public HashSet<Carte> supCarteMain(int valeur, int nombreOccurence) {
		int i = 0;
		HashSet<Carte> hc=new HashSet<Carte>();
		for (Iterator<Carte> iterator = cartemain.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (i>=nombreOccurence) break;
			if (carte.getValeur() == valeur) {
				i++;
			hc.add(carte);
			}
		}
		cartemain.removeAll(hc);
		return hc;
	}

	/**
	 * la methode  qui permet de supprimer toutes les cartes  en main
	 * @see HashSet#clear()
	*/
	
	public void supprimerToutesLesCartesEnmain(){
		cartemain.clear();
	}
	public HashSet<Carte> getCartemain() {
		return cartemain;
	}

	public void setCartemain(HashSet<Carte> cartemain) {
		this.cartemain = cartemain;
	}

	@Override
	public String toString() {
		return cartemain.toString();
	}

	/**
	 * Cette methode renvoie  vrai si la main d'un joueur est vide et faux, sinon
	 * @return un booleen
	 */
	public boolean isEmpty() {
		return cartemain.isEmpty();
	}

}
