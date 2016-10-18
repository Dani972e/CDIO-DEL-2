package test;

import spil.FieldController;

public class testFieldController {

	public static void main(String[] args){
		Player p1=new Player("Daniel",1);
		Player p2=new Player("Dani",2);
		FieldController.createField(p1,p2);
		FieldController.move(p1, 1, 5);
		
		FieldController.move(p2, 2, 7);
	}
}
