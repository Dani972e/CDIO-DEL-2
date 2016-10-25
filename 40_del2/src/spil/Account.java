package spil;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class Account {

	private final int MAX_COIN_AMOUNT;
	private final int DEFAULT_COIN_AMOUNT;
	private final int MIN_COIN_AMOUNT;
	private int coins;

	public Account(int maxCoinAmount, int defaultCoinAmount, int minCoinAmount) {
		this.MAX_COIN_AMOUNT = maxCoinAmount;
		this.DEFAULT_COIN_AMOUNT = defaultCoinAmount;
		this.MIN_COIN_AMOUNT = minCoinAmount;
		coins = DEFAULT_COIN_AMOUNT;
	}

	public void addCoins(int amount) {
		coins += amount;
	}

	public void resetAccount() {
		coins = DEFAULT_COIN_AMOUNT;
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

	public int getCoins() {
		return coins;
	}

}