package jeu;

import java.util.Set;

public class Joueur {
	private String nom;
	private CartesEnMain cartesEnMain;
	private CartesfacesVisibles cartefaceVisibles;
	private CartesFacesCachees carteFacesCachees;

	public CartesEnMain getCem() {
		return cartesEnMain;
	}

	public void setCem(CartesEnMain cem) {
		this.cartesEnMain = cem;
	}

	public CartesfacesVisibles getCfv() {
		return cartefaceVisibles;
	}

	public void setCfv(CartesfacesVisibles cfv) {
		this.cartefaceVisibles = cfv;
	}

	public CartesFacesCachees getCfc() {
		return carteFacesCachees;
	}

	public void setCfc(CartesFacesCachees cfc) {
		this.carteFacesCachees = cfc;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Joueur(String nom) {
		this.nom = nom;
	}

	public void jouer(Carte c, int i) {
		// TODO Auto-generated method stub
		
	}
    public Boolean envoyerTasSurJoueur(Joueur j, Tas tas) {
        // TODO implement here
        return null;
    }

//	public String toString() {
//		String ss = "";
//		for (Iterator<Carte> iterator = cartesEnMain.iterator(); iterator.hasNext();) {
//			Carte carte = (Carte) iterator.next();
//			ss += carte.getValeur() + " ";
//		}
//		if (ss != "")
//			return "Nom : " + nom + ", Carte(s) : " + ss;
//		else
//			return "Nom : " + " pas de carte";
//	}

	public void recevoirCarte(Set<Carte> s)// les cartes envoyes par un autre joueur 
	{
		cartesEnMain.addAll(s);
	}

    public void piocher(int i,Pioche pioche)
    {
    	while (pioche.isEmpty()==false )
    	{
    		for (int j = 0; j < i; j++) 
    		{
    			//cartesEnMain.addAll(pioche.remove(j));
    		} 
    	}
    
    }
    public void echangerCarte (Carte c1, Carte c2) {
        // TODO implement here
    }
}
