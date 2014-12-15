package jeu;

import java.util.LinkedList;
import java.util.Random;

public class StrategieAleatoire implements Strategie {

	@Override
	public void algoStrat() {
		// TODO Auto-generated method stub
	}

	public int nombreDeHuitQueIaDoitPoser(JoueurIA ia, LinkedList<Joueur> lj) {
		Random rand = new Random();
		int nbDeHuit = ia.nombreDeHuitQueLeJoueurPossede();
		if (nbDeHuit >= 2)
			return rand.nextInt((nbDeHuit - 1) + 1) + 1;
		else 
			return 1;
	}

	@Override
	public Joueur choixDuJoueurCibleePourEnvoyerLetas(JoueurIA j,
			LinkedList<Joueur> lj) {
		int num = j.getNumeroduJoueurDansLaListeDeJoueur(lj, j);
		int numeroDuJoueurDesigne = JoueurIA.randInt(0, lj.size() - 1);
		// Il serait idiot qu'un joueurIA se lance le tas à lui même.
		if (numeroDuJoueurDesigne != num)
			return lj.get(numeroDuJoueurDesigne);
		else
			j.choixDuJoueurCibleePourEnvoyerLetas(lj);
		return null;
	}
}
