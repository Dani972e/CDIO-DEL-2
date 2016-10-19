package spil;

import desktop_resources.GUI;

public abstract class GUIController {

	public static void setDice(int faceValue1, int faceValue2) {
		GUI.setDice(faceValue1, faceValue2);
	}
	
	public static void showDiceResult(Player player, int faceValue1, int faceValue2) {
		GUI.showMessage(TextController.showDiceResult(player, faceValue1, faceValue2));
	}
	
}
