package jeu;

import java.util.LinkedList;

public class StrategieOffensive implements Strategie {

	@Override
	public void algoStrat() {

	}

	@Override
	public Joueur choixDuJoueurCibleePourEnvoyerLetas(JoueurIA j,
			LinkedList<Joueur> lj) {
		return j.quiAleMoinsDeCarte(lj);
	}

}
