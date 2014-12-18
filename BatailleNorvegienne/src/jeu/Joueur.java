package jeu;

/**
 * La classe joueur
 *Elle definit en general un joueur, quil soit humain ou virtuel
 */
import java.util.*;

public class Joueur {
	/**
	 * les attributs de la classe joueur
	 */
	private String nom;
	protected CartesEnMain cartesEnMain = new CartesEnMain();
	protected CartesfacesVisibles cartefaceVisibles = new CartesfacesVisibles();
	protected CartesFacesCachees carteFacesCachees = new CartesFacesCachees();

	/**
	 * Constructeur d'un joueur avec param�tre
	 * 
	 * @param nom
	 */
	public Joueur(String nom) {
		this.nom = nom;
	}

	public Joueur() {
	}

	/**
	 * Pour compter le nombre total de carte d'un joueur
	 */
	public int nombreTotalDecarteQuePossedeUnJoueur() {
		return cartefaceVisibles.getCartesVisibles().size()
				+ carteFacesCachees.getCartesCachees().size()
				+ cartesEnMain.getCartemain().size();
	}

	/**
	 * cette methode permet au joueur d'ajouter une seule carte sur ses cartes
	 * en main @ param c : une carte
	 */
	public void ajouterCarteEnMain(Carte c) {
		cartesEnMain.ajouterCarteMain(c);
	}

	public boolean avoirAucuneCarte() {
		return (getCarteFacesCachees().isEmpty()
				&& getCartefaceVisibles().isEmpty() && getCartesEnMain()
				.isEmpty());
	}

	/**
	 * cette methode permet au joueur d'ajouter une seule carte sur ses cartes
	 * de face visible @ param c : une carte
	 */
	public void ajouterCartefacsVisible(Carte c) {
		cartefaceVisibles.ajouterCarteVisible(c);
	}

	/**
	 * cette methode permet au joueur d'ajouter une seule carte sur ses cartes
	 * de face cachee @ param c : une carte
	 */

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

	/**
	 * methode qui supprime la table si un 10 a ete pose
	 * 
	 * @param derniereCartesPosees
	 * @param table
	 */
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
	/**
	 * Cette methode renvoie le tas sur un joueur lorsqu'un 8 est joue
	 * 
	 * @param derniereCartesPosees
	 * @param table
	 * @return
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

	public boolean apteAContrerUnAs(Carte carte) {
		if (carte.getValeur() == 1 || carte.getValeur() == 2)
			return true;
		else
			return false;
	}

	public void seDefendreContreUnAs(Table table) {
		System.out.println("gzyyyyyyyg");
		System.out.print("Defender vous ! Un joueur veux vous envoyer le tas ! Quelles cartes voulez vous poser ?");
		int valeur = PartieDeCartes.reader.nextInt();
		System.out.println(estPossedeDansLamain(valeur, 1));
		if (estPossedeDansLamain(valeur, 1) && (valeur==2 || valeur==1))
			table.ajouterCartesTable(cartesEnMain.supCarteMain(valeur, 1));
		else {
			System.out.println("Vous ne posseder pas cette carte ou elle ne peux pas contrer un as !");
			seDefendreContreUnAs(table);
		}
	}

	public boolean estCeQueJeSuisEnMesureDecontrerUnAs(Joueur j) {
		if (!j.getCartesEnMain().isEmpty())
			for (Iterator<Carte> iterator = j.getCartesEnMain().getCartemain()
					.iterator(); iterator.hasNext();) {
				Carte carte = iterator.next();
				if (apteAContrerUnAs(carte))
					return true;
			}
		else
			return false;
		if (!j.getCartefaceVisibles().isEmpty()
				&& j.getCartesEnMain().isEmpty())
			for (Iterator<Carte> iterator = j.getCartefaceVisibles()
					.getCartesVisibles().iterator(); iterator.hasNext();) {
				Carte carte = iterator.next();
				if (apteAContrerUnAs(carte))
					return true;
			}
		else
			return false;
		return false;
	}

	public int nombreDeHuitQueLeJoueurPossede() {
		int i = 0;
		if (!cartesEnMain.getCartemain().isEmpty()) {
			for (Iterator<Carte> iterator = cartesEnMain.getCartemain()
					.iterator(); iterator.hasNext();) {
				Carte c = iterator.next();
				if (c.getValeur() == 8)
					i++;
			}
		} else
			for (Iterator<Carte> iterator = cartefaceVisibles
					.getCartesVisibles().iterator(); iterator.hasNext();) {
				Carte c = (Carte) iterator.next();
				if (c.getValeur() == 8)
					i++;
			}
		return i;
	}

	public int getNumeroduJoueurDansLaListeDeJoueur(LinkedList<Joueur> lj,
			Joueur j) {
		for (int i = 0; i < lj.size(); i++) {
			if (lj.get(i) == j)
				return i;
		}
		return -1;
	}

	/**
	 * Envoi du tas sur un joueur si un AS a ete joue
	 * 
	 * @param derniereCartesPosees
	 * @param table
	 * @param lj
	 */
	public void PoserUnAs(HashSet<Carte> derniereCartesPosees, Table table,
			LinkedList<Joueur> lj) {
		Joueur j = null;
		for (Iterator<Carte> iterator = derniereCartesPosees.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (carte.getValeur() == 1) {
				j = choixDuJoueurCibleePourEnvoyerLetas(lj);
				if (estCeQueJeSuisEnMesureDecontrerUnAs(j)) {
					System.out.println(j.getNom()
							+ " : \"Je suis en mesure de contrer l'as\"");
					j.seDefendreContreUnAs(table);
					return;
				} else {
					System.out
							.println("Je suis suis pas en mesure de contrer l'as");
					envoyerTasSurJoueur(j, table);
					System.out.println(j);
				}
				return;
			}
		}
	}

	/**
	 * Ceci permet au joueur qui a pose un As de choisir sur qui envoyer le tas
	 * 
	 * @param lj
	 * @return
	 */
	public Joueur choixDuJoueurCibleePourEnvoyerLetas(LinkedList<Joueur> lj) {
		PartieDeCartes.reader.nextLine();
		System.out
				.println("Entrez le nom du joueur sur qui vous voulez envoyer le tas :");
		String nomDuJoueurCible = PartieDeCartes.reader.nextLine();
		nomDuJoueurCible.toLowerCase();
		System.out.println("----" + nomDuJoueurCible + "------");
		for (Iterator<Joueur> iterator = lj.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			if (nomDuJoueurCible.equals(joueur.getNom().toLowerCase())) {
				System.out.println(joueur);
				return joueur;
			}
		}
		System.out.println("Vous avez specifier un nom incorrect monsieur !");
		PartieDeCartes.reader.nextLine();
		return choixDuJoueurCibleePourEnvoyerLetas(lj);

	}

	/**
	 * tester combien de fois une valeur de carte est possede dans la main d'un
	 * joueur
	 * 
	 * @param valeur
	 * @param nombreOccurence
	 * @return un boolean
	 */
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

	/**
	 * Methode pour tester si un joueur peut joueur en sachant la derniere carte
	 * jouee
	 * 
	 * @param valeur
	 * @param table
	 * @return
	 */

	public boolean estSuperieureOuEgal(int valeur, Table table) {
		if (table.getListe().isEmpty()
				|| table.getListe().getLast().getValeur() <= valeur)
			return true;
		else
			return false;
	}

	public boolean estInferieurOuEgal(int valeur, Table table) {
		if (table.getListe().isEmpty()
				|| table.getListe().getLast().getValeur() >= valeur)
			return true;
		else
			return false;
	}

	/**
	 * Methode pour tester si un joueur peut jouer un 8
	 * 
	 * @param table
	 * @return
	 */

	public boolean estCeQueJePeuxJouerUnHuit(Table table) {
		if (table.isEmpty() || table.getDerniereCarteDuTas().getValeur() < 8)
			return true;
		else
			return false;
	}

	/**
	 * methode qui teste la possibilite de jouer
	 * 
	 * @param derniereCartesPosees
	 * @param table
	 * @return
	 */

	public boolean estCeQueLeJoueurPeutJouer(
			HashSet<Carte> derniereCartesPosees, Table table) {
		if (table.getListe().isEmpty())
			return true;
		if (!cartesEnMain.isEmpty())
			for (Iterator<Carte> it = cartesEnMain.getCartemain().iterator(); it
					.hasNext();) {
				Carte c = (Carte) it.next();
				if (estCeQueLeJoueurPeutJouerDesCartes(c.getValeur(), 1, table)) {
					return true;
				}
			}
		if (cartesEnMain.isEmpty() && !cartefaceVisibles.isEmpty())
			for (Iterator<Carte> iterator = cartefaceVisibles
					.getCartesVisibles().iterator(); iterator.hasNext();) {
				Carte carte = (Carte) iterator.next();
				if (estCeQueLeJoueurPeutJouerDesCartes(carte.getValeur(), 1,
						table))
					return true;
			}
		if (cartesEnMain.isEmpty() && cartefaceVisibles.isEmpty()
				&& !carteFacesCachees.isEmpty())
			return true;
		return false;
	}

	public boolean estCeQueLeJoueurPeutJouerDesCartes(int valeur,
			int nombreOccurence, Table table) {
		if (valeur == 2 || valeur == 1)
			return true;
		if (table.possedeUnSept() && estInferieurOuEgal(valeur, table))
			return true;
		if (valeur == 8) {
			if (estCeQueJePeuxJouerUnHuit(table))
				return true;
			else
				return false;
		}
		if (table.getListe().isEmpty() || estSuperieureOuEgal(valeur, table)) {
			return true;
		} else
			return false;
	}

	public boolean estPossedeDansDansLesCartesVisibles(int valeur,
			int nombreOccurence) {
		int i = 0;
		for (Iterator<Carte> it = cartefaceVisibles.getCartesVisibles()
				.iterator(); it.hasNext();) {
			Carte carte = (Carte) it.next();
			if (valeur == carte.getValeur())
				i++;
		}
		return (nombreOccurence <= i);
	}

	/**
	 * Methode qui permet au joueur de jouer une ou des cartes
	 * 
	 * @param table
	 * @param pioche
	 * @param derniereCartesPosees
	 * @return
	 */
	public HashSet<Carte> jouerLibrement(Table table, Pioche pioche,
			HashSet<Carte> derniereCartesPosees) {
		HashSet<Carte> hc = new HashSet<Carte>();
		if (!pioche.isEmpty() && cartesEnMain.isEmpty()) {
			piocher(pioche);
			return hc;
		}
		if (!cartesEnMain.getCartemain().isEmpty()
				|| !cartefaceVisibles.getCartesVisibles().isEmpty()) {
			System.out.print("Entrez le nombre de carte à jouer :");
			int nombreDeCarteAjouer = PartieDeCartes.reader.nextInt();
			System.out
					.print("Entrez la valeur de la carte a jouer (de 1 a 13) :");
			int valeur = PartieDeCartes.reader.nextInt();
			if (estPossedeDansLamain(valeur, nombreDeCarteAjouer)
					&& estCeQueLeJoueurPeutJouerDesCartes(valeur,
							nombreDeCarteAjouer, table)) {
				hc = cartesEnMain.supCarteMain(valeur, nombreDeCarteAjouer);
				table.ajouterCartesTable(hc);
				for (int i = 1; i <= hc.size(); i++) {
					piocher(pioche);
				}
				return hc;
			} else if (cartesEnMain.getCartemain().isEmpty()) {
				if (estPossedeDansDansLesCartesVisibles(valeur,
						nombreDeCarteAjouer)
						&& estCeQueLeJoueurPeutJouerDesCartes(valeur,
								nombreDeCarteAjouer, table)) {
					hc = cartefaceVisibles.supCarteVisible(valeur,
							nombreDeCarteAjouer);
					table.ajouterCartesTable(hc);
					for (int i = 1; i <= hc.size(); i++) {
						piocher(pioche);
					}
					return hc;
				} else {
					System.out
							.println("Impossible vous ne pouvez pas poser cette carte !");
					jouerLibrement(table, pioche, derniereCartesPosees);
				}

			} else {
				System.out
						.println("impossible vous ne pouvez pas poser cette carte !");
				jouerLibrement(table, pioche, derniereCartesPosees);
			}
		}
		if (cartesEnMain.getCartemain().isEmpty()
				&& cartefaceVisibles.getCartesVisibles().isEmpty()) {
			Carte carte;
			carte = carteFacesCachees.prendreAuhasard();
			hc.add(carte);
			if (estCeQueLeJoueurPeutJouerDesCartes(carte.getValeur(), 1, table)) {
				System.out.println("JE PEUX JOUER CETTE CARTE");
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

	/**
	 * envoyer la table sur un joueur choisi
	 * 
	 * @param j
	 * @param table
	 */
	public void envoyerTasSurJoueur(Joueur j, Table table) {
		if (table.isEmpty())
			return;
		j.cartesEnMain.addAll(table);
		System.out.println("ETAT DE LA TABLE: " + table);
		table.viderTas();
	}

	public void recevoirUneCarte(Carte ca) {
		cartesEnMain.ajouterCarteMain(ca);
	}

	/**
	 * piocher des cartes apr�s avoir jouer
	 * 
	 * @param pioche
	 */
	public void piocher(Pioche pioche) {
		if (!pioche.isEmpty())
			ajouterCarteEnMain(pioche.prendreCarte());
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", cartesEnMain=" + cartesEnMain
				+ ", cartefaceVisibles=" + cartefaceVisibles
				+ ", carteFacesCachees=" + carteFacesCachees + "]";
	}

	public int[] choixDesCartesAEchanger() {
		int tab[] = new int[2];
		System.out
				.print("Entrez la valeur de la carte en main a echanger (de 1 a 13) :");
		int vCarte1 = PartieDeCartes.reader.nextInt();
		System.out
				.print("Entrez la valeur de la carte visible a echanger (de 1 a 13) :");
		int vCarte2 = PartieDeCartes.reader.nextInt();
		tab[0] = vCarte1;
		tab[1] = vCarte2;
		return tab;
	}

	/**
	 * Methode pour faire des echanges de cartes avant de commencer le jeu
	 * 
	 * @param tab
	 * @return
	 */

	public boolean echangerCarte(int tab[]) {
		int vCarte1 = tab[0];
		int vCarte2 = tab[1];
		System.out
				.println("vCarte1 : " + vCarte1 + " - " + vCarte2 + "vCarte2");
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
			for (Iterator<Carte> it = cartefaceVisibles.getCartesVisibles()
					.iterator(); it.hasNext();) {
				Carte c = (Carte) it.next();
				if (c.getValeur() == vCarte2) {
					c2 = c;
					break;
				}
			}
			cartefaceVisibles.getCartesVisibles().add(c1);
			cartesEnMain.getCartemain().add(c2);
			cartesEnMain.getCartemain().remove(c1);
			cartefaceVisibles.getCartesVisibles().remove(c2);
		} else {
			System.out.println("Impossible vous ne posseder pas cette carte.");
			return false;
		}
		return true;

	}

	public void ajouterCartesEnMain(HashSet<Carte> hsCartes) {
		for (Iterator<Carte> iterator = hsCartes.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			cartesEnMain.ajouterCarteMain(carte);
		}

	}

}
