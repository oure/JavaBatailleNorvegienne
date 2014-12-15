package jeu;

import java.util.LinkedList;

public class StrategieOffensive implements Strategie {

	@Override
	public void algoStrat() {

	}
	public int nombreDeHuitQueIaDoitPoser(JoueurIA ia,
			LinkedList<Joueur> lj){
		int nbDeHuit=ia.nombreDeHuitQueLeJoueurPossede();
		int positionJoueurIA=ia.getNumeroduJoueurDansLaListeDeJoueur(lj, ia);
		for (int i = 1; i < lj.size(); i++) {
			if((positionJoueurIA+i)%lj.size()==1)
				return i;
		}
		return -1;
	}
	@Override
	public Joueur choixDuJoueurCibleePourEnvoyerLetas(JoueurIA j,
			LinkedList<Joueur> lj) {
		return j.quiAleMoinsDeCarte(lj);
	}

}
