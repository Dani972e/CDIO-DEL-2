package test;

import spil.FieldController;
import spil.Player;

public class testFieldController {

	public static void main(String[] args){
		Player p1=new Player("Player1");
		Player p2=new Player("Player2");
		FieldController.createArea(p1,p2);
		FieldController.move(p1, 1, 5);
		FieldController.move(p2, 1, 1);
	}
}
