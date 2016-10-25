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
	private final Account acc;
	private final TextBoundary textBoundary;

	public Player(String name) {
		this.name = name;
		acc = new Account(3000, 1000, 0);
		textBoundary = new TextBoundary();
	}

	public boolean hasWon() {
		if (acc.isFull()) {
			GUI.showMessage(textBoundary.winMessage(this));
			return true;
		}
		return false;
	}

	public boolean hasLost() {
		if (acc.isEmpty()) {
			GUI.showMessage(textBoundary.lossMessage(this));
			return true;
		}
		return false;
	}

	public void addCoins(int amount) {
		acc.addCoins(amount);
	}

	public void resetAccount() {
		acc.resetAccount();
	}

	public String getName() {
		return name;
	}

	public int getCoins() {
		return acc.getCoins();
	}

}