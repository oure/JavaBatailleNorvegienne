package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PartieDeCartes {
	Pioche pioche = new Pioche();
	HashSet<JeuDeCartes> setJeuDeCartes = new HashSet<JeuDeCartes>();
	Table tas = new Table();
	LinkedList<Joueur> llJoueur = new LinkedList<Joueur>();

	/*
	 * Mise en place de la liste des joueurs.
	 */
	public void MiseEnPlaceDeLaListeDesJoueurs() {
		System.out.println("Mise en place de la liste des joueurs :");
		Scanner reader = new Scanner(System.in);
		System.out.println("Saisissez le nombre de joueur :");
		int nbJoueur = reader.nextInt();
		String name;
		reader.nextLine();
		for (int i = 1; i <= nbJoueur; i++) {
			// reader.nextLine();
			System.out.print("Please input a name: ");
			name = reader.nextLine();
			llJoueur.add(new Joueur(name));
		}
		reader.close();
	}

	/*
	 * Creation d'un ou plusieurs jeu de carte en fonction du nombre de joueur.
	 */
	public void MiseEnPlaceDesJeuxdeCartes() {
		System.out.println("llJoueur.size()" + llJoueur.size());
		if (llJoueur.size() <= 5 && llJoueur.size() > 1) {
			setJeuDeCartes.add(new JeuDeCartes());
		} else if (llJoueur.size() > 5 && llJoueur.size() <= 11) {
			setJeuDeCartes.add(new JeuDeCartes());
			setJeuDeCartes.add(new JeuDeCartes());
		}
		System.out.println("jeu de carte non melanger");
		for (Iterator<JeuDeCartes> it = setJeuDeCartes.iterator(); it.hasNext();) {
			JeuDeCartes jdc = it.next();
			System.out.println(jdc);
			jdc.melanger();
		}
		System.out.println("jeu de carte melanger");
		for (Iterator<JeuDeCartes> it = setJeuDeCartes.iterator(); it.hasNext();) {
			JeuDeCartes jdc = it.next();
			System.out.println(jdc);
		}
	}

	public static void main(String[] args) {
		PartieDeCartes pdc = new PartieDeCartes();
		pdc.MiseEnPlaceDeLaListeDesJoueurs();
		pdc.MiseEnPlaceDesJeuxdeCartes();
		// while (cond){
		// for (Iterator<Joueur> iterator = lj.iterator(); iterator.hasNext();)
		// {
		// Joueur joueur = (Joueur) iterator.next();
		// if (joueur.getSet().isEmpty()){
		// cond=false;
		// break;
		// }
		//
		//
		// }
		//
		// }
	}
}
