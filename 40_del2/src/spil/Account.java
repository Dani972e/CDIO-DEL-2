package spil;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class Account {

	private final int MAX_COIN_AMOUNT = 3000;
	private final int DEFAULT_COIN_AMOUNT = 10;
	private final int MIN_COIN_AMOUNT = 0;
	private int coins = DEFAULT_COIN_AMOUNT;

	public void addCoins(int amount) {
		coins += amount;
	}

	public void resetAccount() {
		coins = DEFAULT_COIN_AMOUNT;
	}

	public int getCoins() {
		return coins;
	}

	public boolean isFull() {
		if (coins >= MAX_COIN_AMOUNT) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if (coins <= MIN_COIN_AMOUNT) {
			return true;
		}
		return false;
	}

}