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
	 * Constructeur d'un joueur avec paramètre
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
	/**cette methode permet au joueur  d'ajouter une seule carte  sur ses cartes  en main
	 * @ param c : une carte
	 */
	public void ajouterCarteEnMain(Carte c) {
		cartesEnMain.ajouterCarteMain(c);
	}

	public boolean avoirAucuneCarte() {
		return (getCarteFacesCachees().isEmpty()
				&& getCartefaceVisibles().isEmpty() && getCartesEnMain()
				.isEmpty());
	}

	/**cette methode permet au joueur  d'ajouter une seule carte  sur ses cartes de face visible
	 * @ param c : une carte
	 */
	public void ajouterCartefacsVisible(Carte c) {
		cartefaceVisibles.ajouterCarteVisible(c);
	}
	/**cette methode permet au joueur  d'ajouter une seule carte  sur ses cartes de face cachee
	 * @ param c : une carte
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
 * @param derniereCartesPosees par le joueur precedent
 * @param table 
 */
	public void PoserUnDix(HashSet<Carte> derniereCartesPosees, Table table) {
		for (Iterator<Carte> iterator = derniereCartesPosees.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (carte.getValeur() == 10) {
				table.viderTable();
				break;
			}
		}
	}

	/*
	 * renvoie le nombre de personne qui vont passer leur tour, il y a autant de
	 * 8 poses que de joueurs qui passent leur tour
	 */
	/**
	 * Cette methode renvoie le table sur un joueur lorsqu'un 8 est joue
	 * @param derniereCartesPosees
	 * @param table
	 * @return le nombre de 8 pose par un joueur
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
	
	public int nombreDeHuitQueLeJoueurPossede(){
		int i=0;
		if (!cartesEnMain.getCartemain().isEmpty()) {
			for (Iterator<Carte> iterator = cartesEnMain.getCartemain().iterator(); iterator.hasNext();) {
				Carte c = iterator.next();
				if (c.getValeur()==8)
					i++;
			}
		}
		else
			for (Iterator<Carte> iterator = cartefaceVisibles.getCartesVisibles().iterator(); iterator.hasNext();) {
				Carte c = (Carte) iterator.next();
				if (c.getValeur()==8)
					i++;
			}
		return i;
	}
	
	/**
	 * Cet methode permet dobtenir le numero d un joueur
	 * @param lj etant la lidte de tous les joueurs
	 * @param j etant le joueur dont on veut avoir son numero
	 * @return le numero du joueur
	 */
	public int getNumeroduJoueurDansLaListeDeJoueur(LinkedList<Joueur> lj,
			Joueur j) {
		for (int i = 0; i < lj.size() - 1; i++) {
			if (lj.get(i) == j)
				return i;
		}
		return -1;
	}
	/**
	 * Envoi du  table sur un joueur si un AS a ete joue
	 * @param derniereCartesPosees
	 * @param table
	 * @param lj : la liste des joueurs, ceci permet de choisir la victime , c est a dire sur qui envoyer le table
	 */

	public void PoserUnAs(HashSet<Carte> derniereCartesPosees, Table table,
			LinkedList<Joueur> lj) {
		Joueur j = null;
		for (Iterator<Carte> iterator = derniereCartesPosees.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (carte.getValeur() == 1) {
				if (this instanceof JoueurIA) {
					System.out.println("OMG JE SUIS UN JOUEUR IA");
					j = choixDuJoueurCibleePourEnvoyerLetable(lj);
					System.out.println("VICTIME : " + j);
				}
				envoyertableSurJoueur(j, table);
			}

		}
	}
/**
 * Ceci permet au joueur qui a pose un As de choisir sur qui envoyer le table
 * @param lj
 * @return le joueur qui sera victime
 */
	public Joueur choixDuJoueurCibleePourEnvoyerLetable(LinkedList<Joueur> lj) {
		System.out
				.println("Entrez le nom du joueur sur qui vous voulez envoyer le table :");
		String nomDuJoueurCible = PartieDeCartes.reader.nextLine();
		nomDuJoueurCible.toLowerCase();
		for (Iterator<Joueur> iterator = lj.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			if (nomDuJoueurCible.equals(joueur.getNom())) {
				return joueur;
			}
		}
		System.out.println("Vous avez specifier un nom incorrect monsieur !");
		return choixDuJoueurCibleePourEnvoyerLetable(lj);

	}
/**
 * tester combien de fois une valeur de carte est possede dans la main d'un joueur
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
	 *Methode pour tester si un joueur peut joueur en sachant la derniere carte jouee
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
	/**
	 * Methode pour tester si un joueur peut jouer un 8
	 * @param table
	 * @return
	 */

	public boolean estCeQueJePeuxJouerUnHuit(Table table) {
		if (table.afficherDerniereCarteDelaTable().getValeur() < 8)
			return true;
		else
			return false;
	}
	/**
	 *  methode qui teste la possibilite de jouer
	 * @param derniereCartesPosees
	 * @param table
	 * @return
	 */

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
			for (Iterator<Carte> iterator = cartefaceVisibles.getCartesVisibles()
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
		for (Iterator<Carte> it = cartefaceVisibles.getCartesVisibles().iterator(); it
				.hasNext();) {
			Carte carte = (Carte) it.next();
			if (valeur == carte.getValeur())
				i++;
		}
		return (nombreOccurence <= i);
	}

	/**
	 * Methode qui permet au joueur de jouer une ou des cartes  
	 * @param table
	 * @param pioche
	 * @param derniereCartesPosees
	 * @return une collection de cartes, de type hashset, que le joueur veut jouer
	 */
	public HashSet<Carte> jouerLibrement(Table table, Pioche pioche,
			HashSet<Carte> derniereCartesPosees) {
		HashSet<Carte> hc = new HashSet<Carte>();
		if (!cartesEnMain.getCartemain().isEmpty()
				|| !cartefaceVisibles.getCartesVisibles().isEmpty()) {
			System.out.print("Entrez le nombre de carte Ã  jouer :");
			int nombreDeCarteAjouer = PartieDeCartes.reader.nextInt();
			System.out
					.print("Entrez la valeur de la carte a jouer (de 1 a 13) :");
			int valeur = PartieDeCartes.reader.nextInt();
			if (estPossedeDansLamain(valeur, nombreDeCarteAjouer)) {
				hc = cartesEnMain.supCarteMain(valeur, nombreDeCarteAjouer);
				table.ajouterCarteTable(hc);
				for (int i = 0; i < hc.size(); i++) {
					ajouterCarteEnMain(pioche.prendreCarte());
				}

				return hc;
			} else if (cartesEnMain.getCartemain().isEmpty()) {
				if (estPossedeDansDansLesCartesVisibles(valeur,
						nombreDeCarteAjouer)) {
					hc = cartefaceVisibles.supCarteVisible(valeur,
							nombreDeCarteAjouer);
					table.ajouterCarteTable(hc);
					return hc;
				} else
					System.out
							.println("Impossible vous ne posseder pas cette cartes dans vos cartes visibles !");

			} else {
				System.out
						.println("Impossible vous ne posseder pas cette carte.");
				jouerLibrement(table, pioche, derniereCartesPosees);
			}
		}
		if (cartesEnMain.getCartemain().isEmpty()
				&& cartefaceVisibles.getCartesVisibles().isEmpty()) {
			table.ajouterCarteALaTable(carteFacesCachees.prendreAuhasard());
			return hc;
		}
		return hc;
	}
/**
 * envoyer le as sur un joueur choisi 
 * @param j
 * @param table
 */
	public void envoyertableSurJoueur(Joueur j, Table table) {
		j.cartesEnMain.addAll(table);
		table.viderTable();
	}

	public void recevoirUneCarte(Carte ca) {
		cartesEnMain.ajouterCarteMain(ca);
	}
/**
 * piocher des cartes aprés avoir jouer
 * @param i
 * @param pioche
 */
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
	
	/**
	 * Methode pour faire des echanges de cartes avant de commencer le jeu
	 * @param tab
	 * @return vrai si le joueur est pret a echanger des cartes avant le demarrage du jeu 
	 */

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
			for (Iterator<Carte> it = cartefaceVisibles.getCartesVisibles().iterator(); it
					.hasNext();) {
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
		} else
			System.out.println("Impossible vous ne posseder pas cette carte.");
		return true;

	}

}
