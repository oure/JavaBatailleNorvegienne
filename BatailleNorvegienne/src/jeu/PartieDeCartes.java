package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PartieDeCartes {
	private Pioche pioche = new Pioche(); 
	private HashSet<JeuDeCartes> setJeuDeCartes = new HashSet<JeuDeCartes>();
	private Table tas = new Table();
	private LinkedList<Joueur> llJoueur = new LinkedList<Joueur>();

	/*
	 * Mise en place de la liste des joueurs.
	 */
	private void miseEnPlaceDeLaListeDesJoueurs() {
		System.out.println("Mise en place de la liste des joueurs :");
		Scanner reader = new Scanner(System.in);
		System.out.print("Saisissez le nombre de joueur :");
		int nbJoueur = reader.nextInt();
		String name;
		reader.nextLine();
		for (int i = 1; i <= nbJoueur; i++) {
			// reader.nextLine();
			System.out.print("Entrer le nom du joueur "+ i +" :");
			name = reader.nextLine();
			if (i != 2)
				llJoueur.add(new Joueur(name));
			else
				llJoueur.add(new Distributeur(name, 1));

		}
		reader.close();
	}

	/*
	 * Creation d'un ou plusieurs jeu de carte en fonction du nombre de joueur.
	 */
	private void miseEnPlaceDesJeuxdeCartes() {
		//System.out.println("llJoueur.size()" + llJoueur.size());
		if (llJoueur.size() <= 5 && llJoueur.size() > 1) {
			setJeuDeCartes.add(new JeuDeCartes());
		} else if (llJoueur.size() > 5 && llJoueur.size() <= 11) {
			setJeuDeCartes.add(new JeuDeCartes());
			setJeuDeCartes.add(new JeuDeCartes());
		} else {
			System.out
					.println("Veuillez renseigner le bon nombre d'utilisateur ! ");
			System.exit(0);
		}	System.out.println();
		System.out.println("jeu de carte non melanger");
		for (Iterator<JeuDeCartes> it = setJeuDeCartes.iterator(); it.hasNext();) {
			JeuDeCartes jdc = it.next();
			System.out.println(jdc);
			jdc.melanger();
		}		System.out.println();	

		System.out.println("jeu de carte melanger");
		for (Iterator<JeuDeCartes> it = setJeuDeCartes.iterator(); it.hasNext();) {
			JeuDeCartes jdc = it.next();
			//System.out.println();
		}
	}		          
	
	private void deroulementDujeu() {
		Joueur gagnant = null;
		boolean cond=true;
		while (cond) {
			for (Iterator<Joueur> iterator = llJoueur.iterator(); iterator.hasNext();) {
				Joueur joueur = (Joueur) iterator.next();
				if (joueur.avoirAucuneCarte()) {
					gagnant=joueur;
					cond = false;
					break;
				}
			}

		}
		System.out.println("Felicitation "+gagnant.getNom()+" vous avez vaincu !");
	}

	private void distribuer() {
		for (Iterator<Joueur> it = llJoueur.iterator(); it.hasNext();) {
			Joueur joueur = (Joueur) it.next();
			if (joueur instanceof Distributeur) {
				pioche = ((Distributeur) joueur).distribuer(setJeuDeCartes,
						llJoueur);
				System.out.println("je suis le joueur n�" + joueur.getNom()
						+ " et je vais distribuer ! ");
				break;
			}
		} 
		for (Iterator<Joueur> iterator = llJoueur.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			System.out.println();
			System.out.print(joueur.getNom()+"  cartesMain :");
            System.out.print("(");
			joueur.afficheMain();
            System.out.print(") ");
			System.out.print("cartesVisible :");
            System.out.print("(");
			joueur.afficheVisibles();
            System.out.print(") ");
			System.out.print("cartesRetournees :");
            System.out.print("(");
			joueur.afficheCarteRetournees();
            System.out.print(") ");
            System.out.println();
		}
		System.out.println(pioche);
	}

	private void demarrer() {
		miseEnPlaceDeLaListeDesJoueurs();
		miseEnPlaceDesJeuxdeCartes();
		distribuer();
		deroulementDujeu();
	}

	
	public static void main(String[] args) {
		PartieDeCartes pdc = new PartieDeCartes();
		pdc.demarrer();
		}
	 
	
}