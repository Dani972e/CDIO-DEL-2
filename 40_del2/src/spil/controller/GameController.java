package spil.controller;

import desktop_resources.GUI;
import spil.boundary.TextBoundary;
import spil.models.Die;
import spil.models.GameBoard;
import spil.models.Player;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.1
 */

public class GameController {

	private final Player player1;
	private final Player player2;

	private final Die die1;
	private final Die die2;

	private final GameBoard gameBoard;
	private final TextBoundary textBoundary;

	public GameController() {
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");

		die1 = new Die(6);
		die2 = new Die(6);

		gameBoard = new GameBoard();
		textBoundary = new TextBoundary();

		initGame();
	}

	private void initGame() {
		String userResult;

		gameBoard.initFields();

		gameBoard.addPlayer(player1);
		gameBoard.addPlayer(player2);

		GUI.showMessage(textBoundary.welcomeMessage);
		GUI.showMessage(textBoundary.introMessage());

		resetGame();

		do {
			int player1Roll;
			int player2Roll;

			do {
				player1Roll = throwDice(player1);
				player2Roll = throwDice(player2);

				if (player1Roll > player2Roll) {
					GUI.showMessage(textBoundary.startMessage(player1));
					playGame(player1, player2);
				} else if (player2Roll > player1Roll) {
					GUI.showMessage(textBoundary.startMessage(player2));
					playGame(player2, player1);
				}
			} while (player1Roll == player2Roll);

			resetGame();

			userResult = GUI.getUserButtonPressed(textBoundary.buttonMessage, textBoundary.buttonConfirmMessage, textBoundary.buttonDeclineMessage);

		} while (userResult.equals(textBoundary.buttonConfirmMessage));

		System.exit(0);
	}

	private void playGame(Player firstPlayer, Player lastPlayer) {

		while (true) {
			if (!playTurn(firstPlayer))
				break;

			if (!playTurn(lastPlayer))
				break;

			gameBoard.resetPlayers(firstPlayer, lastPlayer);

			GUI.showMessage(textBoundary.roundMessage);
		}

	}

	private int throwDice(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.setDice(roll1, roll2);
		GUI.showMessage(textBoundary.rollMessage(player, roll1, roll2, false));
		return roll1 + roll2;
	}

	private boolean playTurn(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.setDice(roll1, roll2);

		gameBoard.placePlayer(player, (roll1 + roll2));
		GUI.removeCar(1, player.getName());

		GUI.showMessage(textBoundary.rollMessage(player, roll1, roll2, true));
		player.addCoins(gameBoard.getFieldEffect(roll1, roll2));

		gameBoard.updatePlayer(player);

		if (player.hasWon() || player.hasLost())
			return false;

		if (roll1 + roll2 == 10) {
			GUI.removeCar((roll1 + roll2), player.getName());
			playTurn(player);
		}
		return true;
	}

	private void resetGame() {
		gameBoard.resetPlayers(player1, player2);
		player1.resetAccount();
		player2.resetAccount();
		gameBoard.updatePlayer(player1);
		gameBoard.updatePlayer(player2);
	}

}