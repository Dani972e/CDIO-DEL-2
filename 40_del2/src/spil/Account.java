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
	private int currentAmount;

	public boolean addCoins(int amount) {
		currentAmount = amount;
		if (coins > 0 && (coins + amount) >= 0) {
			coins += amount;
			return true;
		}
		coins = 0;
		return false;
	}

	public int getCoins() {
		return coins;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<--- Account Status --->\n");
		sb.append("Amount: " + currentAmount + "\n");
		sb.append("Coins:    " + coins + "\n");
		return sb.toString();
	}

}