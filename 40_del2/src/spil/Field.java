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

	private Color bgColor;
	private Color fgColor;
	private String title;
	private String subText;
	private String desc;
	private int coinChange;

	public Field(Color bgColor, Color fgColor, String title, String subText, String desc, int coinChange) {
		this.bgColor = bgColor;
		this.fgColor = fgColor;
		this.title = title;
		this.subText = subText;
		this.desc = desc;
		this.coinChange = coinChange;
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

	public String getDesc() {
		return desc;
	}

	public int getCoinChange() {
		return coinChange;
	}

}