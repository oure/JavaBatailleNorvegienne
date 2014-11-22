package jeu;
/**
 * La classe Carte
 */

public class Carte {
	/**
     * les attributs de  la classe Carte
     */
	private int numero;
	private boolean estVisible;

    /**
     * Constructeur de Carte
     */
    public Carte(){
    	setValeur(0);
    }
 
    public Carte(int number){
    	setValeur(number);
    }

	public int getValeur() {
		return numero;
	}

	public void setValeur(int valeur) {
		this.numero = valeur;
	}
	

public boolean isEstVisible() {
	return estVisible;
}

public void setEstVisible(boolean estVisible) {
	this.estVisible = estVisible;
}
 public static void main(String[] args) {
	Carte as= new Carte(1);
	System.out.println("j'ai créer la carte "+as);
}
}


