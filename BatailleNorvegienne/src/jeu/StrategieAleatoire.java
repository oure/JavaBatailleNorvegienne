package jeu;

import java.util.LinkedList;

public class StrategieAleatoire implements Strategie{

	@Override
	public void algoStrat() {
		// TODO Auto-generated method stub
	}

	@Override
	public Joueur choixDuJoueurCibleePourEnvoyerLetas(JoueurIA j, LinkedList<Joueur> lj) {
		int num = j.getNumeroduJoueurDansLaListeDeJoueur(lj,j);
		int numeroDuJoueurDesigne = JoueurIA.randInt(0, lj.size() - 1);
		// Il serait idiot qu'un joueurIA se lance le tas à lui même.
		if (numeroDuJoueurDesigne != num) 
			return lj.get(numeroDuJoueurDesigne);
		else
			j.choixDuJoueurCibleePourEnvoyerLetas(lj);
		return null;
	}
}
