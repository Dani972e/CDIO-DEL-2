package test;

import spil.FieldController;
import spil.Player;

public class testFieldController {

	public static void main(String[] args){
		Player p1=new Player("Player1");
		Player p2=new Player("Player2");
		int[]player1roll={2,6};
		int[]player2roll={2,1};
		
		FieldController.createArea(p1,p2);
		
		FieldController.play(p1,p2,player1roll,player2roll);
		
		player1roll[0]=6;player1roll[1]=6;player2roll[0]=2;player2roll[1]=3;
		
		FieldController.play(p1,p2,player1roll,player2roll);
	}
}
