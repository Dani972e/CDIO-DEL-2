package spil;

import desktop_resources.GUI;

public class GameController {

	private Player player1;
	private Player player2;

	private Die die1;
	private Die die2;

	public GameController() {
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		die1 = new Die(6);
		die2 = new Die(6);

		initGame();
		/* Temporary */
		testGame();
	}

	private void initGame() {
		FieldController2.initFields();

		FieldController2.addPlayer(player1);
		FieldController2.addPlayer(player2);

		GUI.showMessage(TextController.welcomeMessage);
		GUI.showMessage(TextController.introMessage());

		FieldController2.placePlayer(player1, 12);
		FieldController2.placePlayer(player2, 12);
	}

	private void play(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.showMessage(TextController.rollMessage(player));
		GUI.setDice(roll1, roll2);
		FieldController2.placePlayer(player, (roll1 + roll2) - 1);
		GUI.showMessage(TextController.showDiceResult(player, roll1, roll2));
	}

	/* Temporary */
	public void testGame() {
		play(player1);
	}

	/* Temporary */
	public static void main(String[] args) {
		new GameController();
	}

}
