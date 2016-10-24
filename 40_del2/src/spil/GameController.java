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

	private GameBoard fieldController;
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
		fieldController = new GameBoard();
		textBoundary = new TextBoundary();

		initGame();
	}

	private void initGame() {
		String playAgain;
		do {
			fieldController.initFields();

			fieldController.addPlayer(player1);
			fieldController.addPlayer(player2);

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
		fieldController.resetPlayers(player1, player2);
		player1.resetAccount();
		player2.resetAccount();
		fieldController.updatePlayer(player1);
		fieldController.updatePlayer(player2);
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
		GUI.showMessage(textBoundary.throwDiceResult(player, roll1, roll2));

		return roll1 + roll2;
	}

	private void playTurn(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.showMessage(textBoundary.rollMessage(player));

		GUI.setDice(roll1, roll2);

		fieldController.placePlayer(player, (roll1 + roll2) - 1);
		GUI.removeCar(12, player.getName());

		GUI.showMessage(textBoundary.showDiceResult(player, roll1, roll2));

		boolean transactionStatus = player.addCoins(fieldController.getFieldEffect(roll1, roll2));

		if (transactionStatus) {
			GUI.showMessage(textBoundary.transactionCompleted() + "\n\n" + player.getAccountStatus());
		} else {
			GUI.showMessage(textBoundary.transactionFailed() + "\n\n" + player.getAccountStatus());
		}

		fieldController.updatePlayer(player);

		/* Double click at loss or win. Fix needed. */
		if ((roll1 + roll2 == 10) && !player.hasLost() && !player.hasWon()) {
			GUI.showMessage(textBoundary.extraTurnMessage(player));
			playTurn(player);
		}
	}

}
