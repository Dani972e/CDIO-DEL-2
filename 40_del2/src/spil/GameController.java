package spil;

import desktop_resources.GUI;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class GameController {

	private Player player1;
	private Player player2;

	private Die die1;
	private Die die2;

	private FieldController2 fieldController;
	private TextController textController;

	public GameController() {
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		die1 = new Die(6);
		die2 = new Die(6);
		fieldController = new FieldController2();
		textController = new TextController();

		initGame();
	}

	private void initGame() {
		fieldController.initFields();

		fieldController.addPlayer(player1);
		fieldController.addPlayer(player2);

		GUI.showMessage(textController.welcomeMessage);
		GUI.showMessage(textController.introMessage());

		fieldController.resetPlayers(player1, player2);

		int player1Roll;
		int player2Roll;

		do {
			player1Roll = throwDice(player1);
			player2Roll = throwDice(player2);

			if (player1Roll > player2Roll) {
				GUI.showMessage(textController.startMessage(player1));
				playGame(player1, player2);
			} else if (player2Roll > player1Roll) {
				GUI.showMessage(textController.startMessage(player2));
				playGame(player2, player1);
			}
		} while (player1Roll == player2Roll);

	}

	private void playGame(Player firstPlayer, Player lastPlayer) {
		while (true) {
			playTurn(firstPlayer);

			if (firstPlayer.hasWon() || firstPlayer.hasLost())
				break;

			playTurn(lastPlayer);

			if (lastPlayer.hasWon() || lastPlayer.hasLost())
				break;

			fieldController.resetPlayers(firstPlayer, lastPlayer);
		}

	}

	private int throwDice(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.setDice(roll1, roll2);
		GUI.showMessage(textController.throwDiceResult(player, roll1, roll2));

		return roll1 + roll2;
	}

	private void playTurn(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.showMessage(textController.rollMessage(player));

		player.addCoins(fieldController.getFieldEffect(roll1, roll2));
		fieldController.updatePlayer(player);

		GUI.setDice(roll1, roll2);

		fieldController.placePlayer(player, (roll1 + roll2) - 1);
		GUI.removeCar(12, player.getName());

		GUI.showMessage(textController.showDiceResult(player, roll1, roll2));

		if (roll1 + roll2 == 10) {
			GUI.showMessage(textController.extraTurnMessage(player));
			playTurn(player);
		}
	}

}