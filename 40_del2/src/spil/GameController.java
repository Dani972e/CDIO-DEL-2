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

	private GameBoard gameBoard;
	private TextBoundary textBoundary;

	/* Gør det robust her. Brug f.eks et array, eller en ArrayList til at
	 * gøre det mere robust for player og dice. Brug konstruktøren til at gøre dette med
	 * ints f.eks
	 */
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
		String playAgain;
		do {
			gameBoard.initFields();

			gameBoard.addPlayer(player1);
			gameBoard.addPlayer(player2);

			GUI.showMessage(textBoundary.welcomeMessage);
			GUI.showMessage(textBoundary.introMessage());

			int player1Roll;
			int player2Roll;

			resetGame();

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

			// TextBoundary
			playAgain = GUI.getUserButtonPressed("Do you want to play again?", "Yes", "No");

		} while (playAgain.equals("Yes"));

		System.exit(0);
	}

	private void resetGame() {
		gameBoard.resetPlayers(player1, player2);
		player1.resetAccount();
		player2.resetAccount();
		gameBoard.updatePlayer(player1);
		gameBoard.updatePlayer(player2);
	}

	private void playGame(Player firstPlayer, Player lastPlayer) {

		while (true) {
			if (!playTurn(firstPlayer)) {
				break;
			}
			
			if (!playTurn(lastPlayer)) {
				break;
			}

			gameBoard.resetPlayers(firstPlayer, lastPlayer);

		}

	}

	private int throwDice(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.setDice(roll1, roll2);
		GUI.showMessage(textBoundary.throwDiceResult(player, roll1, roll2));

		return roll1 + roll2;
	}

	private boolean playTurn(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.showMessage(textBoundary.rollMessage(player));

		GUI.setDice(roll1, roll2);

		gameBoard.placePlayer(player, (roll1 + roll2) - 1);
		GUI.removeCar(12, player.getName());

		GUI.showMessage(textBoundary.showDiceResult(player, roll1, roll2));

		player.addCoins(gameBoard.getFieldEffect(roll1, roll2));

		gameBoard.updatePlayer(player);

		if (player.hasWon() || player.hasLost())
			return false;

		/* Double click at loss or win. Fix needed. */
		if (roll1 + roll2 == 10) {
			GUI.showMessage(textBoundary.extraTurnMessage(player));
			playTurn(player);
		}
		return true;
	}

}
