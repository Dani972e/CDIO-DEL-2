package spil;

import java.awt.Color;

import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class FieldController2 {

	private TextController textController = new TextController();

	private final spil.Field[] fields = {
			new spil.Field(new Color(0x46B50A), new Color(0xFFFFFF), textController.fieldText[1][0], textController.fieldText[1][1],
					textController.fieldText[1][2], 250),
			new spil.Field(new Color(0xBA8F71), new Color(0x000000), textController.fieldText[2][0], textController.fieldText[2][1],
					textController.fieldText[2][2], -100),
			new spil.Field(new Color(0xAF0EA7), new Color(0x68DBFF), textController.fieldText[3][0], textController.fieldText[3][1],
					textController.fieldText[3][2], 100),
			new spil.Field(new Color(0x89BEFF), new Color(0x000000), textController.fieldText[4][0], textController.fieldText[4][1],
					textController.fieldText[4][2], -20),
			new spil.Field(new Color(0xF4E242), new Color(0x1000FF), textController.fieldText[5][0], textController.fieldText[5][1],
					textController.fieldText[5][2], 180),
			new spil.Field(new Color(0xFFF6B7), new Color(0x00B5AF), textController.fieldText[6][0], textController.fieldText[6][1],
					textController.fieldText[6][2], 0),
			new spil.Field(new Color(0x877E79), new Color(0x820707), textController.fieldText[7][0], textController.fieldText[7][1],
					textController.fieldText[7][2], -70),
			new spil.Field(new Color(0xFF9900), new Color(0x155B00), textController.fieldText[8][0], textController.fieldText[8][1],
					textController.fieldText[8][2], 60),
			new spil.Field(new Color(0xE2E2E2), new Color(0xE00000), textController.fieldText[9][0], textController.fieldText[9][1],
					textController.fieldText[9][2], -80),
			new spil.Field(new Color(0xC61300), new Color(0xFF7575), textController.fieldText[10][0], textController.fieldText[10][1],
					textController.fieldText[10][2], -50),
			new spil.Field(new Color(0xFFD700), new Color(0xCC7000), textController.fieldText[11][0], textController.fieldText[11][1],
					textController.fieldText[11][2], 650), };

	private final Field[] guiFields = {
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
					.setSubText(fields[10].getSubText()).setDescription(fields[10].getDesc()).build(),
			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLUE).setTitle(textController.fieldText[0][0])
					.setSubText(textController.fieldText[0][1]).setDescription(textController.fieldText[0][2]).build(), };

	public void initFields() {
		GUI.create(guiFields);
	}

	public void addPlayer(Player player) {
		GUI.addPlayer(player.getName(), player.getCoins());
	}

	public void placePlayer(Player player, int fieldNum) {
		GUI.setCar(fieldNum, player.getName());
	}

	public void resetPlayers(Player ... playerArray) {
		if (playerArray.length != 0) {
			for (int i = 0, n = playerArray.length; i < n; i++) {
				GUI.removeAllCars(playerArray[i].getName());
				placePlayer(playerArray[i], 12);
			}
		}
	}

	public int getFieldEffect(int roll1, int roll2) {
		int offset = 2;
		int fieldIndex = (roll1 + roll2) - offset;
		return fields[fieldIndex].getCoinEffect();
	}

	public void updatePlayer(Player player) {
		GUI.setBalance(player.getName(), player.getCoins());
	}

}
