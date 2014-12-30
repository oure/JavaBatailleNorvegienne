package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;

import jeu.Carte;
import jeu.CartesEnMain;
import jeu.CartesFacesCachees;
import jeu.CartesfacesVisibles;
import jeu.Joueur;
import jeu.JoueurIA;
import jeu.PartieDeCartes;
import jeu.Pioche;
import jeu.Table;
import vue.BNVue;

public class BNControleur {
	public Object object=new String("2");
	private BNVue vue;
	private PartieDeCartes pdc;
	private boolean clicked = false;
	private int valeur;
	private int couleur;
	private int nombreDeCarteAjouer = 1;

	public BNControleur(BNVue vue, PartieDeCartes pdc) {
		this.vue = vue;
		this.pdc = pdc;
		vue.addBNListener(new BouttonLancerListenner());
	}

	public void desalouageListener() {
		for (Iterator<JButton> iterator = vue.getbCartesEnMain().iterator(); iterator
				.hasNext();) {
			JButton bouton = iterator.next();
			bouton.removeActionListener(new BouttonCartesEnMainListener());
		}
		for (Iterator<JButton> iterator = vue.getbCartesVisibles().iterator(); iterator
				.hasNext();) {
			JButton bouton = iterator.next();
			bouton.removeActionListener(new BoutonCartesVisiblesListener());
		}
		for (Iterator<JButton> iterator = vue.getbCartesCachees().iterator(); iterator
				.hasNext();) {
			JButton bouton = iterator.next();
			bouton.removeActionListener(new BoutonCartesCacheesListener());
		}
	}

	public void miseAJourEcouteBoutons() {
		System.out.println("MISE EN PLACE DES LISTENNER");
		for (Iterator<JButton> iterator = vue.getbCartesEnMain().iterator(); iterator
				.hasNext();) {
			JButton bouton = iterator.next();
			vue.addBoutonCartes(bouton, new BouttonCartesEnMainListener());
		}
		for (Iterator<JButton> iterator = vue.getbCartesVisibles().iterator(); iterator
				.hasNext();) {
			JButton bouton = iterator.next();
			vue.addBoutonCartes(bouton, new BoutonCartesVisiblesListener());
		}
		for (Iterator<JButton> iterator = vue.getbCartesCachees().iterator(); iterator
				.hasNext();) {
			JButton bouton = iterator.next();
			vue.addBoutonCartes(bouton, new BoutonCartesCacheesListener());
		}
	}

	class BouttonLancerListenner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean erreur = false;
			int a = vue.getNombreDeJoueur();
			if (a == -1 || a < 2 || a > 20) {
				vue.setTexteNbJoueur("il doit etre compris entre 2 et 20 !");
				erreur = true;
			}
			String name = vue.getNomDuJoueur();
			if (name == "" || name == null) {
				vue.setTexteNom("Votre nom ne doit pas être vide !");
				erreur = true;
			}
			if (erreur)
				return;
			System.out.println("tout est ok lancement de la partie");
			pdc = new PartieDeCartes();
			pdc.miseEnPlaceDeLaListeDesJoueurs(a, name);
			pdc.miseEnPlaceDesJeuxdeCartes();
			pdc.distribuer();
			vue.MiseEnPlaceDuPlateau();
			miseAJourDeLaffichage();
			miseAJourEcouteBoutons();
			pdc.decalerListedesJoueurs(); // Le distributeur joue en dernier
			pdc.afficherListeDesJoueurs();
			// vue.choixListeJoueurLancerTas(pdc.getListeDesJoueurs());
			vue.changerDePanel(1);
			System.out.println("JE CHANGE LA VUE");
			synchronized(object)
            {
				object.notify();// je débloque
				System.out.println("UNLOCK DU GAME");

            }  
		}
	}

	class BouttonCartesEnMainListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			synchronized (this) {
				this.notify();// je débloque

			}
			System.out
					.println("Vous avez cliquez sur une carte dans votre main !");
			String nomCarte = getButtonName((JButton) e.getSource());
			valeur = Integer.parseInt(nomCarte.substring(0, 1));
			String couleur= (nomCarte.substring(2,nomCarte.length() );

			System.out.println(valeur);
			clicked = true;
		}
	}

	class BoutonCartesVisiblesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out
					.println("Vous avez cliquez sur une de vos cartes visibles !");
			String nomCarte = getButtonName((JButton) e.getSource());
			valeur = Integer.parseInt(nomCarte.substring(0, 1));
			clicked = true;

		}
	}

	class BoutonCartesCacheesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String nomCarte = getButtonName((JButton) e.getSource());
			System.out.println(nomCarte);
			valeur = Integer.parseInt(nomCarte.substring(0, 1));
			clicked = true;
		}
	}

	public ArrayList<String> avoirLaListeDesFichierImagesCartesEnMain() {
		ArrayList<String> liste = new ArrayList<String>();
		HashSet<Carte> hc = pdc.getCartesEnMainJoueurHumain();
		for (Iterator<Carte> iterator = hc.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			String valeur = Integer.toString(carte.getValeur());
			String couleur = carte.getCouleur().toString().toLowerCase();
			liste.add(valeur + "_" + couleur + ".png");
		}
		return liste;
	}

	public ArrayList<String> avoirLaListeDesFichierImagesCartesVisibles() {
		ArrayList<String> liste = new ArrayList<String>();
		HashSet<Carte> hc = pdc.getCartesVisiblesJoueurHumain();
		for (Iterator<Carte> iterator = hc.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			String valeur = Integer.toString(carte.getValeur());
			String couleur = carte.getCouleur().toString().toLowerCase();
			liste.add(valeur + "_" + couleur + ".png");
		}
		return liste;
	}

	public ArrayList<String> avoirLaListeDesFichierImagesCartesCachees() {
		ArrayList<String> liste = new ArrayList<String>();
		HashSet<Carte> hc = pdc.getCartesEnMainJoueurHumain();
		for (Iterator<Carte> iterator = hc.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			String valeur = Integer.toString(carte.getValeur());
			String couleur = carte.getCouleur().toString().toLowerCase();
			liste.add(valeur + "_" + couleur + ".png");
		}
		return liste;
	}

	public String recupererDerniereCarteDuTas() {
		if (pdc.getTable().isEmpty())
			return "";
		Carte carte = pdc.getTable().getDerniereCarteDuTas();
		String valeur = Integer.toString(carte.getValeur());
		String couleur = carte.getCouleur().toString().toLowerCase();
		return valeur + "_" + couleur + ".png";
	}

	public void miseAJourDeLaffichage() {
		vue.AfficherCartesCachees(avoirLaListeDesFichierImagesCartesCachees());
		vue.AfficheCartesVisibles(avoirLaListeDesFichierImagesCartesVisibles());
		vue.AfficheCartesEnMain(avoirLaListeDesFichierImagesCartesEnMain());
		vue.AfficherDerniereCarteDuTas(recupererDerniereCarteDuTas());
	}

	public String getButtonName(JButton myButton) {
		return myButton.getName().substring(0, myButton.getName().length() - 4);
	}

	public synchronized void lancementDeLaPartie() {
		deroulementDujeu();
	}

	public void deroulementDujeu() {
		System.out.println("JE DEREOULE LE JEU AIGHT");
		Joueur gagnant = null;
		boolean cond = true;
		int compteurPourPasserLesTours = 0; // compte le nombre de joueur qui
											// vont passer leur tour apres que
											// de 8 ont etes jouees
		boolean passerLeTour = false;
		int nombreDejoueurQuiPasseLeurTour = 0;
		int tour = 1;
		// pdc.echangerLesCartes();
		HashSet<Carte> derniereCartesPosees = new HashSet<Carte>();
		while (cond) {
			for (Iterator<Joueur> iterator = pdc.getListeDesJoueurs()
					.iterator(); iterator.hasNext();) {
				Joueur joueur = (Joueur) iterator.next();
				if (!passerLeTour) {
					System.out.println("\nA vous de jouer " + joueur.getNom()
							+ " !");
					if (pdc.getListeDesJoueurs().get(0) == joueur && tour != 1) {
						pdc.getListeDesJoueurs().get(0).afficherLesCartes();
					}
					if (joueur.estCeQueLeJoueurPeutJouer(derniereCartesPosees,
							pdc.getTable())) {
						derniereCartesPosees.clear();
						derniereCartesPosees = jouerLibrement(joueur,
								pdc.getTable(), pdc.getPioche(),
								derniereCartesPosees, pdc.getListeDesJoueurs());
						System.out.println("Les dernieres cartes posees sont "
								+ derniereCartesPosees);
						joueur.PoserUnDix(derniereCartesPosees, pdc.getTable());
						joueur.PoserUnAs(derniereCartesPosees, pdc.getTable(),
								pdc.getListeDesJoueurs());
						nombreDejoueurQuiPasseLeurTour = joueur.PoserUnHuit(
								derniereCartesPosees, pdc.getTable());
					} else {
						joueur.ajouterCartesEnMain(pdc.getTable()
								.ramasserLeTas());
						System.out
								.println("Vous avez ramassez le contenu de la table "
										+ joueur.getNom());
					}
					if (nombreDejoueurQuiPasseLeurTour != 0) {
						passerLeTour = true;
					}
					if (joueur.avoirAucuneCarte()) {
						gagnant = joueur;
						cond = false;
						break;
					}
				} else {
					System.out.println("Je passe mon tour " + joueur.getNom());
					if (compteurPourPasserLesTours + 1 >= nombreDejoueurQuiPasseLeurTour) {
						passerLeTour = false;
						nombreDejoueurQuiPasseLeurTour = 0;
					} else
						compteurPourPasserLesTours++;
				}
				tour++;
			}
		}
		System.out.println("Felicitation " + gagnant.getNom()
				+ " vous avez vaincu !\n-Voulez vous jouer a nouveau ? O/n");
	}

	public HashSet<Carte> jouerLibrement(Joueur j, Table table, Pioche pioche,
			HashSet<Carte> derniereCartesPosees, LinkedList<Joueur> lljoueur) {
		if (j instanceof Joueur) {
			return jouerLibrementHumain(table, pioche, derniereCartesPosees,
					lljoueur);
		} else
			return ((JoueurIA) j).jouerLibrement(table, pioche,
					derniereCartesPosees, lljoueur);
	}

	public HashSet<Carte> jouerLibrementHumain(Table table, Pioche pioche,
			HashSet<Carte> derniereCartesPosees, LinkedList<Joueur> lljoueur) {
		CartesEnMain cartesEnMain = lljoueur.getFirst().getCartesEnMain();
		CartesfacesVisibles cartefaceVisibles = lljoueur.getFirst()
				.getCartefaceVisibles();
		CartesFacesCachees carteFacesCachees = lljoueur.getFirst()
				.getCarteFacesCachees();
		Joueur j = lljoueur.getFirst();
		HashSet<Carte> hc = new HashSet<Carte>();
		if (!pioche.isEmpty() && cartesEnMain.isEmpty()) {
			j.piocher(pioche);
			return hc;
		}
		if (!cartesEnMain.getCartemain().isEmpty()
				|| !cartefaceVisibles.getCartesVisibles().isEmpty()) {
			System.out.println("oui");
			// System.out.print("Entrez le nombre de carte à jouer :");
			// int nombreDeCarteAjouer = PartieDeCartes.reader.nextInt();
			// System.out
			// .print("Entrez la valeur de la carte a jouer (de 1 a 13) :");
			// int valeur = PartieDeCartes.reader.nextInt();
			try {
				vue.changerDePanel(1);
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("JE CONTINUE");
			if (j.estPossedeDansLamain(valeur, nombreDeCarteAjouer)
					&& j.estCeQueLeJoueurPeutJouerDesCartes(valeur,
							nombreDeCarteAjouer, table)) {
				hc = cartesEnMain.supCarteMain(valeur, nombreDeCarteAjouer);
				table.ajouterCartesTable(hc);
				for (int i = 1; i <= hc.size(); i++) {
					j.piocher(pioche);
				}
				return hc;
			} else if (cartesEnMain.getCartemain().isEmpty()) {
				if (j.estPossedeDansDansLesCartesVisibles(valeur,
						nombreDeCarteAjouer)
						&& j.estCeQueLeJoueurPeutJouerDesCartes(valeur,
								nombreDeCarteAjouer, table)) {
					hc = cartefaceVisibles.supCarteVisible(valeur,
							nombreDeCarteAjouer);
					table.ajouterCartesTable(hc);
					for (int i = 1; i <= hc.size(); i++) {
						j.piocher(pioche);
					}
					return hc;
				} else {
					System.out
							.println("Impossible vous ne pouvez pas poser cette carte !");
					jouerLibrementHumain(table, pioche, derniereCartesPosees,
							lljoueur);
				}

			} else {
				System.out
						.println("impossible vous ne pouvez pas poser cette carte !");
				jouerLibrementHumain(table, pioche, derniereCartesPosees,
						lljoueur);
			}
		}
		if (cartesEnMain.getCartemain().isEmpty()
				&& cartefaceVisibles.getCartesVisibles().isEmpty()) {
			Carte carte;
			carte = carteFacesCachees.prendreAuhasard();
			hc.add(carte);
			if (j.estCeQueLeJoueurPeutJouerDesCartes(carte.getValeur(), 1,
					table)) {
				table.ajouterCartesTable(hc);
			} else {
				hc.clear();
				System.out.println("Je ne peux pas jouer cette carte");
				j.ajouterCartesEnMain(table.ramasserLeTas());
				System.out.println("Vous avez ramassez les cartes de la table "
						+ j.getNom());
			}
			return hc;
		}
		return hc;
	}
}
