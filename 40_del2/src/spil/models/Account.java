package spil.models;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.1
 */

public class Account {

	/**
	 * Indkapslede klasse variabler, "fields."
	 * 
	 * @param MAX_COIN_AMOUNT    Maksimal værdi af variable coins.
	 * @param DEFAUL_COIN_AMOUNT Startværdien af variable coins.
	 * @param MIN_COIN_AMOUNT    Minimumsværdien af variable coins.
	 * @param coins 		     Antallet af mønter som kontoen har.  
	 */
	private final int MAX_COIN_AMOUNT;
	private final int DEFAULT_COIN_AMOUNT;
	private final int MIN_COIN_AMOUNT;
	private int coins;

	/**
	 * Constructor til Account klassen, som har tre variable inde i parameterlisten.
	 */
	public Account(int maxCoinAmount, int defaultCoinAmount, int minCoinAmount) {
		this.MAX_COIN_AMOUNT = maxCoinAmount;
		this.DEFAULT_COIN_AMOUNT = defaultCoinAmount;
		this.MIN_COIN_AMOUNT = minCoinAmount;
		coins = DEFAULT_COIN_AMOUNT;
	}

	/**
	 * Metode som indsætter amount til variable coins.
	 * 
	 * @param amount Mængden der bliver tilsat variable coins.
	 */
	public void addCoins(int amount) {
		coins += amount;
	}

	/**
	 * Metode der nulstiller variablen coins til DEFAULT_COIN_AMOUNT.
	 */
	public void reset() {
		coins = DEFAULT_COIN_AMOUNT;
	}

	/**
	 * Metode der returnerer en boolean om coins er større eller lig med MAX_COIN_AMOUNT.
	 * 
	 * @return true  Hvis coins er større eller lig med MAX_COIN_AMOUNT.
	 * @return false Hvis coins ikke er større eller lig med MAX_COIN_AMOUNT.
	 */
	public boolean isFull() {
		if (coins >= MAX_COIN_AMOUNT) {
			return true;
		}
		return false;
	}

	/**
	 * Metode der returnerer en boolean om coins er mindre eller lig med MIN_COIN_AMOUNT. 
	 * 
	 * @return true  Hvis coins er mindre eller lig med MIN_COIN_AMOUNT.
	 * @return false Hvis coins ikke er mindre eller lig med MIN_COIN_AMOUNT. 
	 */
	public boolean isEmpty() {
		if (coins <= MIN_COIN_AMOUNT) {
			return true;
		}
		return false;
	}

	/**
	 * En getter metode der returnerer værdien af coins. 
	 *
	 * @return coins Mængden af mønter som kontoen har.
	 */
	public int getCoins() {
		return coins;
	}

}