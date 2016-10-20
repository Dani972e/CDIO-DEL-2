package spil;

import desktop_resources.GUI;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class Player {

	private String name;
	private final int MAX_COIN_VALUE = 3000;
	private final int MIN_COIN_VALUE = 0;
	private Account acc;
	private TextController textController;

	public Player(String name) {
		this.name = name;
		acc = new Account();
		textController = new TextController();
	}

	public boolean hasWon() {
		if (acc.getCoins() >= MAX_COIN_VALUE) {
			GUI.showMessage(textController.winMessage(this));
			return true;
		}
		return false;
	}

	public boolean hasLost() {
		if (acc.getCoins() <= MIN_COIN_VALUE) {
			GUI.showMessage(textController.lossMessage(this));
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getCoins() {
		return acc.getCoins();
	}

	public void addCoins(int amount) {
		acc.addCoins(amount);
	}

}
