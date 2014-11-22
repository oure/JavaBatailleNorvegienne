package jeu;
import Tas;

import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Ceci est la classe joueur
 */ 
public class Joueur {
   
	/**
     * les attributs
     */
	
	  protected String nom;
	  protected Set<Carte> listeCartesMain= new HashSet<Carte>();
	  protected Set<Carte> listeCartesCachees= new HashSet<Carte>();
	  protected Set<Carte> listeCarteVisibles= new HashSet<Carte>();
	
	  /**
	     * Le constructeur de la classe joueur
	     */
	 
	  public Joueur(String nom)
	  {
		this.nom = nom;
		for (int j=1;j<4;j++)
		{
			listeCartesCachees.add(new Carte(j));
		}
		for (int i=1;i<4;i++)
		{
			listeCarteVisibles.add(new Carte(i));
		}
		for (int k=1;k<4;k++)
		{
			listeCartesMain.add(new Carte(k));
		}
		
	  }

	public void recevoirCarte(Set<Carte> cartedutas)// les cartes envoyées par un autre joueur 
	{
		listeCartesMain.addAll(cartedutas);
	}

	public String toString() {
		String ss = null;
		for (Iterator<Carte> iterator=set.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			ss += carte.getValeur() + " ";
		}
		return "Nom : " + nom + ", Carte(s) : "+ss;
	}
    /**
     * @param int 
     * @param Tas 
     * @return
     */
    
 
    public Boolean envoyerTasSurJoueur(Joueur j, Tas tas) {
        // TODO implement here
        return null;
    }

    /**
     * @param Integer 
     * @param Tas 
     * @return
     */
    public void piocher(int i,List<Carte> pioche)
    {
    	while (pioche.isEmpty()==false )
    	{
    		for (int j = 0; j < i; j++) 
    		{
    			listeCartesMain.add(pioche.remove(j));
    		} 
    	}
    
    }

    /**
     * @param Carte 
     * @param Carte 
     * @return
     */
    public void echangerCarte (Carte c1, Carte c2) {
        // TODO implement here
    }

    /**
     * @param Tas 
     * @return
     */
    public void ramasserTas (Tas tas) {
		listeCartesMain.addAll(tas);
    }

    /**
     * @param c 
     * @param i 
     * @return
     */
    public void jouer(Carte c, int i) 
    {
    	for (int j = 0; j <i; j++) {
			
    	listeCartesMain.remove(c);
    	}
	}


	public Set<Carte> getListeCartesCachees() {
		return listeCartesCachees;
	}

	public void setListeCartesCachees(Set<Carte> listeCartesCachees) {
		this.listeCartesCachees = listeCartesCachees;
	}

	public Set<Carte> getListeCarteVisibles() {
		return listeCarteVisibles;
	}

	public void setListeCarteVisibles(Set<Carte> listeCarteVisibles) {
		this.listeCarteVisibles = listeCarteVisibles;
	}

	public Set<Carte> getListeCartesMain() {
		return listeCartesMain;
	}

	public void setListeCartesMain(Set<Carte> listeCartesMain) {
		this.listeCartesMain = listeCartesMain;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Carte getNumero() {
		return numero;
	}

	public void setNumero(Carte numero) {
		this.numero = numero;
	}

}