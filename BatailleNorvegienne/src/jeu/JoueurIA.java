package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class JoueurIA extends Joueur {
	int degreeStrat;
	static private ArrayList<String> collectionNomDeJoueur = new ArrayList<String>(
			Arrays.asList("Nathan", "Lucas", "Enzo", "Leo", "Louis", "Hugo",
					"Gabriel", "Ethan", "Mathis", "Jules", "Emma", "Lea",
					"Chloé", "Manon", "Ines", "Lola", "Jade", "Camille",
					"Sarah", "Louise"));

	public JoueurIA(int degreeStrat) {
		String nom = null;
		if (collectionNomDeJoueur.size() > 0) {
			Collections.shuffle(collectionNomDeJoueur);
			nom = collectionNomDeJoueur.get(0);
			collectionNomDeJoueur.remove(0);
		} else {
			System.out.println("Entrez le nom de votre adversaire :");
			nom = PartieDeCartes.reader.nextLine();
		}
		setNom(nom);
		this.degreeStrat = degreeStrat;
	}
	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	private int[] choixDesCartesAJouer(){
		/*
		 * Dans la premiere case tu tableau nous mettons le nombre de carte a jouer 
		 * et dans la deuxieme nous mettons la valeur de la carte
		 */
		int[] choix=null;

		if (!cartesEnMain.getCartemain().isEmpty()){
			Object [] tableauObjets=cartesEnMain.getCartemain().toArray();
			Carte c=(Carte) tableauObjets[randInt(0, tableauObjets.length)];
			for (Iterator<Carte> iterator = cartesEnMain.getCartemain().iterator(); iterator
					.hasNext();) {
				Carte c = (Carte) iterator.next();
				
			}
		}
		else if (!cartefaceVisibles.getHs().isEmpty()){
			Object [] jk=cartefaceVisibles.getHs().toArray();
			Carte c=(Carte) jk[randInt(0, jk.length)];
			}
		else{
			choix[0]=1;
			choix[1]=carteFacesCachees.prendreAuhasard().getValeur();

		}
		return choix;
	}

	/*
	 * Le joueur IA va jouer aleatoirement des cartes pour l'instant
	 */
	@Override
	public boolean jouerLibrement(Table tas, Pioche pioche) {
		HashSet<Carte> hc = new HashSet<Carte>();

		if (!cartesEnMain.getCartemain().isEmpty()
				|| !cartefaceVisibles.getHs().isEmpty()) {
			int valeur = 0;
			int nombreDeCarteAjouer = 0;
			if (estPossedeDansLamain(valeur, nombreDeCarteAjouer)) {
				hc = cartesEnMain.supCarteMain(valeur, nombreDeCarteAjouer);
				tas.ajouterCarteTable(hc);
				for (int i = 0; i <= hc.size(); i++) {
					ajouterCarteEnMain(pioche.prendreCarte());
				}
				return true;
			} else if (cartesEnMain.getCartemain().isEmpty()) {
				if (estPossedeDansDansLesCartesVisibles(valeur,
						nombreDeCarteAjouer)) {
					hc = cartefaceVisibles.supCarteVisible(valeur,
							nombreDeCarteAjouer);
					tas.ajouterCarteTable(hc);
					return true;
				}
			}
		}
		if (cartesEnMain.getCartemain().isEmpty()
				&& cartefaceVisibles.getHs().isEmpty()) {
			tas.ajouterCarteALaTable(carteFacesCachees.prendreAuhasard());
			return true;
		}
		return false;
	}

	public void jouer(Carte c, int i) {
		super.jouer(c, i);
	}
}
