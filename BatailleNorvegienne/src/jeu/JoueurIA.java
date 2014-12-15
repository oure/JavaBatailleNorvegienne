package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class JoueurIA extends Joueur {
	private Strategie strategie;

	static private ArrayList<String> collectionNomDeJoueur = new ArrayList<String>(
			Arrays.asList("Nathan", "Lucas", "Enzo", "Leo", "Louis", "Hugo",
					"Gabriel", "Ethan", "Mathis", "Jules", "Emma", "Lea",
					"Chloé", "Manon", "Ines", "Lola", "Jade", "Camille",
					"Sarah", "Louise"));

	public JoueurIA(Strategie strat) {
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
		this.strategie = strat;
	}
	public Joueur quiAleMoinsDeCarte(LinkedList<Joueur> lj) {
		int nombreDeCarteMin = 100;
		Joueur j = null;
		for (Iterator<Joueur> iterator = lj.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			if (joueur.nombreTotalDecarteQuePossedeUnJoueur() < nombreDeCarteMin && this!=joueur) {
				j = joueur;
				nombreDeCarteMin = joueur
						.nombreTotalDecarteQuePossedeUnJoueur();
			}
		}
		return j;
	}

	/**
	 * Returns a pseudo-random number between min and max, inclusive. The
	 * difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min
	 *            Minimum value
	 * @param max
	 *            Maximum value. Must be greater than min.
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

	public Carte retourneUneCarteNonSpecialDesCartesVisible() {
		for (Iterator<Carte> iterator = cartefaceVisibles.getCartesVisibles().iterator(); iterator
				.hasNext();) {
			Carte c = iterator.next();
			if (c.getValeur() == 3 || c.getValeur() == 4 || c.getValeur() == 5
					|| c.getValeur() == 6 || c.getValeur() == 9
					|| c.getValeur() == 11 || c.getValeur() == 12
					|| c.getValeur() == 13) {
				return c;
			}
		}
		return null;
	}

	public int[] choixDesCartesAEchanger() {
		for (int i = 0; i < 3; i++) {
			Carte c = null;
			System.out.println("OK");
			for (Iterator<Carte> iterator = cartesEnMain.getCartemain()
					.iterator(); iterator.hasNext();) {
				c = iterator.next();
				if (c.getValeur() == 2 || c.getValeur() == 8
						|| c.getValeur() == 7 || c.getValeur() == 10
						|| c.getValeur() == 1)
					break;
			}
			int tab[] = new int[2];
			tab[0] = c.getValeur();
			if (retourneUneCarteNonSpecialDesCartesVisible() == null)
				return null; // Il n'y a pas de carte a echanger
			tab[1] = retourneUneCarteNonSpecialDesCartesVisible().getValeur();
			echangerCarte(tab);

		}
		return null;
	}

	public int[] choixDesCartesAJouer() {
		/*
		 * Dans la premiere case tu tableau nous mettons le nombre de carte a
		 * jouer et dans la deuxieme nous mettons la valeur de la carte
		 */
		int[] choix = new int[2];

		if (!cartesEnMain.getCartemain().isEmpty()) {
			Object[] tableauObjets = cartesEnMain.getCartemain().toArray();
			Carte c = (Carte) tableauObjets[randInt(0, tableauObjets.length - 1)];
			choix[0] = 1;
			choix[1] = c.getValeur();
		} else if (!cartefaceVisibles.getCartesVisibles().isEmpty()) {
			Object[] jk = cartefaceVisibles.getCartesVisibles().toArray();
			Carte c = (Carte) jk[randInt(0, jk.length)];
			choix[0] = 1;
			choix[1] = c.getValeur();
		} else {
			choix[0] = 1;
			choix[1] = carteFacesCachees.prendreAuhasard().getValeur();

		}
		return choix;
	}

	/*
	 * Le joueur IA va jouer aleatoirement des cartes pour l'instant
	 */
	@Override
	public HashSet<Carte> jouerLibrement(Table tas, Pioche pioche,
			HashSet<Carte> derniereCartesPosees) {
		HashSet<Carte> hc = new HashSet<Carte>();
		int[] tab = choixDesCartesAJouer();
		int valeur = tab[1];
		int nombreDeCarteAjouer = tab[0];
		if (!cartesEnMain.getCartemain().isEmpty()
				|| !cartefaceVisibles.getCartesVisibles().isEmpty()) {
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
				&& cartefaceVisibles.getCartesVisibles().isEmpty()) {
			tas.ajouterCarteALaTable(carteFacesCachees.prendreAuhasard());
			return hc;
		}
		return hc;
	}
	public int test(JoueurIA ia,
			LinkedList<Joueur> lj){
		return strategie.nombreDeHuitQueIaDoitPoser(ia,lj);
	}
	public Strategie getStrategie() {
		return strategie;
	}
	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}

}
