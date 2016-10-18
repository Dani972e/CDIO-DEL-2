package spil;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class Player {

	private Account acc;
	private String name;

	public Player(String name) {
		this.name = name;
		acc = new Account();
	}

}