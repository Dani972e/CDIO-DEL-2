package spil.boundary;

import spil.models.Player;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.1
 */

public class TextBoundary {

	public final String[][] fieldText = { { "1", "Start", "Home, sweet home." }, { "2", "Tower", "You enter the Tower of Hope and find 250 coins." },
			{ "3", "Crater", "You fall into the Goblin Crater. The goblins steal 100 coins from you." },
			{ "4", "Palace Gates", "You enter the King's Palace, and he gives you 100 coins." },
			{ "5", "Cold Desert", "You accidentally drop 20 coins in the desert." },
			{ "6", "Walled City", "It's your lucky day, 180 extra coins magically appear in your pocket." },
			{ "7", "Monastery", "It's time for some praying." }, { "8", "Black Cave", "You got robbed by trolls and lost 70 coins." },
			{ "9", "Huts in the mountain", "You find 60 coins in the hut." },
			{ "10", "The Werewall", "While being chased by a werewolf, you drop 80 coins, but you got an extra turn!" },
			{ "11", "The Pit", "You got knocked unconscious and lost 50 coins." }, { "12", "Gold Mine", "You find a mine full of gold, worth 650 coins." }, };

	public final String gameTitle = "Treasure Hunt";
	public final String welcomeMessage = "Welcome to the game \"" + gameTitle + "\"!\n\n\n\n\n\n";
	public final String roundMessage = "The round is finished!\n\n\n\n";

	public final String buttonMessage = "Do you want to play again?\n\n\n\n\n";
	public final String buttonConfirmMessage = "Yes";
	public final String buttonDeclineMessage = "No";

	public String introMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Two players will face each other and they will start out by rolling two dice.\n\n");
		sb.append("The player that rolls the highest number, will start the first round of the game.\n\n");
		sb.append("Player 1, press OK to roll the dice.\n\n");
		return sb.toString();
	}

	public String rollMessage(Player player, int roll1, int roll2, boolean showFieldText) {
		StringBuilder sb = new StringBuilder();
		sb.append(player.getName() + " rolled " + roll1 + " and " + roll2 + "!\n\n");
		if (showFieldText) {
			sb.append(player.getName() + " lands on " + fieldText[roll1 + roll2 - 1][1] + "!\n\n");
			sb.append("\"" + fieldText[(roll1 + roll2) - 1][2] + "\"");
		}
		return sb.toString();
	}

	public String startMessage(Player player) {
		return "Congratulations, " + player.getName() + " you will start the round!\n\n\n\n";
	}

	public String winMessage(Player player) {
		return "Congratulations, " + player.getName() + " you won!\n\n\n\n\n\n";
	}

	public String lossMessage(Player player) {
		return "Too bad, " + player.getName() + " you lost.\n\n\n\n\n\n";
	}

}