package jeu;

/**
 * La classe joueur Intelligence Artificielle
 *Elle herite de la classe joueur 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class JoueurIA extends Joueur {
	/**
	 * les attributs de la classe joueur IA
	 */
	private Strategie strategie;

	static private ArrayList<String> collectionNomDeJoueur = new ArrayList<String>(
			Arrays.asList("Nathan", "Lucas", "Enzo", "Leo", "Louis", "Hugo",
					"Gabriel", "Ethan", "Mathis", "Jules", "Emma", "Lea",
					"Chloe", "Manon", "Ines", "Lola", "Jade", "Camille",
					"Sarah", "Louise"));

	/**
	 * Constructeur qui prend en parametre une strategie
	 * 
	 * @param strat
	 */
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

	/**
	 * Methode qui envoie le joueur qui a le moins de carte
	 * 
	 * @param lj
	 *            collection de joueurs
	 * @return joueur
	 */
	public void seDefendreContreUnAs(Table table) {
		int vCarte = strategie.contrerUnAs(this);
		if (estPossedeDansLamain(vCarte, 1))
			table.ajouterCartesTable(cartesEnMain.supCarteMain(vCarte, 1));
		else
			table.ajouterCartesTable(cartefaceVisibles.supCarteVisible(vCarte,
					1));

	}

	public Joueur quiAleMoinsDeCarte(LinkedList<Joueur> lj) {
		int nombreDeCarteMin = 100;
		Joueur j = null;
		for (Iterator<Joueur> iterator = lj.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			if (joueur.nombreTotalDecarteQuePossedeUnJoueur() < nombreDeCarteMin
					&& this != joueur) {
				j = joueur;
				System.out.println("VICTTTTTTTIME" + j);
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

	/**
	 * 
	 * @return une carte
	 */
	public Carte retourneUneCarteNonSpecialDesCartesVisible() {
		for (Iterator<Carte> iterator = cartefaceVisibles.getCartesVisibles()
				.iterator(); iterator.hasNext();) {
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

	public int[] choixDesCartesAJouer(Table table) {
		/*
		 * Dans la premiere case tu tableau nous mettons le nombre de carte a
		 * jouer et dans la deuxieme nous mettons la valeur de la carte
		 */
		int[] choix = new int[2];
		HashSet<Carte> hs = getCartesPosablesDansLeContexte(table);
		if (hs.isEmpty()) {
			return null;
		}
		if (hs.size() == 1) {
			for (Iterator<Carte> iterator = hs.iterator(); iterator.hasNext();) {
				Carte carte = (Carte) iterator.next();
				choix[0] = 1;
				choix[1] = carte.getValeur();
			}
			return choix;
		}
		System.out.println("Les cartes jouables dans le contextes sont :" + hs);
		if (!cartesEnMain.getCartemain().isEmpty()) {
			Object[] tableauObjets = hs.toArray();
			Carte c = (Carte) tableauObjets[randInt(0, tableauObjets.length - 1)];
			choix[0] = 1;
			choix[1] = c.getValeur();
		} else if (!cartefaceVisibles.getCartesVisibles().isEmpty()) {
			Object[] jk = hs.toArray();
			Carte c = (Carte) jk[randInt(0, jk.length - 1)];
			choix[0] = 1;
			choix[1] = c.getValeur();
		} else {
			choix[0] = 1;
			choix[1] = carteFacesCachees.prendreAuhasard().getValeur();
		}
		return choix;
	}

	/**
	 * Le joueur IA va jouer aleatoirement des cartes pour l'instant
	 */
	@Override
	public HashSet<Carte> jouerLibrement(Table table, Pioche pioche,
			HashSet<Carte> derniereCartesPosees) {
		HashSet<Carte> hc = new HashSet<Carte>();
		if (!pioche.isEmpty() && cartesEnMain.isEmpty()) {
			piocher(pioche);
			return hc;
		}

		if (!cartesEnMain.getCartemain().isEmpty()
				|| !cartefaceVisibles.getCartesVisibles().isEmpty()) {
			int[] tab = choixDesCartesAJouer(table);
			if (tab == null) {
				System.out.println("JE PiOCHE");
				piocher(pioche);
				return hc;
			}
			int valeur = tab[1];
			int nombreDeCarteAjouer = tab[0];
			if (estPossedeDansLamain(valeur, nombreDeCarteAjouer)
					&& estCeQueLeJoueurPeutJouerDesCartes(valeur,
							nombreDeCarteAjouer, table)) {
				hc = cartesEnMain.supCarteMain(valeur, nombreDeCarteAjouer);
				table.ajouterCartesTable(hc);
				for (int i = 1; i <= hc.size(); i++) {
					System.out.println();
					piocher(pioche);
				}
				return hc;
			} else if (cartesEnMain.getCartemain().isEmpty()
					&& estCeQueLeJoueurPeutJouerDesCartes(valeur,
							nombreDeCarteAjouer, table)) {
				if (estPossedeDansDansLesCartesVisibles(valeur,
						nombreDeCarteAjouer)) {
					hc = cartefaceVisibles.supCarteVisible(valeur,
							nombreDeCarteAjouer);
					table.ajouterCartesTable(hc);
					for (int i = 1; i <= hc.size(); i++) {
						piocher(pioche);
					}
					return hc;
				}
			}
		}
		if (cartesEnMain.getCartemain().isEmpty()
				&& cartefaceVisibles.getCartesVisibles().isEmpty()) {
			Carte carte = carteFacesCachees.prendreAuhasard();
			if (estCeQueLeJoueurPeutJouerDesCartes(carte.getValeur(), 1, table)) {
				System.out.println("JE PEUX JOUER CETTE CARTE");
				hc.add(carte);
				table.ajouterCartesTable(hc);
			} else {
				System.out.println("JE NE PEUX PAS JOUER CETTE CARTE");
				ajouterCartesEnMain(table.ramasserLeTas());
				System.out.println("VOUS AVEZ RAMMASSER LE TAS " + getNom());
			}
			return hc;
		}
		return hc;
	}

	public Joueur choixDuJoueurCibleePourEnvoyerLaTable(LinkedList<Joueur> lj) {
		System.out.println("OUIIIIIII");
		System.out.println(strategie.getClass());
		return strategie.choixDuJoueurCibleePourEnvoyerLetas(this, lj);
	}

	public HashSet<Carte> getCartesPosablesDansLeContexte(Table table) {
		HashSet<Carte> cartesPosables = new HashSet<Carte>();
		if (!cartesEnMain.isEmpty())
			for (Iterator<Carte> iterator = cartesEnMain.getCartemain()
					.iterator(); iterator.hasNext();) {
				Carte c = (Carte) iterator.next();
				if (table.isEmpty()
						|| (table.laDerniereCarteDuJeuEstUnSept() && estInferieurOuEgal(
								c.getValeur(), table))) {
					cartesPosables.add(c);
				}
				if (table.isEmpty()
						|| (c.getValeur() >= table
								.getDerniereValeurCarteDuTas()
								|| c.getValeur() == 2 || c.getValeur() == 1)
						&& !table.laDerniereCarteDuJeuEstUnSept()) {
					cartesPosables.add(c);
				}
			}
		else if (cartesEnMain.isEmpty() && !cartefaceVisibles.isEmpty())
			for (Iterator<Carte> iterator = cartefaceVisibles
					.getCartesVisibles().iterator(); iterator.hasNext();) {
				Carte c = (Carte) iterator.next();
				if (table.isEmpty()
						|| c.getValeur() >= table.getDerniereValeurCarteDuTas()
						|| c.getValeur() == 2 || c.getValeur() == 1)
					cartesPosables.add(c);
			}
		else
			cartesPosables.clear();
		return cartesPosables;
	}

	public Strategie getStrategie() {
		return strategie;
	}

	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}

}
