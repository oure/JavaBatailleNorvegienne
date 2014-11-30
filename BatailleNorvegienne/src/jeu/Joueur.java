package jeu;

import java.util.*;

import jeu.Carte.Couleur;


public class Joueur {
	private String nom;
	private CartesEnMain cartesEnMain = new CartesEnMain();
	private CartesfacesVisibles cartefaceVisibles = new CartesfacesVisibles();
	private CartesFacesCachees carteFacesCachees = new CartesFacesCachees();

	public void ajouterCarteEnMain(Carte c) {
		cartesEnMain.ajouterCarteMain(c);
	}
	public boolean avoirAucuneCarte(){
		return (getCarteFacesCachees().isEmpty() && getCartefaceVisibles().isEmpty() && getCartesEnMain().isEmpty());
	}
	public void ajouterCartefacsVisible(Carte c){
		cartefaceVisibles.ajouterCarteVisible(c);
	}

	public void ajouterCarteFaceCachee(Carte c){
		carteFacesCachees.ajouterUnecarteFaceCachee(c);
	}

	public void setCfv(CartesfacesVisibles cfv) {
		this.cartefaceVisibles = cfv;
	}

	public CartesEnMain getCartesEnMain() {
		return cartesEnMain;
		
	}
	public void afficheMain() {
		cartesEnMain.afficherCarteMain();
		
	}
	public void afficheCarteRetournees() {
		carteFacesCachees.afficherCarteRetournees();
		
	}
	public void afficheVisibles() {
		cartefaceVisibles.afficherCarteVisibles();
		
	}
 
	
	public void setCartesEnMain(CartesEnMain cartesEnMain) {
		this.cartesEnMain = cartesEnMain;
	}

	public CartesfacesVisibles getCartefaceVisibles() {
		return cartefaceVisibles;
	}

	public void setCartefaceVisibles(CartesfacesVisibles cartefaceVisibles) {
		this.cartefaceVisibles = cartefaceVisibles;
	}

	public CartesFacesCachees getCarteFacesCachees() {
		return carteFacesCachees;
	}

	public void setCarteFacesCachees(CartesFacesCachees carteFacesCachees) {
		this.carteFacesCachees = carteFacesCachees;
	}

	public void setCfc(CartesFacesCachees cfc) {
		this.carteFacesCachees = cfc;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Joueur(String nom) {
		this.nom = nom;
	}

	public void jouer(Carte c, int i) {
		// TODO Auto-generated method stub

	}

	public void envoyerTasSurJoueur(LinkedList<Joueur> lj,Table table) {
		int i = 1;
		for (Iterator iterator = lj.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			System.out.println("Joueur numero "+i+" : " + joueur.getNom());
			i++;
		}
		System.out.print("Saisissez le nombre de joueur :");
		Scanner reader = new Scanner(System.in);
		int numeroDuJoueur  = reader.nextInt();
//		reader.close();
//		Joueur j=lj.get(numeroDuJoueur);
//		for (Iterator<Carte> iterator = table.getListe().iterator(); iterator.hasNext();) {
//			Carte carte =  iterator.next();
//			j.ajouterCarteEnMain(carte);			
//		}
//		table.viderTable();
	}

	// public String toString() {
	// String ss = "";
	// for (Iterator<Carte> iterator = cartesEnMain.iterator();
	// iterator.hasNext();) {
	// Carte carte = (Carte) iterator.next();
	// ss += carte.getValeur() + " ";
	// }
	// if (ss != "")
	// return "Nom : " + nom + ", Carte(s) : " + ss;
	// else
	// return "Nom : " + " pas de carte";
	// }

	public void recevoirCarte(Set<Carte> s) // les cartes envoyes par un autre
											// joueur
	{
		// cartesEnMain.addAll(s);
	}

	public void recevoirUneCarte(Carte ca) {
		cartesEnMain.ajouterCarteMain(ca);
	}

	public void piocher(int i, Pioche pioche) {
		while (pioche.isEmpty() == false) {
			for (int j = 0; j < i; j++) {
				cartesEnMain.add(pioche.prendreCarte());
			}
		}

	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", cartesEnMain=" + cartesEnMain
				+ ", cartefaceVisibles=" + cartefaceVisibles
				+ ", carteFacesCachees=" + carteFacesCachees + "]";
	}

	public void echangerCarte() {
		Scanner reader = new Scanner(System.in);
		System.out.print("Saisissez le numero  de la carte main a changer avec les cartes visibles:");
		int n = reader.nextInt();
		cartesEnMain.toString();
		cartefaceVisibles.toString();
	}

	
}
