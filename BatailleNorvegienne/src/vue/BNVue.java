package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jeu.Joueur;

public class BNVue extends JFrame {
	private static final long serialVersionUID = 1L;
	CardLayout cl = new CardLayout();
	JPanel panel = new JPanel();
	JPanel plateauDuJeu;
	JPanel panelCartesCachees;
	JPanel panelCartesVisibles;
	JPanel panelCartesEnMain;
	JPanel panelTas;
	HashSet<JButton> bCartesEnMain = new HashSet<JButton>();
	HashSet<JButton> bCartesVisibles = new HashSet<JButton>();
	HashSet<JButton> bCartesCachees = new HashSet<JButton>();
	private String titre = "Jouer à la bataille norvégienne !";
	private String[] listContent = { titre + " Entrez votre nom :", titre,
			"Vous avez vaincu !" };
	JTextField texteNom = new JTextField(10);
	JTextField texteNbJoueur = new JTextField(2);
	JButton butLauch = new JButton("Lancer la partie !");
	int indice = 0;
	Color vertTapis=new Color(42,114,32);

	public BNVue() {
		this.add(panel);
		this.setTitle("Jouer à la bataille norvégienne !");
		JLabel labelNom = new JLabel("Entrez votre nom :");
		JLabel labelNbJoueur = new JLabel("Nombre de joueurs (entre 2 et 20) :");
		JPanel miseEnPlaceDesJoueurs = new JPanel();
		miseEnPlaceDesJoueurs.setLayout(new GridLayout(3, 2, 5, 5));
		miseEnPlaceDesJoueurs.setBorder(new EmptyBorder(new Insets(10, 10, 10,
				10)));

		panel.add(miseEnPlaceDesJoueurs);
		miseEnPlaceDesJoueurs.add(labelNom);
		miseEnPlaceDesJoueurs.add(texteNom);
		miseEnPlaceDesJoueurs.add(labelNbJoueur);
		miseEnPlaceDesJoueurs.add(texteNbJoueur);
		miseEnPlaceDesJoueurs.add(new JLabel(""));
		miseEnPlaceDesJoueurs.add(butLauch);

		JPanel boutonPane = new JPanel();

		panel.setLayout(cl);
		panel.add(miseEnPlaceDesJoueurs, listContent[0]);
		this.getContentPane().add(boutonPane, BorderLayout.NORTH);
		this.getContentPane().add(panel, BorderLayout.CENTER);

		this.setVisible(true);
		this.setSize(300, 120);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
	}

	public void MiseEnPlaceDuPlateau() {
		plateauDuJeu = new JPanel();
		panelTas = new JPanel();
		panelCartesCachees = new JPanel();
		panelCartesVisibles = new JPanel();
		panelCartesEnMain = new JPanel();

		panelTas.setBackground(vertTapis);
		panelCartesCachees.setBackground(vertTapis);
		plateauDuJeu.setBackground(vertTapis);
		panelCartesVisibles.setBackground(vertTapis);
		panelCartesEnMain.setBackground(vertTapis);
		panelTas.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelCartesVisibles.setBorder(BorderFactory.createEmptyBorder(5, 5, 5,
				5));
		panelCartesCachees.setBorder(BorderFactory
				.createEmptyBorder(5, 5, 5, 5));
		panelCartesEnMain
				.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelCartesEnMain.setLayout(new BoxLayout(panelCartesEnMain,
				BoxLayout.X_AXIS));
		panelCartesVisibles.setLayout(new BoxLayout(panelCartesVisibles,
				BoxLayout.X_AXIS));
		panelCartesCachees.setLayout(new BoxLayout(panelCartesCachees,
				BoxLayout.X_AXIS));

		plateauDuJeu.setLayout(new BoxLayout(plateauDuJeu, BoxLayout.Y_AXIS));

		plateauDuJeu.add(panelTas);
		plateauDuJeu.add(panelCartesCachees);
		plateauDuJeu.add(panelCartesVisibles);
		plateauDuJeu.add(panelCartesEnMain);

		panel.add(plateauDuJeu, listContent[1]);

	}

	public void addBNListener(ActionListener listenForLancerButton) {
		butLauch.addActionListener(listenForLancerButton);
	}

	public void addBoutonCartes(JButton b,
			ActionListener listenerPourBoutonCarte) {
		b.addActionListener(listenerPourBoutonCarte);
	}

	public void changerDePanel(int numPanel) {
		cl.show(panel, listContent[numPanel]);
	}

	public void setTexteNbJoueur(String a) {
		texteNbJoueur.setText(a);
	}

	public void setTexteNom(String b) {
		texteNom.setText(b);
	}

	public int getNombreDeJoueur() {
		if (texteNbJoueur.getText().length() != 0) {
			try {
				@SuppressWarnings("unused")
				int i = Integer.parseInt(texteNbJoueur.getText());
				System.out.println("Valeur OK");
			} catch (Exception e) {
				System.out.println("Ce n'est pas un entier");
				return -1;
			}
			return Integer.parseInt(texteNbJoueur.getText());
		}
		return -1;
	}

	public String getNomDuJoueur() {
		if (!texteNom.getText().equals(""))
			return texteNom.getText();
		else
			return "";
	}
	public void creerUneFenetreDinformation(String g){
		JOptionPane.showMessageDialog(this,
			    g);
	}
	public String choixListeJoueurLancerTas(LinkedList<Joueur> list){
		String[] tableauDeJoueur =new String[list.size()-1];
		int i=0;
	    for (Iterator<Joueur> iterator = list.iterator(); iterator.hasNext();) {
			Joueur joueur = (Joueur) iterator.next();
			if (joueur!=list.getFirst()){
				System.out.println(joueur.getNom());
				tableauDeJoueur[i]=joueur.getNom();
				i++;
			}
		}
	    DialogChoixJoueurEnvoieTas a= new DialogChoixJoueurEnvoieTas(tableauDeJoueur);
	    return a.getnomChoisi();
	}

	public void AfficheCartesVisibles(ArrayList<String> NomFichiers) {
		panelCartesVisibles.removeAll();
		for (Iterator<String> iterator = NomFichiers.iterator(); iterator
				.hasNext();) {
			String string = (String) iterator.next();
			JButton b = getCarteButton(string);
			b.setName(string);
			bCartesVisibles.add(b);
			panelCartesVisibles.add(panelCartesEnMain.add(b));
		}
		this.pack();
	}

	public void AfficheCartesEnMain(ArrayList<String> NomFichiers) {
		panelCartesEnMain.removeAll();
		for (Iterator<String> iterator = NomFichiers.iterator(); iterator
				.hasNext();) {
			String string = (String) iterator.next();
			JButton b = getCarteButton(string);
			b.setName(string);
			bCartesEnMain.add(b);
			panelCartesEnMain.add(b);
		}
		this.pack();
	}

	public void AfficherCartesCachees(ArrayList<String> NomFichiers) {
		panelCartesCachees.removeAll();
		for (Iterator<String> iterator = NomFichiers.iterator(); iterator
				.hasNext();) {
			String string = (String) iterator.next();
			JButton b = getCarteButton("hidden.png");
			b.setName(string);
			bCartesCachees.add(b);
			panelCartesCachees.add(b);
		}
	}

	public void afficherDerniereCarteDeLatable(String nomDeLaCarte, int tour) {
		panelTas.removeAll();
		if (nomDeLaCarte.equals("")) {
			String s;
			if (tour<=1)
				s="<html><font color=\"white\"><center>Pas<br>encore<br>de tas</center></color></html>";
			else
				s="<html><font color=\"white\"><center>Tas<br>Vide</center></color></html>";
			panelTas.add(new JLabel(
					s),
					BorderLayout.CENTER);
			this.pack();
			return;
		}
		panelTas.removeAll();
		panelTas.add(getCarteButton(nomDeLaCarte), BorderLayout.CENTER);
		panel.revalidate();
		panel.repaint();
		pack();
	}

	public JButton getCarteButton(String fileName) {
		JButton button = new JButton();
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setIcon(new ImageIcon(
				"/home/hagard/git/BatailleNorvegienne/images/Cartes/"
						+ fileName));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		return button;
	}

	public BufferedImage getBufferedImageFromImagesFolder(String fileName) {
		BufferedImage myPicture = null;
		try {
			System.out
					.println("/home/hagard/git/BatailleNorvegienne/images/Cartes/"
							+ fileName);
			myPicture = ImageIO.read(new File(
					"/home/hagard/git/BatailleNorvegienne/images/Cartes/"
							+ fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myPicture;
	}

	public HashSet<JButton> getbCartesEnMain() {
		return bCartesEnMain;
	}

	public HashSet<JButton> getbCartesVisibles() {
		return bCartesVisibles;
	}

	public HashSet<JButton> getbCartesCachees() {
		return bCartesCachees;
	}
}