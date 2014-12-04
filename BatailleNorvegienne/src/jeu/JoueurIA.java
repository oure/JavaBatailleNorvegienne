package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JoueurIA extends Joueur {
	int degreeStrat;
	static private ArrayList<String> collectionNomDeJoueur = new ArrayList<String>(
			Arrays.asList( "Nathan", "Lucas", "Enzo", "Leo", "Louis", "Hugo", "Gabriel",
	 "Ethan", "Mathis", "Jules", "Emma", "Lea", "Chloé", "Manon",
	 "Ines", "Lola", "Jade", "Camille", "Sarah", "Louise"));

	public JoueurIA(int degreeStrat) {
		String nom = null;
		System.out.println(collectionNomDeJoueur.size());
		if (collectionNomDeJoueur.size() > 0) {
			Collections.shuffle(collectionNomDeJoueur);
			nom = collectionNomDeJoueur.get(0);
			collectionNomDeJoueur.remove(0);
		} else {
			System.out.println("Entrez le nom de votre adversaire :");
			nom = PartieDeCartes.reader.nextLine();
		}
		setNom(nom);
		this.degreeStrat = degreeStrat;
	}

	public void jouer(Carte c, int i) {
		super.jouer(c, i);
	}
}
