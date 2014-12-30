package vue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogChoixJoueurEnvoieTas {
	String nomChoisi;

	public DialogChoixJoueurEnvoieTas(String[] nomJoueurs) {
		JFrame frame = new JFrame("Un");
		nomChoisi = (String) JOptionPane.showInputDialog(frame,
				"Choisissez votre victime :\n", "Customized Dialog",
				JOptionPane.PLAIN_MESSAGE, null, nomJoueurs, "ham");
	}
}
