package spil;

import java.awt.Color;

import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class guiDriver {

	public static void main(String[] args) {

		Field[] fields = new Field[12];

		spil.Field field = new spil.Field(2, Color.RED, Color.BLACK, "Tower", "Dark magical tower of d00m", "just kitten", -250);

		Field[] felter = {
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("2").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("3").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("4").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("5").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("6").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("7").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("8").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("9").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("10").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("11").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("12").setSubText("subtext").setDescription("desc").build()

		};

		GUI.create(felter);

		GUI.addPlayer("Player 1", 1000);
		GUI.addPlayer("Player 2", 1000);

		/* Player 1 throw */
		GUI.showMessage("Player 1 rafle!");
		GUI.setDice(2, 5);

		/* Player 2 throw */
		GUI.showMessage("Player 2 rafle!");
		GUI.setDice(1, 5);

		GUI.showMessage("Player 2 starter TILLYKKE MAN!!");

		GUI.setDice(4, 4);
		GUI.setCar(8, "Player 2");
	}

}
