package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
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
	
	public int[] choixDesCartesAJouer(){
		/*
		 * Dans la premiere case tu tableau nous mettons le nombre de carte a jouer 
		 * et dans la deuxieme nous mettons la valeur de la carte
		 */
		int []choix=new int[2];

		if (!cartesEnMain.getCartemain().isEmpty()){
			Object [] tableauObjets=cartesEnMain.getCartemain().toArray();
			Carte c=(Carte) tableauObjets[randInt(0, tableauObjets.length-1)];
			choix[0]=1;
			choix[1]=c.getValeur();
		}
		else if (!cartefaceVisibles.getHs().isEmpty()){
			Object [] jk=cartefaceVisibles.getHs().toArray();
			Carte c=(Carte) jk[randInt(0, jk.length)];
			choix[0]=1;
			choix[1]=c.getValeur();
			}
		else{
			choix[0]=1;
			choix[1]=carteFacesCachees.prendreAuhasard().getValeur();

		}
		return choix;
	}
	
	public Joueur choixDuJoueurCibleePourEnvoyerLetas(LinkedList<Joueur> lj){
		System.out.println("CHOIX DU JOUEUR CIBLE MAGUEULE");
		int num=getNumeroduJoueurDansLaListeDeJoueur(lj,this);
		int numeroDuJoueurDesigne = randInt(0,lj.size()-1);
		if(numeroDuJoueurDesigne!=num) //Il serait idiot qu'un joueurIA se lance le tas à lui même.
			return lj.get(numeroDuJoueurDesigne);
		else
			choixDuJoueurCibleePourEnvoyerLetas(lj);
		return null;
	}
	/*
	 * Le joueur IA va jouer aleatoirement des cartes pour l'instant
	 */
	@Override
	public HashSet<Carte> jouerLibrement(Table tas,Pioche pioche, HashSet<Carte> derniereCartesPosees) {
		HashSet<Carte> hc = new HashSet<Carte>();
		int []tab=choixDesCartesAJouer();
		int valeur = tab[1];
		int nombreDeCarteAjouer = tab [0];
		if (!cartesEnMain.getCartemain().isEmpty()
				|| !cartefaceVisibles.getHs().isEmpty()) {
			if (estPossedeDansLamain(valeur, nombreDeCarteAjouer)) {
				hc = cartesEnMain.supCarteMain(valeur, nombreDeCarteAjouer);
				tas.ajouterCarteTable(hc);
				for (int i = 0; i <= hc.size(); i++) {
					ajouterCarteEnMain(pioche.prendreCarte());
				}
				return hc;
			} else if (cartesEnMain.getCartemain().isEmpty()) {
				if (estPossedeDansDansLesCartesVisibles(valeur,
						nombreDeCarteAjouer)) {
					hc = cartefaceVisibles.supCarteVisible(valeur,
							nombreDeCarteAjouer);
					tas.ajouterCarteTable(hc);
					return hc;
				}
			}
		}
		if (cartesEnMain.getCartemain().isEmpty()
				&& cartefaceVisibles.getHs().isEmpty()) {
			tas.ajouterCarteALaTable(carteFacesCachees.prendreAuhasard());
			return hc;
		}
	return hc;
	}
}
