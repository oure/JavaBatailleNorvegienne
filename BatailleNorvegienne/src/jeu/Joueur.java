package jeu;

import java.util.*;

public class Joueur {
	private String nom;
	protected CartesEnMain cartesEnMain = new CartesEnMain();
	protected CartesfacesVisibles cartefaceVisibles = new CartesfacesVisibles();
	protected CartesFacesCachees carteFacesCachees = new CartesFacesCachees();

	public Joueur(String nom) {
		this.nom = nom;
	}

	public Joueur() {
	}

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

	public void PoserUnDix(HashSet<Carte> derniereCartesPosees, Table table) {
		for (Iterator<Carte> iterator = derniereCartesPosees.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (carte.getValeur() == 10) {
				table.viderTas();
				break;
			}
		}
	}

	/*
	 * renvoie le nombre de personne qui vont passer leur tour, il y a autant de
	 * 8 poses que de joueurs qui passent leur tour
	 */
	public int PoserUnHuit(HashSet<Carte> derniereCartesPosees, Table table) {
		int nombreDeHuit = 0;
		for (Iterator<Carte> iterator = derniereCartesPosees.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (carte.getValeur() == 8) {
				nombreDeHuit++;
			}
		}
		return nombreDeHuit;
	}

	public int getNumeroduJoueurDansLaListeDeJoueur(LinkedList<Joueur> lj,
			Joueur j) {
		for (int i = 0; i < lj.size() - 1; i++) {
			if (lj.get(i) == j)
				return i;
		}
		return -1;
	}

	public void PoserUnAs(HashSet<Carte> derniereCartesPosees, Table table,
			LinkedList<Joueur> lj) {
		Joueur j = null;
		for (Iterator<Carte> iterator = derniereCartesPosees.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (carte.getValeur() == 1) {
				if (this instanceof JoueurIA) {
					System.out.println("OMG JE SUIS UN JOUEUR IA");
					j = choixDuJoueurCibleePourEnvoyerLetas(lj);
					System.out.println("VICTIME : " + j);
				}
				envoyerTasSurJoueur(j, table);
			}

		}
	}

	public Joueur choixDuJoueurCibleePourEnvoyerLetas(LinkedList<Joueur> lj) {
		System.out
				.println("Entrez le nom du joueur sur qui vous voulez envoyer le tas :");
		String nomDuJoueurCible = PartieDeCartes.reader.nextLine();
		nomDuJoueurCible.toLowerCase();
		for (Iterator<Joueur> iterator = lj.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			if (nomDuJoueurCible.equals(joueur.getNom())) {
				return joueur;
			}
		}
		System.out.println("Vous avez specifier un nom incorrect monsieur !");
		return choixDuJoueurCibleePourEnvoyerLetas(lj);

	}

	public boolean estPossedeDansLamain(int valeur, int nombreOccurence) {
		int i = 0;
		for (Iterator<Carte> it = cartesEnMain.getCartemain().iterator(); it
				.hasNext();) {
			Carte carte = (Carte) it.next();
			if (valeur == carte.getValeur()) {
				i++;
			}
		}
		return (nombreOccurence <= i);
	}

	public boolean estSuperieureOuEgal(int valeur, Table tas) {
		if (tas.getListe().isEmpty()
				|| tas.getListe().getLast().getValeur() <= valeur)
			return true;
		else
			return false;
	}

	public boolean estCeQueJePeuxJouerUnHuit(Table table) {
		if (table.afficherDerniereCarteDuTas().getValeur() < 8)
			return true;
		else
			return false;
	}

	public boolean estCeQueLeJoueurPeutJouer(
			HashSet<Carte> derniereCartesPosees, Table table) {
		if (!cartesEnMain.isEmpty())
			for (Iterator<Carte> it = cartesEnMain.getCartemain().iterator(); it
					.hasNext();) {
				Carte c = (Carte) it.next();
				if (estCeQueLeJoueurPeutJouerDesCartes(derniereCartesPosees,
						c.getValeur(), 1, table)) {
					return true;
				}
			}
		if (cartesEnMain.isEmpty() && !cartefaceVisibles.isEmpty())
			for (Iterator<Carte> iterator = cartefaceVisibles.getHs()
					.iterator(); iterator.hasNext();) {
				Carte carte = (Carte) iterator.next();
				if (estCeQueLeJoueurPeutJouerDesCartes(derniereCartesPosees,
						carte.getValeur(), 1, table))
					return true;
			}
		if (cartesEnMain.isEmpty() && cartefaceVisibles.isEmpty()
				&& !carteFacesCachees.isEmpty())
			return true;
		return false;
	}

	public boolean estCeQueLeJoueurPeutJouerDesCartes(
			HashSet<Carte> derniereCartesPosees, int valeur,
			int nombreOccurence, Table table) {
		if (valeur == 2)
			return true;
		if (valeur == 8) {
			System.out.println("JE VEUX JOUER UN 8");
			if (estCeQueJePeuxJouerUnHuit(table))
				return true;
			else
				return false;
		}
		if (derniereCartesPosees == null || estSuperieureOuEgal(valeur, table)) {
			return true;
		} else
			return false;
	}

	public boolean estPossedeDansDansLesCartesVisibles(int valeur,
			int nombreOccurence) {
		int i = 0;
		for (Iterator<Carte> it = cartefaceVisibles.getHs().iterator(); it
				.hasNext();) {
			Carte carte = (Carte) it.next();
			if (valeur == carte.getValeur())
				i++;
		}
		return (nombreOccurence <= i);
	}

	public HashSet<Carte> jouerLibrement(Table tas, Pioche pioche,
			HashSet<Carte> derniereCartesPosees) {
		HashSet<Carte> hc = new HashSet<Carte>();
		if (!cartesEnMain.getCartemain().isEmpty()
				|| !cartefaceVisibles.getHs().isEmpty()) {
			System.out.print("Entrez le nombre de carte à jouer :");
			int nombreDeCarteAjouer = PartieDeCartes.reader.nextInt();
			System.out
					.print("Entrez la valeur de la carte a jouer (de 1 a 13) :");
			int valeur = PartieDeCartes.reader.nextInt();
			if (estPossedeDansLamain(valeur, nombreDeCarteAjouer)) {
				hc = cartesEnMain.supCarteMain(valeur, nombreDeCarteAjouer);
				tas.ajouterCarteTable(hc);
				for (int i = 0; i < hc.size(); i++) {
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
				} else
					System.out
							.println("Impossible vous ne posseder pas cette cartes dans vos cartes visibles !");

			} else {
				System.out
						.println("Impossible vous ne posseder pas cette carte.");
				jouerLibrement(tas, pioche, derniereCartesPosees);
			}
		}
		if (cartesEnMain.getCartemain().isEmpty()
				&& cartefaceVisibles.getHs().isEmpty()) {
			tas.ajouterCarteALaTable(carteFacesCachees.prendreAuhasard());
			return hc;
		}
		return hc;
	}

	public void envoyerTasSurJoueur(Joueur j, Table tas) {
		j.cartesEnMain.addAll(tas);
		tas.viderTas();
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

	public int[] choixDesCartesAEchanger() {
		int tab[]= new int[2];
		System.out
				.print("Entrez la valeur de la carte en main a echanger (de 1 a 13) :");
		int vCarte1 = PartieDeCartes.reader.nextInt();
		System.out
				.print("Entrez la valeur de la carte visible a echanger (de 1 a 13) :");
		int vCarte2 = PartieDeCartes.reader.nextInt();
		tab[0]=vCarte1;
		tab[1]=vCarte2;
		return tab;
	}

	public boolean echangerCarte(int tab[]) {
		int vCarte1=tab[0];
		int vCarte2=tab[1];
		System.out.println("vCarte1 : "+vCarte1+" - "+vCarte2+"vCarte2");
		Carte c1 = null;
		Carte c2 = null;
		cartesEnMain.toString();
		cartefaceVisibles.toString();
		if (estPossedeDansLamain(vCarte1, 1)
				&& estPossedeDansDansLesCartesVisibles(vCarte2, 1)) {
			for (Iterator<Carte> it = cartesEnMain.getCartemain().iterator(); it
					.hasNext();) {
				Carte c = (Carte) it.next();
				if (c.getValeur() == vCarte1) {
					c1 = c;
					break;
				}
			}
			for (Iterator<Carte> it = cartefaceVisibles.getHs().iterator(); it
					.hasNext();) {
				Carte c = (Carte) it.next();
				if (c.getValeur() == vCarte2) {
					c2 = c;
					break;
				}
			}
			cartefaceVisibles.getHs().add(c1);
			cartesEnMain.getCartemain().add(c2);
			cartesEnMain.getCartemain().remove(c1);
			cartefaceVisibles.getHs().remove(c2);
		} else
			System.out.println("Impossible vous ne posseder pas cette carte.");
		return true;

	}

}
