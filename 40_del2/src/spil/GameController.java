package spil;


public class GameController {

	private Player player1;
	private Player player2;
	
	private Die die1;
	private Die die2;
	
	public GameController() {
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		die1 = new Die(6);
		die2 = new Die(6);
		
		FieldController2.initFields();
		
		FieldController2.addPlayer(player1);
		FieldController2.addPlayer(player2);
		
		testGame();
	}
	
	private void play(Player player) {
		int roll1 = die1.roll();
		int roll2 = die2.roll();
		System.out.println(roll1 + " " + roll2);
		GUIController.setDice(roll1, roll2);
		GUIController.showDiceResult(player, roll1, roll2);
		FieldController2.placePlayer(player, (roll1 + roll2) - 1);
	}
	
	public void testGame() {
		play(player1);
	}
	
	public static void main(String[] args) {
		new GameController();
	}
}
