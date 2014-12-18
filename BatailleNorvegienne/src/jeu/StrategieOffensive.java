package jeu;

import java.util.Iterator;
/**
 * La classe Strategie offensive
 * Elle herite de Strategie et represente la tactique offensive des joueurs virtuels 
 */
import java.util.LinkedList;

public class StrategieOffensive implements Strategie {

	public int nombreDeHuitQueIaDoitPoser(JoueurIA ia, LinkedList<Joueur> lj) {
		int nbDeHuit = ia.nombreDeHuitQueLeJoueurPossede();
		int positionJoueurIA = ia.getNumeroduJoueurDansLaListeDeJoueur(lj, ia);
		for (int i = 1; i < lj.size(); i++) {
			if ((positionJoueurIA + i) % lj.size() == 1)
				return i;
		}
		return -1;
	}

	@Override
	/**
	 * Cette methode permet au joueur IA d'enoyer le tas sur le joueur qui a le moins de carte
	 * @return  un joueur sur qui le tas sera envoye
	 */
	public Joueur choixDuJoueurCibleePourEnvoyerLetas(JoueurIA j,
			LinkedList<Joueur> lj) {
		return j.quiAleMoinsDeCarte(lj);
	}

	@Override
	public int contrerUnAs(JoueurIA ia) {
		if (!ia.getCartesEnMain().isEmpty())
			if (ia.estPossedeDansLamain(2, 1))
				return 2;
			else
				return 1;
		if (!ia.getCartefaceVisibles().isEmpty()
				&& ia.getCartesEnMain().isEmpty())
			if (ia.estPossedeDansDansLesCartesVisibles(2, 1))
				return 2;
			else
				return 1;
		return -1;
	}

}
