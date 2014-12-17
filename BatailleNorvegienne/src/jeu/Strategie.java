package jeu;
/**
 * La classe Strategie
 *
 */
import java.util.LinkedList;

public interface Strategie {
	public void algoStrat();
	public Joueur choixDuJoueurCibleePourEnvoyerLetas(JoueurIA j, LinkedList<Joueur> lj);
}
