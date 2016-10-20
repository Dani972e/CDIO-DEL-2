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
		playGame();
	}

	private void initGame() {
		FieldController2.initFields();

		FieldController2.addPlayer(player1);
		FieldController2.addPlayer(player2);

		GUI.showMessage(TextController.welcomeMessage);
		GUI.showMessage(TextController.introMessage());

		FieldController2.resetPlayers(player1, player2);
	}

	private void playGame() {
		while (true) {
			playTurn(player1);

			if (player1.hasWon() || player1.hasLost())
				break;

			playTurn(player2);

			if (player2.hasWon() || player2.hasLost())
				break;

			FieldController2.resetPlayers(player1, player2);
		}

	}

	private void playTurn(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.showMessage(TextController.rollMessage(player));

		player.addCoins(FieldController2.getFieldEffect(roll1, roll2));
		FieldController2.updatePlayer(player);

		GUI.setDice(roll1, roll2);

		FieldController2.placePlayer(player, (roll1 + roll2) - 1);
		GUI.removeCar(12, player.getName());

		GUI.showMessage(TextController.showDiceResult(player, roll1, roll2));
	}

}
