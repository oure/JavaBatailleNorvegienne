package mVCBatailleNorvegienne;

import controleur.BNControleur;
import jeu.PartieDeCartes;
import vue.BNVue;

public class MVCBN {
	public static void main(String[] args) {
		BNVue theView = new BNVue();
		PartieDeCartes theModel = new PartieDeCartes();
		BNControleur theContoleur = new BNControleur(theView, theModel);
		theView.setVisible(true);
		synchronized (theContoleur.verrou) {
			try {
				theContoleur.verrou.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// je bloque en attendant la réponse
		}
		theContoleur.deroulementDujeu();

	}
}