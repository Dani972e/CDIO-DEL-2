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
 * @version 1.2
 */

/*
 * GameController er den klasse, der har ansvaret for at spillet
 * fungerer som det skal.
 * GameController har instanser af næsten alle klasser
 * der findes i spillet, og er derved den primære klasse
 * og controller i programmet.
 */
public class GameController {

	/**
	 * Indkapslede klasse variabler, "fields."
	 * 
	 * Der findes to Player objekter i klassen, da 
	 * dette spil er et spil specifikt mellem to spillere, der kaster med
	 * præcis to terninger hver shscds.
	 */
	private final Player player1;
	private final Player player2;

	private final Die die1;
	private final Die die2;

	private final GameBoard gameBoard;
	private final TextBoundary textBoundary;

	/**
	 * Constructor for klassen, GameController.
	 * 
	 * Constructoren for GameController bliver
	 * primært brugt til at instantiere de ovenstående
	 * klasse variable, og derefter initialiseres spillet.
	 */
	public GameController() {
		die1 = new Die(6);
		die2 = new Die(6);

		gameBoard = new GameBoard();
		textBoundary = new TextBoundary();

		player1 = new Player(textBoundary.playerName1);
		player2 = new Player(textBoundary.playerName2);

		initGame();
	}

	/**
	 * initGame() metode, "Initialise Game" er den metode, 
	 * der først bliver kaldt for at starte spillet.
	 * 
	 * Den sørger for, at bruge gameBoard objektet til at 
	 * opsætte felterne og spillerne på den grafiske brugergrænseflade,
	 * og dertil finder ud af hvem der skal starte i den første runde.
	 */
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
			int turnCount = 1;

			do {
				player1Roll = throwDice(player1, turnCount);
				turnCount++;
				player2Roll = throwDice(player2, turnCount);

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

	/**
	 * playGame() metoden er den metode, der sørger for spillets centrale
	 * funktionalitet. Spillerne bliver ved med at kaste terningerne,
	 * indtil en af dem enten har vundet ellet tabt.
	 * 
	 * @param firstPlayer  Den spiller der skal starte runden.
	 * @param lastPlayer   Den spiller der skal slå som nummer to.
	 */
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

	/**
	 * Denne metode sørger for, at kaste med to terninger for player objektet, til den første del af spillet.
	 * Derfor bliver der ikke udskrevet noget angående spillets felter.
	 * 
	 * @param player          Spilleren der kaster med de to terninger.
	 * @param turnCount       Variable der indeholder antallet af kast indtil nu.
	 * @return roll1 + roll2  Resultatet af kastet.
	 */
	private int throwDice(Player player, int turnCount) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();

		GUI.setDice(roll1, roll2);

		if (player.getName().equals(textBoundary.playerName1) && turnCount == 1) {
			GUI.showMessage(textBoundary.rollMessage(player, roll1, roll2, false) + textBoundary.player2InfoMessage);
		} else {
			GUI.showMessage(textBoundary.rollMessage(player, roll1, roll2, false));
		}
		return roll1 + roll2;
	}

	/**
	 * Denne metode sørger for, at kaste med to terninger for player objektet, 
	 * efter den første del af spillet er ovre.
	 * Her bliver der udskrevet hvilket felt spilleren lander på, og dets effekt på 
	 * spilleren.
	 * 
	 * @param player          Spilleren der kaster med de to terninger.
	 * @return                true bliver returneret hvis spilleren ikke har vundet
	 *                        eller tabt, hvis spilleren enten har vundet eller tabt, bliver
	 *                        false returneret.
	 */
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

	/**
	 * resetGame() metoden sørger for at 
	 * nulstille nogle specifikke ting i spillet.
	 * 
	 * Begge af spillernes kontoer bliver nulstillet, samt deres
	 * position på den grafiske brugergrænseflade.
	 */
	private void resetGame() {
		gameBoard.resetPlayers(player1, player2);
		player1.resetAccount();
		player2.resetAccount();
		gameBoard.updatePlayer(player1);
		gameBoard.updatePlayer(player2);
	}

}