package jeu;

/**
 * 
 */
public class JoueurHumain extends Joueur {


	/**
     * 
     */
    public JoueurHumain (String nom) {
    	super(nom);
    }

    /**
     * @param Carte 
     * @param Integer 
     * @return
     */
    public void jouer( Carte c , int i) 
    	{
    	  super.jouer(c, i);    
    	} 

}