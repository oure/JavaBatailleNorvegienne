package jeu;

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
	private Table tas = new Table();
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

	/*
	 * Creation d'un ou plusieurs jeu de carte en fonction du nombre de joueur.
	 */
	private void miseEnPlaceDesJeuxdeCartes() {
		// System.out.println("llJoueur.size()" + llJoueur.size());
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
		// EchangerLesCartes();
		while (cond) {
			for (Iterator<Joueur> iterator = llJoueur.iterator(); iterator
					.hasNext();) {
				Joueur joueur = (Joueur) iterator.next();
					System.out.println(tas);
					joueur.jouerLibrement(tas);		
				if (joueur.avoirAucuneCarte()) {
					gagnant = joueur;
					cond = false;
					break;
				}
			}
		}
		System.out.println("Felicitation " + gagnant.getNom()
				+ " vous avez vaincu !");
	}

	private void test() {
		System.out.println(llJoueur.get(1).getCartesEnMain());
		System.out.println(llJoueur.get(1).getCartefaceVisibles());
		llJoueur.get(1).getCarteFacesCachees().prendreAuhasard();
		llJoueur.get(1).getCarteFacesCachees().prendreAuhasard();
		System.out.println(llJoueur.get(1));
	}

	private void EchangerLesCartes() {
		System.out.println("Voulez vous echanger des cartes ? N/o");
		reader = new Scanner(System.in);
		String s = reader.nextLine();
		if (s.length() == 1 && s.charAt(0) == 'o')
			llJoueur.get(1).echangerCarte();
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
			System.out.println(joueur);

		}
		System.out.println(pioche);
	}

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
