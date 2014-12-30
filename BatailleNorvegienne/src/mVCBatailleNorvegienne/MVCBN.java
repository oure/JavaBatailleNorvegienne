package mVCBatailleNorvegienne;

import controleur.BNControleur;
import jeu.PartieDeCartes;
import vue.BNVue;

public class MVCBN {
	public static void main(String[] args) {
		BNVue theView = new BNVue();
		PartieDeCartes theModel = new PartieDeCartes();
		new BNControleur(theView, theModel);
		theView.setVisible(true);
	}
}
