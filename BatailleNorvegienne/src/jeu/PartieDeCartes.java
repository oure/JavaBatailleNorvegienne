package jeu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class PartieDeCartes {
	Pioche pioche=new Pioche();
	HashSet<JeuDeCartes> setJeuDeCartes=new HashSet<JeuDeCartes>();
	LinkedList<Joueur> llJoueur=new LinkedList<Joueur>();
	Table tas=new Table();
	/*
	 * Mise en place de la liste des joueurs.
	 */
	public void MiseEnPlaceDeLaListeDesJoueurs(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez le nombre de joueur :");
		int nbJoueur = sc.nextInt();
		for (int i = 1; i <= nbJoueur; i++) {
			System.out.println("Nom du joueur n°"+i+" :");
			String NomDuJoueur = sc.nextLine();
			llJoueur.add(new Joueur(NomDuJoueur));
		}
	}
	public void MiseEnPlaceDesJeuxdeCartes(){
		
	}
		public static void main(String[] args) {
		PartieDeCartes pdc=new PartieDeCartes();
		pdc.MiseEnPlaceDeLaListeDesJoueurs();
		JeuDeCartes jeuDeCarte=new JeuDeCartes();
		System.out.println("Jeu de 32 cartes : "+jeuDeCarte);
		jeuDeCarte.melanger();
		System.out.println("Jeu de 32 cartes melange : "+jeuDeCarte);
		HashSet<Joueur> lj = new HashSet<Joueur>();
		lj.add(new Joueur("Micky"));
		lj.add(new Joueur("Johnny"));
		lj.add(new Joueur("Joel"));
		jeuDeCarte.distribuer(lj);
		boolean cond=true;
//		while (cond){
//			for (Iterator<Joueur> iterator = lj.iterator(); iterator.hasNext();) {
//				Joueur joueur = (Joueur) iterator.next();
//				if (joueur.getSet().isEmpty()){
//					cond=false;
//					break;
//				}
//				
//				
//			}
//			
//		}
	}
}
