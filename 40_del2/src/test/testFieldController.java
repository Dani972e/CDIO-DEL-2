package test;

import desktop_resources.GUI;
import spil.FieldController;
import spil.Player;
import spil.TextController;

public class testFieldController {
	
	private static int[] createRollList(int...roll){
		return roll;
	}

	public static void main(String[] args) {
		Player p1 = new Player("Player1");
		Player p2 = new Player("Player2");
		int[] player1roll;
		int[] player2roll;

		FieldController.createArea(p1, p2);

		// Turn 1 with combo x2 player 1
		player1roll=createRollList(4,6,1,2);
		player2roll=createRollList(3,3);
		FieldController.play(p1, p2, player1roll, player2roll);

		// Turn 2 without combo
		player1roll=createRollList(3,3);
		player2roll=createRollList(1,5);
		FieldController.play(p1, p2, player1roll, player2roll);

		// Turn 3 with combo x3 player 2
	as	player1roll=createRollList(5,3);
		player2roll=createRollList(5,5,6,4,1,2);
		FieldController.play(p1, p2, player1roll, player2roll);
	}
}