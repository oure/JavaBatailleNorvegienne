package vue;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogChoixJoueurEnvoieTas {
	public DialogChoixJoueurEnvoieTas(){
	    JFrame frame = new JFrame("InputDialog Example #1");

	    // get the user's input. note that if they press Cancel, 'name' will be null
		Object[] possibilities = {"ham", "spam", "yam"};
		Icon icon;
		String s = (String)JOptionPane.showInputDialog(
				frame,
		                    "Complete the sentence:\n"
		                    + "\"Green eggs and...\"",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibilities,
		                    "ham");
	}
	public static void main(String[] args) {
		new DialogChoixJoueurEnvoieTas();
	}
}
