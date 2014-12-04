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

	public boolean avoirAucuneCarte() {
		return (getCarteFacesCachees().isEmpty()
				&& getCartefaceVisibles().isEmpty() && getCartesEnMain()
				.isEmpty());
	}

	public void ajouterCartefacsVisible(Carte c) {
		cartefaceVisibles.ajouterCarteVisible(c);
	}

	public void ajouterCarteFaceCachee(Carte c) {
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

	public boolean estPossedeDansLamain(int valeur, int nombreOccurence) {
		int i = 0;
		for (Iterator<Carte> it = cartesEnMain.getCartemain().iterator(); it
				.hasNext();) {
			Carte carte = (Carte) it.next();
			if (valeur == carte.getValeur())
				i++;
		}
		return (nombreOccurence <= i);
	}

	public boolean jouerLibrement(Table tas) {
		System.out.print("Entrez le nombre de carte à jouer :");
		int nombreDeCarteAjouer = PartieDeCartes.reader.nextInt();
		System.out.print("Entrez la valeur de la carte a jouer (de 1 a 13) :");
		int valeur = PartieDeCartes.reader.nextInt();
		if (estPossedeDansLamain(valeur, nombreDeCarteAjouer)){
			HashSet<Carte> hc=new HashSet<Carte>();
			hc=cartesEnMain.supCarteMain(valeur,nombreDeCarteAjouer);
			tas.ajouterCarteTable(hc);
		}
		else
			System.out.println("Impossible vous ne posseder pas cette carte.");
		return true;
	}

	public void jouer(Carte c, int i) {
		// TODO Auto-generated method stub

	}

	public void envoyerTasSurJoueur(Joueur j, Table tas) {

		j.cartesEnMain.addAll(tas);
		tas.viderTas();
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
				cartesEnMain.ajouterCarteMain(pioche.prendreCarte());
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
		System.out
				.print("Saisissez le numero  de la carte main a changer avec les cartes visibles:");
		int n = PartieDeCartes.reader.nextInt();
		cartesEnMain.toString();
		cartefaceVisibles.toString();
	}

}
