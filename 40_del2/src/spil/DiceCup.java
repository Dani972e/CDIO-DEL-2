package spil;

import desktop_codebehind.Player;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @author Nemanja Mitrovic (s165231)
 * @version 1.0
 */

public class DiceCup {

	/**
	 * Indkapslede klasse variabler, "fields."
	 * Et raflebæger (DiceCup) der indeholder
	 * 2 terninger.
	 *  
	 * @param die1 Terning objekt
	 * @param die2 Terning objekt
	 */
	private Die die1;
	private Die die2;

	/**
	 * Class constructor, som initialisere
	 * klasse objekter. 
	 * 
	 * @param none
	 */
	public DiceCup() {
		die1 = new Die();
		die2 = new Die();
	}

	/**
	 * Metoden shakeOneDice() bruger @param player til at kaste med én terning.
	 * Returnere derefter resultatet af kastet som en int.
	 * 
	 * @param player1 Spiller der kaster
	 * @return roll resultat af kast
	 */
	public int shakeOneDie(spil.Player player1) {
		System.out.println("\n[" + player1.getId() + "] " + player1.getName() + " rolling...");
		int roll = die1.roll();
		System.out.println("[" + player1.getId() + "] " + player1.getName() + " got " + roll + "!");
		return roll;
	}

	/**
	 * Metoden shakeTwoDice() bruger @param player til at kaste med to terninger.
	 * Returnere derefter resultatet af kastet som en int.
	 * 
	 * @param firstPlayer Spiller der kaster
	 * @return roll1 + roll2 resultat af kast
	 */
	public int shakeTwoDice(spil.Player firstPlayer) {
		System.out.println("[" + firstPlayer.getId() + "] " + firstPlayer.getName() + " rolling...");
		int roll1 = die1.roll();
		int roll2 = die2.roll();
		System.out.println("[" + firstPlayer.getId() + "] " + firstPlayer.getName() + " got " + roll1 + ", " + roll2 + "!");
		firstPlayer.addToScore(roll1 + roll2);

		if (roll1 == roll2) {
			System.out.println("Wow, [" + firstPlayer.getId() + "] " + firstPlayer.getName() + " got an extra roll!");
			shakeTwoDice(firstPlayer);
		}
		return roll1 + roll2;
	}

	public int shakeOneDie(Player player1) {
		// TODO Auto-generated method stub
		return 0;
	}

}