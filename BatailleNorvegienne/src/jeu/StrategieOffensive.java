package jeu;
/**
 * La classe Strategie offensive
 * Elle herite de Strategie et represente la tactique offensive  des joueurs  virtuels 
 */
import java.util.LinkedList;

public class StrategieOffensive implements Strategie {

	@Override
	public void algoStrat() {

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

}
