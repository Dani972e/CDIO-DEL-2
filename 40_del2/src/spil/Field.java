package spil;

import java.awt.Color;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.0
 */

public class Field {

	private final Color bgColor;
	private final Color fgColor;
	private final String title;
	private final String subText;
	private final String description;
	private final int coinEffect;

	public Field(Color bgColor, Color fgColor, String title, String subText, String description, int coinEffect) {
		this.bgColor = bgColor;
		this.fgColor = fgColor;
		this.title = title;
		this.subText = subText;
		this.description = description;
		this.coinEffect = coinEffect;
	}

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