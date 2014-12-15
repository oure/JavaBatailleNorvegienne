package jeu;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import jeu.Carte.Couleur;

public class PartieDeCartes {
	public static Scanner reader;
	private Pioche pioche = new Pioche();
	private HashSet<JeuDeCartes> setJeuDeCartes = new HashSet<JeuDeCartes>();
	private Table table = new Table();
	private LinkedList<Joueur> llJoueur = new LinkedList<Joueur>();
	int nbrCarte;
	Carte carte;

	/*
	 * Mise en place de la liste des joueurs.
	 */
	public Pioche getPioche() {
		return pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	private void miseEnPlaceDeLaListeDesJoueurs() {
		System.out.println("Mise en place de la liste des joueurs :");
		reader = new Scanner(System.in);
		System.out.print("Saisissez le nombre de joueur :");
		int nbJoueur = reader.nextInt();
		String name = null;
		reader.nextLine();
		Random r = new Random();
		for (int i = 1; i <= nbJoueur; i++) {
			if (i == 1) {
				System.out.print("Entrer votre nom :");
				name = reader.nextLine();
			}
			if (i == 1)
				llJoueur.add(new Distributeur(r.nextInt((2 + 1) - 1) + 1));
			else if (i == 2)
				llJoueur.add(new Joueur(name));
			else {
				llJoueur.add(new JoueurIA(r.nextInt((2 + 1) - 1) + 1));
			}
		}
	}

	private void decalerListedesJoueurs() {
		Joueur j = llJoueur.getFirst();
		llJoueur.remove();
		llJoueur.addLast(j);
	}

	private void inverserListedesJoueurs() {
		Collections.reverse(llJoueur);
	}

	/*
	 * Creation d'un ou plusieurs jeu de carte en fonction du nombre de joueur.
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

	public int PositionJoueurDansLaListe(Joueur joueur) {
		return (llJoueur.indexOf(joueur));
	}

	private void deroulementDujeu() {
		Joueur gagnant = null;
		boolean cond = true;
		int compteurPourPasserLesTours = 0;
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
						//System.out.println(joueur);
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
					}
					else{
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
		JoueurIA ia=(JoueurIA) llJoueur.get(1);
		table.getListe().clear();
		ia.getCartesEnMain().supprimerToutesLesCartesEnmain();
		ia.ajouterCarteEnMain(new Carte(1, Couleur.Coeur));
		ia.ajouterCarteEnMain(new Carte(2, Couleur.Trefle));
		ia.ajouterCarteEnMain(new Carte(10, Couleur.Trefle));

		System.out.println(ia);
		ia.choixDesCartesAEchanger();
		System.out.println(ia);
//		HashSet<Carte> derniereCartesPosees = new HashSet<Carte>();
//		table.getListe().clear();
//		table.ajouterCarteALaTable(new Carte(3, Couleur.Pique));
//		table.ajouterCarteALaTable(new Carte(1, Couleur.Pique));
//		table.ajouterCarteALaTable(new Carte(3, Couleur.Pique));
//		table.ajouterCarteALaTable(new Carte(2, Couleur.Pique));
//		System.out
//				.println("DERNIER CARTE" + table.afficherDerniereCarteDuTas());
//		llJoueur.get(2).getCartesEnMain().supprimerToutesLesCartesEnmain();
//		llJoueur.get(2).ajouterCarteEnMain(new Carte(3, Couleur.Coeur));
//		llJoueur.get(2).ajouterCarteEnMain(new Carte(1, Couleur.Trefle));
//
//		System.out.println(llJoueur.get(2).getCartesEnMain());
//		System.out.println(table);
//
//		System.out.println("EST CE QUE LE JOUEUR PEUX JOUER "
//				+ llJoueur.get(2).estCeQueLeJoueurPeutJouer(
//						derniereCartesPosees, table));
	}

	private void EchangerLesCartes() {
		System.out.println("Voulez vous echanger des cartes ? N/o");
		reader = new Scanner(System.in);
		String s = reader.nextLine();
		if (s.length() == 1 && s.charAt(0) == 'o'){
			llJoueur.get(1).echangerCarte(llJoueur.get(1).choixDesCartesAEchanger());
		}
	}

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
		for (Iterator<Joueur> iterator = llJoueur.iterator(); iterator
				.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
		}
		System.out.println(pioche);
	}

	private void demarrer() {
		miseEnPlaceDeLaListeDesJoueurs();
		miseEnPlaceDesJeuxdeCartes();
		distribuer();
		//deroulementDujeu();
		test();
	}

	public static void main(String[] args) {
		PartieDeCartes pdc = new PartieDeCartes();
		pdc.demarrer();
	}

}
