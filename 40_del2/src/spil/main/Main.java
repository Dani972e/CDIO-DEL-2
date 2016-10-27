package spil.main;

import spil.controller.GameController;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.2
 */

public class Main {

	/**
	 * Main metode for programmet.
	 * 
	 * Det første der sker i programmet, er at
	 * det bliver lavet et nyt instans af GameController
	 * klassen. Det betyder så, at constructoren for GameController
	 * bliver kaldt her.
	 */
	public static void main(String[] args) {
		new GameController();
	}

}