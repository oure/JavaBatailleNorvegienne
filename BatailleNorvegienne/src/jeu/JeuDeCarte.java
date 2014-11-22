package jeu;
import java.util.*;

/**       */
public class JeuDeCarte 
 {
    private Set<Carte> listeDesCartesDuJeu;
    
    public JeuDeCarte()
    {
    	for (int i=1;i<=13;i++)
		{for (int j=1;j<=4;j++)
			{
			listeDesCartesDuJeu.add(new Carte(i));
			}
	
		}
    }

    /**@return*/
   /* public void melanger_carte() {
        // TODO implement here
    }*/

    /** @return     */
    /*public void distribuer_le_jeu() {
        // TODO implement here
    }*/
    public static void main(String[] args) {
    	JeuDeCarte listeC= new JeuDeCarte();
    	for(int k=1;k<=52;k++)
    	{
    		System.out.print(listeC.get(k));
    	}
    	
    	}

}
