package jeu;

/**
 * La classe partie de carte
 *Elle represente une partie de jeu avec des joueurs, une pioche,un tableet un paquet de carte 
 */
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import jeu.Carte.Couleur;

public class PartieDeCartes {
	/**
	 * attributs de la carte
	 */
	public static Scanner reader;
	private Pioche pioche = new Pioche();
	private HashSet<JeuDeCartes> setJeuDeCartes = new HashSet<JeuDeCartes>();
	private Table table = new Table();
	private LinkedList<Joueur> llJoueur = new LinkedList<Joueur>();

	public Pioche getPioche() {
		return pioche;
	}

	/**
	 * Methode pour un joueur IA de choisir une strategie
	 * 
	 * @param r
	 * @return une strategie
	 */
	public Strategie choixDuneStrategie(Random r) {
		if (r.nextBoolean())
			return new StrategieAleatoire();
		else
			return new StrategieOffensive();
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	/**
	 * Methode de mise en place d'une partie de jeu
	 */
	private void miseEnPlaceDeLaListeDesJoueurs() {
		System.out.println("Mise en place de la liste des joueurs :");
		reader = new Scanner(System.in);
		System.out.print("Saisissez le nombre de joueur :");
		int nbJoueur = reader.nextInt();
		String name = null;
		reader.nextLine();
		for (int i = 1; i <= nbJoueur; i++) {
			Random r = new Random();
			if (i == 1) {
				System.out.print("Entrer votre nom :");
				name = reader.nextLine();
			}
			if (i == 1)
				llJoueur.add(new Distributeur(choixDuneStrategie(r)));
			else if (i == 2)
				llJoueur.add(new Joueur(name));
			else {
				llJoueur.add(new JoueurIA(choixDuneStrategie(r)));
			}
		}
	}

	/**
	 * Cette methode permet au joueur qui est a gauche du distributeur de
	 * commencer
	 */

	private void decalerListedesJoueurs() {
		Joueur j = llJoueur.getFirst();
		llJoueur.remove();
		llJoueur.addLast(j);
	}

	private void inverserListedesJoueurs() {
		Collections.reverse(llJoueur);
	}

	/**
	 * Creation d'un ou plusieurs jeux de carte en fonction du nombre de joueur.
	 */
	private void miseEnPlaceDesJeuxdeCartes() {
		if (llJoueur.size() <= 5 && llJoueur.size() > 1) {
			setJeuDeCartes.add(new JeuDeCartes());
		} else if (llJoueur.size() > 5 && llJoueur.size() <= 11) {
			setJeuDeCartes.add(new JeuDeCartes());
			setJeuDeCartes.add(new JeuDeCartes());
		} else {
			System.out
					.println("Veuillez renseigner le bon nombre d'utilisateur ! ");
			System.exit(0);
		}
		System.out.println("jeu de carte non melanger");
		for (Iterator<JeuDeCartes> it = setJeuDeCartes.iterator(); it.hasNext();) {
			JeuDeCartes jdc = it.next();
			for (Iterator<Carte> it2 = jdc.getLs().iterator(); it2.hasNext();) {
				Carte carte = (Carte) it2.next();
				System.out.print(carte + " ");

			}
			jdc.melanger();
		}
		System.out.println();

		System.out.println("jeu de carte melanger");
		for (Iterator<JeuDeCartes> it = setJeuDeCartes.iterator(); it.hasNext();) {
			JeuDeCartes jdc = it.next();
			for (Iterator<Carte> it2 = jdc.getLs().iterator(); it2.hasNext();) {
				Carte carte = (Carte) it2.next();
				System.out.print(carte + " ");

			}
		}
	}
	/**
	 * Methode pour affecter un numero a chaque joueur
	 * @param joueur
	 * @return le numero du joueur pris en parametre 
	 */

	public int PositionJoueurDansLaListe(Joueur joueur) {
		return (llJoueur.indexOf(joueur));
	}

	/**
	 * deroulement du jeu
	 * Seul le joueur va entrer son nom
	 * les Joueurs IA sont generes automatiquement avec leur nom et tout ce dont ils ont besoin pour jouer
	 */
	private void deroulementDujeu() {
		Joueur gagnant = null;
		boolean cond = true;
		int compteurPourPasserLesTours = 0; // compte le nombre de joueur qui vont passer  leur tour apres que de 8 ont etes jouees
		boolean passerLeTour = false;
		int nombreDejoueurQuiPasseLeurTour = 0;
		decalerListedesJoueurs(); // Le distributeur joue en dernier
		// EchangerLesCartes();
		HashSet<Carte> derniereCartesPosees = new HashSet<Carte>();
		while (cond) {
			for (Iterator<Joueur> iterator = llJoueur.iterator(); iterator
					.hasNext();) {
				Joueur joueur = (Joueur) iterator.next();
				if (!passerLeTour) {
					if (llJoueur.get(0) == joueur) {
						// System.out.println(joueur);
					}
					System.out.println(joueur);
					System.out.println("A vous de jouer " + joueur.getNom());
					if (joueur.estCeQueLeJoueurPeutJouer(derniereCartesPosees,
							table)) {
						derniereCartesPosees = joueur.jouerLibrement(table,
								pioche, derniereCartesPosees);
						joueur.PoserUnDix(derniereCartesPosees, table);
						joueur.PoserUnAs(derniereCartesPosees, table, llJoueur);
						nombreDejoueurQuiPasseLeurTour = joueur.PoserUnHuit(
								derniereCartesPosees, table);
					} else {
						joueur.piocher(1, pioche);
						System.out.println("JE PIOCHE");
					}
					if (nombreDejoueurQuiPasseLeurTour != 0) {
						passerLeTour = true;
					}
					System.out.println("derniere carte :"
							+ derniereCartesPosees);
					if (joueur.avoirAucuneCarte()) {
						gagnant = joueur;
						cond = false;
						break;
					}
				} else {
					System.out.println("JE PASSE MON TOUR " + joueur.getNom());
					if (compteurPourPasserLesTours + 1 >= nombreDejoueurQuiPasseLeurTour) {
						passerLeTour = false;
						nombreDejoueurQuiPasseLeurTour = 0;
					} else
						compteurPourPasserLesTours++;
				}

			}
		}
		System.out.println("Felicitation " + gagnant.getNom()
				+ " vous avez vaincu !");
	}

	private void test() {
		decalerListedesJoueurs();
		System.out.println(llJoueur);
		// HashSet<Carte> derniereCartesPosees = new HashSet<Carte>();
		// table.getListe().clear();
		// table.ajouterCarteALaTable(new Carte(3, Couleur.Pique));
		// table.ajouterCarteALaTable(new Carte(1, Couleur.Pique));
		// table.ajouterCarteALaTable(new Carte(3, Couleur.Pique));
		// table.ajouterCarteALaTable(new Carte(2, Couleur.Pique));
		// System.out
		System.out.println(llJoueur.get(1).getNom());
		llJoueur.get(1).getCartesEnMain().supprimerToutesLesCartesEnmain();
		llJoueur.get(1).ajouterCarteEnMain(new Carte(8, Couleur.Coeur));
		llJoueur.get(1).ajouterCarteEnMain(new Carte(8, Couleur.Trefle));
		llJoueur.get(1).ajouterCarteEnMain(new Carte(8, Couleur.Carreau));
		llJoueur.get(2).ajouterCarteEnMain(new Carte(8, Couleur.Pique));

		int a = ((JoueurIA) llJoueur.get(1)).test((JoueurIA) llJoueur.get(2),
				llJoueur);
		System.out.println(llJoueur.get(1).getCartesEnMain());
		System.out.println(a);
		//
		// System.out.println("EST CE QUE LE JOUEUR PEUX JOUER "
		// + llJoueur.get(2).estCeQueLeJoueurPeutJouer(
		// derniereCartesPosees, table));
	}

	/**
	 * Methode qui permet au joueur humain d echanger ses cartes
	 */
	private void EchangerLesCartes() {
		System.out.println("Voulez vous echanger des cartes ? N/o");
		reader = new Scanner(System.in);
		String s = reader.nextLine();
		if (s.length() == 1 && s.charAt(0) == 'o') {
			llJoueur.get(1).echangerCarte(
					llJoueur.get(1).choixDesCartesAEchanger());
		}
	}

	/**
	 * choix du distributeur parmi les joueurs IA
	 */
	private void distribuer() {
		for (Iterator<Joueur> it = llJoueur.iterator(); it.hasNext();) {
			Joueur joueur = (Joueur) it.next();
			if (joueur instanceof Distributeur) {
				pioche = ((Distributeur) joueur).distribuer(setJeuDeCartes,
						llJoueur);
				System.out.println("je suis " + joueur.getNom()
						+ " et je vais distribuer ! ");
				break;
			}
		}
		System.out.println(pioche);
	}

	/**
	 * Methode qui demarre le jeu
	 */
	private void demarrer() {
		miseEnPlaceDeLaListeDesJoueurs();
		miseEnPlaceDesJeuxdeCartes();
		distribuer();
		deroulementDujeu();
		// test();
	}

	public static void main(String[] args) {
		PartieDeCartes pdc = new PartieDeCartes();
		pdc.demarrer();
	}

}
