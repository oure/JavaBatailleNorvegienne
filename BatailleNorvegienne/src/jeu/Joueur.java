package jeu;

/**
 * La classe Joueur
 *Elle definit en general un joueur, quil soit humain ou virtuel
 *Un joueur possede 3 types de cartes qui sont represente et contenu dans les attributs:
 *cartesEnMain, cartefaceVisibles et carteFacesCachees.
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
	 * Constructeur de Joueur avec parametre
	 * 
	 * @param nom
	 *            du joueur
	 */
	public Joueur(String nom) {
		this.nom = nom;
	}

	/**
	 * Constructeur vide
	 */
	public Joueur() {
	}

	/**
	 * Pour compter le nombre total de carte d'un joueur
	 * 
	 * @return un entier qui est le nombre de carte que possede le joueur
	 */
	public int nombreTotalDecarteQuePossedeUnJoueur() {
		return cartefaceVisibles.getCartesVisibles().size()
				+ carteFacesCachees.getCartesCachees().size()
				+ cartesEnMain.getCartemain().size();
	}

	/**
	 * cette methode permet au joueur d'ajouter une seule carte sur ses cartes
	 * en main
	 * 
	 * @param c
	 *            la carte que l'on souhaite ajouter
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
	 * face visible @param c la carte que l'on souhaite ajouter
	 */
	public void ajouterCartefacsVisible(Carte c) {
		cartefaceVisibles.ajouterCarteVisible(c);
	}

	/**
	 * cette methode permet au joueur d'ajouter une seule carte sur ses cartes
	 * de face cachee @ param c : la carte que l'on souhaite ajouter
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
	 *            par le joueur precedent
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

	/**
	 * Renvoie le nombre de personne qui vont passer leur tour, il y a autant de
	 * 8 poses que de joueurs qui passent leur tour
	 * 
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

	public boolean apteAContrerUnAs(Carte carte) {
		if (carte.getValeur() == 1 || carte.getValeur() == 2)
			return true;
		else
			return false;
	}

	public void seDefendreContreUnAs(Table table) {
		System.out.println("gzyyyyyyyg");
		System.out
				.print("Defender vous ! Un joueur veux vous envoyer le tas ! Quelles cartes voulez vous poser ?");
		int valeur = PartieDeCartes.reader.nextInt();
		System.out.println(estPossedeDansLamain(valeur, 1));
		if (estPossedeDansLamain(valeur, 1) && (valeur == 2 || valeur == 1))
			table.ajouterCartesTable(cartesEnMain.supCarteMain(valeur, 1));
		else {
			System.out
					.println("Vous ne possedez pas cette carte ou elle ne peut pas contrer un as !");
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

	/**
	 * Cet methode permet dobtenir le numero d un joueur
	 * 
	 * @param lj
	 *            est la liste de tous les joueurs
	 * @param j
	 *            est le joueur dont on veut avoir son numero
	 * @return le numero du joueur
	 */
	public int getNumeroduJoueurDansLaListeDeJoueur(LinkedList<Joueur> lj,
			Joueur j) {
		System.out.println(lj);
		System.out.println(j);
		for (int i = 0; i < lj.size(); i++) {
			if (lj.get(i) == j)
				return i;
		}
		return -1;
	}

	public boolean estUneCarteNonSpecial(Carte c) {
		if (c.getValeur() == 3 || c.getValeur() == 4 || c.getValeur() == 5
				|| c.getValeur() == 6 || c.getValeur() == 9
				|| c.getValeur() == 11 || c.getValeur() == 12
				|| c.getValeur() == 13)
			return true;
		else
			return false;
	}

	/**
	 * Envoi de la table sur un joueur si un AS a ete joue
	 * 
	 * @param derniereCartesPosees
	 * @param table
	 * @param lj
	 *            la liste des joueurs, ceci permet de choisir la victime en
	 *            fonction du type du joueur et de sa strategie, c est a dire
	 *            sur qui envoyer la table
	 */
	public void PoserUnAs(HashSet<Carte> derniereCartesPosees, Table table,
			LinkedList<Joueur> lj) {
		Joueur j = null;
		for (Iterator<Carte> iterator = derniereCartesPosees.iterator(); iterator
				.hasNext();) {
			Carte carte = (Carte) iterator.next();
			if (carte.getValeur() == 1) {
				j = choixDuJoueurCibleePourEnvoyerLaTable(lj);
				if (estCeQueJeSuisEnMesureDecontrerUnAs(j)) {
					System.out.println(j.getNom()
							+ " : \"Je suis en mesure de contrer l'as\"");
					j.seDefendreContreUnAs(table);
					return;
				} else {
					Carte c = null;
					if (cartesEnMain.isEmpty() && cartefaceVisibles.isEmpty()
							&& !carteFacesCachees.isEmpty()) {
						c = carteFacesCachees.prendreAuhasard();
						if (c.getValeur() == 2 || c.getValeur() == 1) {
							table.ajouterCarteALaTable(c);
							System.out
									.println("Vous avez contrer l'as en prennant au hasard une de vos cartes cachees !");
							return;
						} else {
							carteFacesCachees.getCartesCachees().add(c);
							System.out
									.println("Vous avez tirer au hasard une de vos cartes cachees mais vous n'avez pas ete capable de le contrer");
						}
					}
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
	 * Ceci permet au joueur qui a pose un As de choisir sur qui envoyer la
	 * table
	 * 
	 * @param lj
	 * @return le joueur qui sera victime
	 */
	public Joueur choixDuJoueurCibleePourEnvoyerLaTable(LinkedList<Joueur> lj) {
		PartieDeCartes.reader.nextLine();
		System.out
				.println("Entrez le nom du joueur sur qui vous voulez envoyer le table :");
		String nomDuJoueurCible = PartieDeCartes.reader.nextLine();
		nomDuJoueurCible.toLowerCase();
		System.out.println("Vous envoyez le tas sur :"+nomDuJoueurCible);
		for (Iterator<Joueur> iterator = lj.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			if (nomDuJoueurCible.equals(joueur.getNom().toLowerCase())) {
				return joueur;
			}
		}
		System.out.println("Vous avez specifier un nom incorrect monsieur !");
		PartieDeCartes.reader.nextLine();
		return choixDuJoueurCibleePourEnvoyerLaTable(lj);

	}

	/**
	 * Teste si un carte est posseder dans la main du joueur
	 * 
	 * @param valeur
	 *            de la carte a tester
	 * @param nombreOccurence
	 *            de la carte a tester
	 * @return un boolean vrai si le nombre d'nombreOccurence et la valeur de la
	 *         carte est possede dans ses cartes en main
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
	 * Teste si la valeur de la carte est supperieur ou egal a la carte de la
	 * table
	 * 
	 * @param valeur
	 *            entier qui represente la valeur de la carte a tester
	 * @param table
	 * @return vrai si la valeur de la carte que l'on veut jouer est supperieur
	 *         ou egal a la carte de la table
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
	 * @return boolean vrai si je peux jouer un 8
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
	 * @return boolean
	 */

	public boolean estCeQueLeJoueurPeutJouer(
			HashSet<Carte> derniereCartesPosees, Table table) {
		if (table.getListe().isEmpty())
			return true;
		if (!cartesEnMain.isEmpty()) {
			for (Iterator<Carte> it = cartesEnMain.getCartemain().iterator(); it
					.hasNext();) {
				Carte c = (Carte) it.next();
				if (estCeQueLeJoueurPeutJouerDesCartes(c.getValeur(), 1, table)) {
					return true;
				}
			}
			return false;
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
		if (table.laDerniereCarteDuJeuEstUnSept())
			if (estInferieurOuEgal(valeur, table)) {
				System.out.println(valeur);
				if (!table.isEmpty())
					System.out.println(table.getDerniereValeurCarteDuTas());
				System.out.println(estInferieurOuEgal(valeur, table));
				return true;
			} else
				return false;
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
	 * @return une collection de cartes, de type hashset, que le joueur veut
	 *         jouer
	 */
	public HashSet<Carte> jouerLibrement(Table table, Pioche pioche,
			HashSet<Carte> derniereCartesPosees,LinkedList<Joueur> lljoueur) {
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
					jouerLibrement(table, pioche, derniereCartesPosees,lljoueur);
				}

			} else {
				System.out
						.println("impossible vous ne pouvez pas poser cette carte !");
				jouerLibrement(table, pioche, derniereCartesPosees,lljoueur);
			}
		}
		if (cartesEnMain.getCartemain().isEmpty()
				&& cartefaceVisibles.getCartesVisibles().isEmpty()) {
			Carte carte;
			carte = carteFacesCachees.prendreAuhasard();
			hc.add(carte);
			if (estCeQueLeJoueurPeutJouerDesCartes(carte.getValeur(), 1, table)) {
				table.ajouterCartesTable(hc);
			} else {
				hc.clear();
				System.out.println("Je ne peux pas jouer cette carte");
				ajouterCartesEnMain(table.ramasserLeTas());
				System.out.println("Vous avez ramassez les cartes de la table " + getNom());
			}
			return hc;
		}
		return hc;
	}

	/**
	 * envoyer la table sur un joueur choisi
	 * 
	 * @param j
	 *            le joueur sur qui l'on veut envoyer la table
	 * @param table
	 */
	public void envoyerTasSurJoueur(Joueur j, Table table) {
		if (table.isEmpty())
			return;
		j.cartesEnMain.addAll(table);
		table.viderTable();
	}

	public void recevoirUneCarte(Carte ca) {
		cartesEnMain.ajouterCarteMain(ca);
	}

	/**
	 * piocher des cartes si la pioche n'est pas vide
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
	public void afficherLesCartes(){
		System.out.println("Vous possede dans votre main: "+cartesEnMain+" et dans vos cartes visibles: "+cartefaceVisibles);
	}

	/**
	 * Methode pour faire des echanges de cartes avant de commencer le jeu
	 * 
	 * @param tab
	 *            tableau d'entier qui contient les valeurs des 2 cartes a
	 *            echanger
	 * @return vrai si l'echange de carte a eu lieu
	 */

	public boolean echangerCartes(int tab[]) {
		int vCarte1 = tab[0];
		int vCarte2 = tab[1];
		System.out.println(this.getNom() +": j'echange " + vCarte1 + " avec " + vCarte2);
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
