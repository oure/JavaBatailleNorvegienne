package jeu;


/**
 * 
 */
public class JoueurIA extends Joueur {

    /**
     * 
     */
    public JoueurIA(String nom) {
    	super(nom);
    }

    /**
     * 
     */
    private int degreeDeStrategie;

    /**
     * @param Carte 
     * @param Integer 
     * @return
     */
    public void jouer(Carte c , int i) {
  	  super.jouer(c, i);    
    }

}
