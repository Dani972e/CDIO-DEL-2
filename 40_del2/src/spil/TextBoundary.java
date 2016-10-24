package spil;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class TextBoundary {

	public String welcomeMessage = "Welcome to the game, \"Treasure Hunt\"!";

	public String introMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("In this game, two players will compete against each other.\n\n");
		sb.append("They will start out rolling once each, the player that rolls higher, will start the actual game.\n\n");
		sb.append("Enjoy!");
		return sb.toString();
	}

	public String[][] fieldText = { { "Start", "Home", "Home, sweet home." }, { "2", "Tower", "You enter the Tower of Hope and find 250 coins." },
			{ "3", "Crater", "You fall into the Goblin Crater. The goblins steal 100 coins from you." },
			{ "4", "Palace Gates", "You enter the King's Palace, and he gives you 100 coins." },
			{ "5", "Cold Desert", "You accidentally drop 20 coins in the desert." },
			{ "6", "Walled City", "It's your lucky day, 180 extra coins magically appear in your pocket." },
			{ "7", "Monastery", "It's time for some praying." }, { "8", "Black Cave", "You got robbed by trolls and lost 70 coins." },
			{ "9", "Huts in the mountain", "You find 60 coins in the hut." }, { "10", "The Werewall", "While being chased by a werewolf, you drop 80 coins." },
			{ "11", "The Pit", "You got knocked unconscious and lost 50 coins." }, { "12", "Goldmine", "You find a mine full of gold, worth 650 coins." }, };

	public String throwDiceResult(Player player, int roll1, int roll2) {
		StringBuilder sb = new StringBuilder();
		sb.append(player.getName() + " got " + roll1 + " and " + roll2 + "!\n\n");
		return sb.toString();
	}

	public String showDiceResult(Player player, int roll1, int roll2) {
		StringBuilder sb = new StringBuilder();
		sb.append(player.getName() + " got " + roll1 + " and " + roll2 + "!\n\n");
		sb.append(player.getName() + " lands on " + fieldText[roll1 + roll2 - 1][1] + "!\n\n");
		sb.append("\"" + fieldText[roll1 + roll2 - 1][2] + "\"");
		return sb.toString();
	}

	public String transactionCompleted() {
		return "Transaction completed successfully!";
	}

	public String transactionFailed() {
		return "Transaction failed!";
	}

	public String rollMessage(Player player) {
		return player.getName() + " rolling next!";
	}

	public String startMessage(Player player) {
		return "Congratulations, " + player.getName() + " you will start!";
	}

	public String winMessage(Player player) {
		return "Congratulations, " + player.getName() + " you won the game of \"Treasure Hunt\"!";
	}

	public String lossMessage(Player player) {
		return "Too bad, " + player.getName() + " you lost the game of \"Treasure Hunt\"!";
	}

	public String extraTurnMessage(Player player) {
		return player.getName() + " you got an extra turn!";
	}

}