package test;

import java.util.ArrayList;

import desktop_resources.GUI;
import spil.Die;
import spil.GameBoard;
import spil.Player;
import spil.TextBoundary;

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

		for (int i = 0; i < numberOfPlayers; ++i)
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

			for (int i = 0; i < players.size(); ++i)
				fieldController.addPlayer(players.get(i));

			GUI.showMessage(textController.welcomeMessage);
			GUI.showMessage(textController.introMessage());

			int[] rollList = new int[players.size()];

			resetGame();

			do {
				int numberSameValue = 0;

				for (int i = 0; i < rollList.length; ++i)
					rollList[i] = throwDice(players.get(i));

				for (int i = 0; i < rollList.length; ++i) {
					for (int n = 0; i < rollList.length; ++n) {
						if (rollList[i] == rollList[n]) {
							numberSameValue += 1;
						}
					}
				}

				int index = 0;
				int MAX = 0;

				for (int i = 0; i <= rollList.length; ++i) {

					if (rollList[i] > MAX) {
						MAX = rollList[i];
						index = i;
					}
					// players.get(index) is the first player

					Player tempPlayer = players.get(index);

					players.remove(index);

				//TODO	playGame(tempPlayer, players);

				}

				if (numberSameValue == rollList.length)
					return;
				else
					break;

			} while (true);

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

/*	private void playGame(Player firstPlayer, ArrayList<Player> players) {

		while (true) {
			playTurn(firstPlayer);

			if (firstPlayer.hasWon(true) || firstPlayer.hasLost(true))
				break;

			playTurn(lastPlayer);

			if (lastPlayer.hasWon(true) || lastPlayer.hasLost(true))
				break;

			fieldController.resetPlayers(firstPlayer, lastPlayer);

		}

	}*/

	private int throwDice(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.setDice(roll1, roll2);
		//GUI.showMessage(textController.throwDiceResult(player, roll1, roll2));

		return roll1 + roll2;
	}

	private void playTurn(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		//GUI.showMessage(textController.rollMessage(player));

		GUI.setDice(roll1, roll2);

		fieldController.placePlayer(player, (roll1 + roll2) - 1);
		GUI.removeCar(12, player.getName());

		//GUI.showMessage(textController.getDiceResult(player, roll1, roll2));

		fieldController.updatePlayer(player);

		// if (player.hasWon(false) || player.hasLost(false))
			//return;

		if (roll1 + roll2 == 10) {
			GUI.showMessage(textController.extraTurnMessage(player));
			playTurn(player);
		}
	}

}
