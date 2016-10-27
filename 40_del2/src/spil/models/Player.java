package spil.models;

import desktop_resources.GUI;
import spil.boundary.TextBoundary;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.2
 */

public class Player {

	/**
	 * Indkapslede klasse variabler, "fields."
	 * 
	 * @param name          Navnet på spilleren.
	 * @param acc           Spillerens bank konto.
	 * @param textBoundary  textBoundary objekt for klassen.
	 */
	private String name;
	private final Account acc;
	private final TextBoundary textBoundary;

	/**
	 * Constructor for klassen Player med parameter name.
	 *
	 * Constructoren instantiere acc objektet samt textBoundary objektet, og sætter 
	 * den globale variable name til at være lig med name parameteren.
	 */
	public Player(String name) {
		this.name = name;
		acc = new Account(3000, 1000, 0);
		textBoundary = new TextBoundary();
	}

	/**
	 * Wrapper metode for acc objektets isFull() metode.
	 * Hvis spillerens konto er fuld, har spilleren vundet.
	 */
	public boolean hasWon() {
		if (acc.isFull()) {
			GUI.showMessage(textBoundary.winMessage(this));
			return true;
		}
		return false;
	}

	/**
	 * Wrapper metode for acc objektets isEmpty() metode.
	 * Hvis spillerens konto er tom, har spilleren tabt.
	 */
	public boolean hasLost() {
		if (acc.isEmpty()) {
			GUI.showMessage(textBoundary.lossMessage(this));
			return true;
		}
		return false;
	}

	/**
	 * Wrapper metode for acc objektets addCoins() metode.
	 * Ligger amount til kontoens coins værdi.
	 */
	public void addCoins(int amount) {
		acc.addCoins(amount);
	}

	/**
	 * Wrapper metode for acc objektets reset() metode.
	 * Kontoens pengebeholdning bliver nulstillet.
	 */
	public void resetAccount() {
		acc.reset();
	}

	/**
	 * Getter metode for klasse variable name.
	 * 
	 * @return name Spillerens navn.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Wrapper og getter metode for spillerens pengebeholdning.
	 * 
	 * @return acc.getCoins() Spillerens pengebeholdning returneres.
	 */
	public int getCoins() {
		return acc.getCoins();
	}

}