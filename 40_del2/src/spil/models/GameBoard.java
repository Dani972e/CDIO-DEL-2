package spil.models;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;
import spil.boundary.TextBoundary;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.2
 */

public class GameBoard {

	/**
	 * Indkapslet TextBoundary objekt.
	 */
	private final TextBoundary textController = new TextBoundary();

	/**
	 * Indkapslet Fields array, som indeholder alle de 
	 * forskellige værdier til spillets felter. Dette er det
	 * "ikke-grafiske" felter. De holder blot værdierne
	 * for de grafiske felter.
	 */
	private final spil.models.Field[] fields = {
			new spil.models.Field(new Color(0x46B50A), new Color(0xFFFFFF), textController.fieldText[1][0], textController.fieldText[1][1],
					textController.fieldText[1][2], 250),
			new spil.models.Field(new Color(0xBA8F71), new Color(0x000000), textController.fieldText[2][0], textController.fieldText[2][1],
					textController.fieldText[2][2], -100),
			new spil.models.Field(new Color(0xAF0EA7), new Color(0x68DBFF), textController.fieldText[3][0], textController.fieldText[3][1],
					textController.fieldText[3][2], 100),
			new spil.models.Field(new Color(0x89BEFF), new Color(0x000000), textController.fieldText[4][0], textController.fieldText[4][1],
					textController.fieldText[4][2], -20),
			new spil.models.Field(new Color(0xF4E242), new Color(0x1000FF), textController.fieldText[5][0], textController.fieldText[5][1],
					textController.fieldText[5][2], 180),
			new spil.models.Field(new Color(0xFFF6B7), new Color(0x00B5AF), textController.fieldText[6][0], textController.fieldText[6][1],
					textController.fieldText[6][2], 0),
			new spil.models.Field(new Color(0x877E79), new Color(0x820707), textController.fieldText[7][0], textController.fieldText[7][1],
					textController.fieldText[7][2], -70),
			new spil.models.Field(new Color(0xFF9900), new Color(0x155B00), textController.fieldText[8][0], textController.fieldText[8][1],
					textController.fieldText[8][2], 60),
			new spil.models.Field(new Color(0xE2E2E2), new Color(0xE00000), textController.fieldText[9][0], textController.fieldText[9][1],
					textController.fieldText[9][2], -80),
			new spil.models.Field(new Color(0xC61300), new Color(0xFF7575), textController.fieldText[10][0], textController.fieldText[10][1],
					textController.fieldText[10][2], -50),
			new spil.models.Field(new Color(0xFFD700), new Color(0xCC7000), textController.fieldText[11][0], textController.fieldText[11][1],
					textController.fieldText[11][2], 650), };

	/**
	 * Indkapslet Field array fra GUI API'et. Field arrayets 
	 * variabler bliver brugt her. Dette er de grafiske felter.
	 */
	private final Field[] guiFields = {
			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLUE).setTitle(textController.fieldText[0][0])
					.setSubText(textController.fieldText[0][1]).setDescription(textController.fieldText[0][2]).build(),
			new Street.Builder().setBgColor(fields[0].getBgColor()).setFgColor(fields[0].getFgColor()).setTitle(fields[0].getTitle())
					.setSubText(fields[0].getSubText()).setDescription(fields[0].getDescription()).build(),
			new Street.Builder().setBgColor(fields[1].getBgColor()).setFgColor(fields[1].getFgColor()).setTitle(fields[1].getTitle())
					.setSubText(fields[1].getSubText()).setDescription(fields[1].getDescription()).build(),
			new Street.Builder().setBgColor(fields[2].getBgColor()).setFgColor(fields[2].getFgColor()).setTitle(fields[2].getTitle())
					.setSubText(fields[2].getSubText()).setDescription(fields[2].getDescription()).build(),
			new Street.Builder().setBgColor(fields[3].getBgColor()).setFgColor(fields[3].getFgColor()).setTitle(fields[3].getTitle())
					.setSubText(fields[3].getSubText()).setDescription(fields[3].getDescription()).build(),
			new Street.Builder().setBgColor(fields[4].getBgColor()).setFgColor(fields[4].getFgColor()).setTitle(fields[4].getTitle())
					.setSubText(fields[4].getSubText()).setDescription(fields[4].getDescription()).build(),
			new Street.Builder().setBgColor(fields[5].getBgColor()).setFgColor(fields[5].getFgColor()).setTitle(fields[5].getTitle())
					.setSubText(fields[5].getSubText()).setDescription(fields[5].getDescription()).build(),
			new Street.Builder().setBgColor(fields[6].getBgColor()).setFgColor(fields[6].getFgColor()).setTitle(fields[6].getTitle())
					.setSubText(fields[6].getSubText()).setDescription(fields[6].getDescription()).build(),
			new Street.Builder().setBgColor(fields[7].getBgColor()).setFgColor(fields[7].getFgColor()).setTitle(fields[7].getTitle())
					.setSubText(fields[7].getSubText()).setDescription(fields[7].getDescription()).build(),
			new Street.Builder().setBgColor(fields[8].getBgColor()).setFgColor(fields[8].getFgColor()).setTitle(fields[8].getTitle())
					.setSubText(fields[8].getSubText()).setDescription(fields[8].getDescription()).build(),
			new Street.Builder().setBgColor(fields[9].getBgColor()).setFgColor(fields[9].getFgColor()).setTitle(fields[9].getTitle())
					.setSubText(fields[9].getSubText()).setDescription(fields[9].getDescription()).build(),
			new Street.Builder().setBgColor(fields[10].getBgColor()).setFgColor(fields[10].getFgColor()).setTitle(fields[10].getTitle())
					.setSubText(fields[10].getSubText()).setDescription(fields[10].getDescription()).build() };

	/**
	 * Indkapslet Car array.
	 * playerCars arrayet indeholder en række
	 * forskellige bil objekter der kan blive brugt i spillet
	 * til at repræsentere en spiller.
	 */
	private final Car[] playerCars = {
			new Car.Builder().patternDiagonalDualColor().typeRacecar().primaryColor(new Color(0x000000)).secondaryColor(new Color(0xFF0010)).build(),
			new Car.Builder().patternDiagonalDualColor().typeRacecar().primaryColor(new Color(0x0400FF)).secondaryColor(new Color(0xFF00E1)).build(),
			new Car.Builder().patternDiagonalDualColor().typeRacecar().primaryColor(new Color(0xAF4342)).secondaryColor(new Color(0xFF0910)).build(),
			new Car.Builder().patternDiagonalDualColor().typeRacecar().primaryColor(new Color(0xFA4039)).secondaryColor(new Color(0xF023E1)).build(),
			new Car.Builder().patternDiagonalDualColor().typeRacecar().primaryColor(new Color(0xABC423)).secondaryColor(new Color(0xAB0FA0)).build(), };

	/**
	 * Indkapslet boolean array.
	 * Arrayet indeholder information om hvorvidt
	 * en bil i playerCars arrayet er blevet taget af en player,
	 * da begge spillere ikke skal have den samme bil i spillet.
	 */
	private final boolean[] carTaken = { false, false, false, false, false };

	/**
	 * Metode der initialisere de grafiske felter.
	 */
	public void initFields() {
		GUI.create(guiFields);
	}

	/**
	 * Metode der tilføjer en spiller til den grafiske brugergrænseflade.
	 */
	public void addPlayer(Player player) {
		GUI.addPlayer(player.getName(), player.getCoins(), getRandomCar());
	}

	/**
	 * Metode der placerer en bil på et felt.
	 */
	public void placePlayer(Player player, int fieldNum) {
		GUI.setCar(fieldNum, player.getName());
	}

	/**
	 * Metode der placerer spillernes biler
	 * på start feltet, og sletter spillernes biler
	 * fra alle andre felter.
	 */
	public void resetPlayers(Player... playerArray) {
		if (playerArray.length != 0) {
			for (Player p : playerArray) {
				GUI.removeAllCars(p.getName());
				placePlayer(p, 1);
			}
		}
	}

	/**
	 * Metode der returnere mønt-effekten for 
	 * det givne felt på pladsen [roll1 + roll2].
	 * 
	 * @return fields[fieldIndex].getCoinEffect() Mønt-effekten for feltet på fieldIndex.
	 */
	public int getFieldEffect(int roll1, int roll2) {
		int offset = 2;
		int fieldIndex = (roll1 + roll2) - offset;
		return fields[fieldIndex].getCoinEffect();
	}

	/**
	 * Metode som updatere Player objektets pengebeholdning på den grafiske brugergrænseflade.
	 */
	public void updatePlayer(Player player) {
		GUI.setBalance(player.getName(), player.getCoins());
	}

	/**
	 * Metode der returnere en tilfældig bil hvis den ikke allerede er blevet
	 * taget af en anden spiller.
	 */
	private Car getRandomCar() {
		int index = (int) ((Math.random() * playerCars.length));
		if (!carTaken[index]) {
			carTaken[index] = true;
			return playerCars[index];
		}
		return getRandomCar();
	}

}