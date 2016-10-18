package test;

import java.awt.Color;

import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;
import spil.TextController;

public class guiDriver {

	public static void main(String[] args) {

		spil.Field[] fields = {
				new spil.Field(new Color(0x46B50A), new Color(0xFFFFFF), TextController.field2Text[0], TextController.field2Text[1],
						TextController.field2Text[2], 250),
				new spil.Field(new Color(0xBA8F71), new Color(0x000000), TextController.field3Text[0], TextController.field3Text[1],
						TextController.field3Text[2], -100),
				new spil.Field(new Color(0xAF0EA7), new Color(0x68DBFF), TextController.field4Text[0], TextController.field4Text[1],
						TextController.field4Text[2], 100),
				new spil.Field(new Color(0x89BEFF), new Color(0x000000), TextController.field5Text[0], TextController.field5Text[1],
						TextController.field5Text[2], -20),
				new spil.Field(new Color(0xF4E242), new Color(0x1000FF), TextController.field6Text[0], TextController.field6Text[1],
						TextController.field6Text[2], 180),
				new spil.Field(new Color(0xFFF6B7), new Color(0x00B5AF), TextController.field7Text[0], TextController.field7Text[1],
						TextController.field7Text[2], 0),
				new spil.Field(new Color(0x877E79), new Color(0x820707), TextController.field8Text[0], TextController.field8Text[1],
						TextController.field8Text[2], -70),
				new spil.Field(new Color(0xFF9900), new Color(0x155B00), TextController.field9Text[0], TextController.field9Text[1],
						TextController.field9Text[2], 60),
				new spil.Field(new Color(0xE2E2E2), new Color(0xE00000), TextController.field10Text[0], TextController.field10Text[1],
						TextController.field10Text[2], -80),
				new spil.Field(new Color(0xC61300), new Color(0xFF7575), TextController.field11Text[0], TextController.field11Text[1],
						TextController.field11Text[2], -50),
				new spil.Field(new Color(0xFFD700), new Color(0xCC7000), TextController.field12Text[0], TextController.field12Text[1],
						TextController.field12Text[2], 650), };

		Field[] guiFields = {
				new Street.Builder().setBgColor(fields[0].getBgColor()).setFgColor(fields[0].getFgColor()).setTitle(fields[0].getTitle())
						.setSubText(fields[0].getSubText()).setDescription(fields[0].getDesc()).build(),
				new Street.Builder().setBgColor(fields[1].getBgColor()).setFgColor(fields[1].getFgColor()).setTitle(fields[1].getTitle())
						.setSubText(fields[1].getSubText()).setDescription(fields[1].getDesc()).build(),
				new Street.Builder().setBgColor(fields[2].getBgColor()).setFgColor(fields[2].getFgColor()).setTitle(fields[2].getTitle())
						.setSubText(fields[2].getSubText()).setDescription(fields[2].getDesc()).build(),
				new Street.Builder().setBgColor(fields[3].getBgColor()).setFgColor(fields[3].getFgColor()).setTitle(fields[3].getTitle())
						.setSubText(fields[3].getSubText()).setDescription(fields[3].getDesc()).build(),
				new Street.Builder().setBgColor(fields[4].getBgColor()).setFgColor(fields[4].getFgColor()).setTitle(fields[4].getTitle())
						.setSubText(fields[4].getSubText()).setDescription(fields[4].getDesc()).build(),
				new Street.Builder().setBgColor(fields[5].getBgColor()).setFgColor(fields[5].getFgColor()).setTitle(fields[5].getTitle())
						.setSubText(fields[5].getSubText()).setDescription(fields[5].getDesc()).build(),
				new Street.Builder().setBgColor(fields[6].getBgColor()).setFgColor(fields[6].getFgColor()).setTitle(fields[6].getTitle())
						.setSubText(fields[6].getSubText()).setDescription(fields[6].getDesc()).build(),
				new Street.Builder().setBgColor(fields[7].getBgColor()).setFgColor(fields[7].getFgColor()).setTitle(fields[7].getTitle())
						.setSubText(fields[7].getSubText()).setDescription(fields[7].getDesc()).build(),
				new Street.Builder().setBgColor(fields[8].getBgColor()).setFgColor(fields[8].getFgColor()).setTitle(fields[8].getTitle())
						.setSubText(fields[8].getSubText()).setDescription(fields[8].getDesc()).build(),
				new Street.Builder().setBgColor(fields[9].getBgColor()).setFgColor(fields[9].getFgColor()).setTitle(fields[9].getTitle())
						.setSubText(fields[9].getSubText()).setDescription(fields[9].getDesc()).build(),
				new Street.Builder().setBgColor(fields[10].getBgColor()).setFgColor(fields[10].getFgColor()).setTitle(fields[10].getTitle())
						.setSubText(fields[10].getSubText()).setDescription(fields[10].getDesc()).build(), };

		GUI.create(guiFields);

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
