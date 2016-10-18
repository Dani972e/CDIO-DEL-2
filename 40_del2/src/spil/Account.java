package spil;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class Account {

	private int coins = 1000;

	public void addCoins(int amount) {
		coins += amount;
	}

	public void removeCoins(int amount) {
		coins -= amount;
	}

	public int getCoins() {
		return coins;
	}

}
