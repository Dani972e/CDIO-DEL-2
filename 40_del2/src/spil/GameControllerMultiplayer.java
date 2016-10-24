package spil;

import java.util.ArrayList;

import desktop_resources.GUI;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class GameControllerMultiplayer {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player player1;
	private Player player2;

	private Die die1;
	private Die die2;

	private GameBoard fieldController;
	private TextBoundary textController;

	public GameControllerMultiplayer(int numberOfPlayers) {
		
		for (int i=0; i<=numberOfPlayers; ++i)
			players.add(new Player("Player " + i));
		
		die1 = new Die(6);
		die2 = new Die(6);
		
		fieldController = new GameBoard();
		textController = new TextBoundary();

		initGame();
	}

	private void initGame() {
		String playAgain;
		do {
			fieldController.initFields();

			fieldController.addPlayer(player1);
			fieldController.addPlayer(player2);

			GUI.showMessage(textController.welcomeMessage);
			GUI.showMessage(textController.introMessage());

			int[] rollList;

			resetGame();

			do {
				for (int i=0; i<=players.size(); ++i)
					rollList[i]=throwDice(players.get(i));
				
				
				int index = 0;
				
				for (int i=0; i<=players.size(); ++i){
				
					if (rollList[i] > rollList[i + 1]) {
					index=i;
					playGame(player1, player2);
					
				} else if (player2Roll > player1Roll) {
					GUI.showMessage(textController.startMessage(player2));
					playGame(player2, player1);
				}
				}
			} while (player1Roll == player2Roll);

			resetGame();

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

			if (firstPlayer.hasWon(true) || firstPlayer.hasLost(true))
				break;

			playTurn(lastPlayer);

			if (lastPlayer.hasWon(true) || lastPlayer.hasLost(true))
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

		GUI.setDice(roll1, roll2);

		fieldController.placePlayer(player, (roll1 + roll2) - 1);
		GUI.removeCar(12, player.getName());

		GUI.showMessage(textController.showDiceResult(player, roll1, roll2));

		boolean transactionStatus = player.addCoins(fieldController.getFieldEffect(roll1, roll2));

		if (transactionStatus) {
			GUI.showMessage(textController.transactionCompleted() + "\n\n" + player.getAccountStatus());
		} else {
			GUI.showMessage(textController.transactionFailed() + "\n\n" + player.getAccountStatus());
		}

		fieldController.updatePlayer(player);

		if (player.hasWon(false) || player.hasLost(false))
			return;

		if (roll1 + roll2 == 10) {
			GUI.showMessage(textController.extraTurnMessage(player));
			playTurn(player);
		}
	}

}
