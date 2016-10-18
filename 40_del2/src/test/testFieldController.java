package test;

import desktop_resources.GUI;
import spil.FieldController;
import spil.Player;
import spil.TextController;

public class testFieldController {

	public static void main(String[] args) {
		Player p1 = new Player("Player1");
		Player p2 = new Player("Player2");
		int[] player1roll = { 0, 0 };
		int[] player2roll = { 0, 0 };

		FieldController.createArea(p1, p2);
		GUI.showMessage(TextController.welcomeMessage);

		// Turn 1

		player1roll[0] = 2;
		player1roll[1] = 6;
		player2roll[0] = 1;
		player2roll[1] = 2;

		FieldController.play(p1, p2, player1roll, player2roll);

		// Turn 2

		player1roll[0] = 6;
		player1roll[1] = 6;
		player2roll[0] = 2;
		player2roll[1] = 3;

		FieldController.play(p1, p2, player1roll, player2roll);

		// Turn 3

		player1roll[0] = 5;
		player1roll[1] = 6;
		player2roll[0] = 3;
		player2roll[1] = 3;

		FieldController.play(p1, p2, player1roll, player2roll);
	}
}