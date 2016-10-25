package spil.boundary;

import spil.models.Player;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class TextBoundary {

	public final String[][] fieldText = { { "1", "Start", "Home, sweet home." }, { "2", "Tower", "You enter the Tower of Hope and find 250 coins." },
			{ "3", "Crater", "You fall into the Goblin Crater. The goblins steal 100 coins from you." },
			{ "4", "Palace Gates", "You enter the King's Palace, and he gives you 100 coins." },
			{ "5", "Cold Desert", "You accidentally drop 20 coins in the desert." },
			{ "6", "Walled City", "It's your lucky day, 180 extra coins magically appear in your pocket." },
			{ "7", "Monastery", "It's time for some praying." }, { "8", "Black Cave", "You got robbed by trolls and lost 70 coins." },
			{ "9", "Huts in the mountain", "You find 60 coins in the hut." }, { "10", "The Werewall", "While being chased by a werewolf, you drop 80 coins." },
			{ "11", "The Pit", "You got knocked unconscious and lost 50 coins." }, { "12", "Gold Mine", "You find a mine full of gold, worth 650 coins." }, };

	public final String gameTitle = "Treasure Hunt";
	public final String welcomeMessage = "Welcome to the game, \"" + gameTitle + "\"!\n\n\n\n\n\n";

	public final String buttonMessage = "Do you want to play again?\n\n\n\n\n";
	public final String buttonConfirmMessage = "Yes";
	public final String buttonDeclineMessage = "No";

	public String introMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("In this game, two players will compete against each other.\n\n");
		sb.append("They will start out rolling once each, the player that rolls higher, will start the actual game.\n\n");
		sb.append("Enjoy!\n");
		return sb.toString();
	}

	public String showThrowMessage(Player player, int roll1, int roll2, boolean showFieldText) {
		StringBuilder sb = new StringBuilder();
		sb.append(player.getName() + " rolling!\n\n");
		sb.append(player.getName() + " got " + roll1 + " and " + roll2 + "!\n\n");
		if (showFieldText) {
			sb.append(player.getName() + " lands on " + fieldText[roll1 + roll2 - 1][1] + "!\n\n");
			sb.append("\"" + fieldText[(roll1 + roll2) - 1][2] + "\"");
		}
		return sb.toString();
	}

	public String startMessage(Player player) {
		return "Congratulations, " + player.getName() + " you will start!\n\n\n\n\n\n";
	}

	public String winMessage(Player player) {
		return "Congratulations, " + player.getName() + " you won!\n\n\n\n\n\n";
	}

	public String lossMessage(Player player) {
		return "Too bad, " + player.getName() + " you lost.\n\n\n\n\n\n";
	}

	public String extraTurnMessage(Player player) {
		return player.getName() + " you got an extra turn!\n\n\n\n\n\n";
	}

}