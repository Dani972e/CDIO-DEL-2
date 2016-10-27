package spil.models;

import java.awt.Color;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.2
 */

public class Field {

	/**
	 * Indkapslede klasse variabler, "fields."
	 * 
	 * @param bgColor     Baggrunds farve for feltet.
	 * @param fgColor     Forgrunds farve for feltet.
	 * @param title       Titel for feltet.
	 * @param subText     Undertekst for feltet.
	 * @param description Beskrivelse af feltet.
	 * @param coinEffect  Mønt-effekten for det givne felt.
	 */
	private final Color bgColor;
	private final Color fgColor;
	private final String title;
	private final String subText;
	private final String description;
	private final int coinEffect;

	/**
	 * Constructor for klassen Field, som har seks forskellige variable i parameterlisten.
	 * 
	 * Den giver start værdier til klasse variablerne fra parameterlisten.
	 */
	public Field(Color bgColor, Color fgColor, String title, String subText, String description, int coinEffect) {
		this.bgColor = bgColor;
		this.fgColor = fgColor;
		this.title = title;
		this.subText = subText;
		this.description = description;
		this.coinEffect = coinEffect;
	}

	/**
	 * Getter metoder for alle klassens variable.
	 */
	public Color getBgColor() {
		return bgColor;
	}

	public Color getFgColor() {
		return fgColor;
	}

	public String getTitle() {
		return title;
	}

	public String getSubText() {
		return subText;
	}

	public String getDescription() {
		return description;
	}

	public int getCoinEffect() {
		return coinEffect;
	}

}