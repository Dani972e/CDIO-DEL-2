package spil.models;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.2
 */

public class Die {

	/**
	 * Indkapslede klasse variabler, "fields."
	 * 
	 * @param MAX_FACE_VALUE  Maximumsværdi for faceValue.
	 * @param faceValue       Det er den side terningen lander på efter et kast.   
	 */
	private int maxFaceValue = 6;
	private int faceValue = 1;

	/**
	 * Die klassen kan ikke blive instantieret uden at give
	 * en parameter i constructoren for maxFaceValue.
	 * 
	 * @param maxFaceValue Maximumsværdi for faceValue.
	 */
	public Die(int maxFaceValue) {
		this.maxFaceValue = maxFaceValue;
	}

	/**
	 * Giver faceValue en tilfældig værdi i intervallet [1;maxFaceValue].
	 * Bruger getFaceValue() metoden til at returnere faceValue.
	 * 
	 * @return getFaceValue() Returnere variable faceValue.
	 */
	public int roll() {
		faceValue = (int) (Math.random() * maxFaceValue) + 1;
		return getFaceValue();
	}

	/**
	 * Getter metode for variable faceValue.
	 * Returnere værdien af faceValue variable.
	 * 
	 * Værdien af variablen bliver ikke tjekket, da 
	 * roll() metoden er den eneste vej til at manipulere
	 * værdien af variable faceValue, hvilket kun er i det ønskede
	 * interval, [1;maxFaceValue]
	 * 
	 * @return faceValue Terningens side værdi.
	 */
	public int getFaceValue() {
		return faceValue;
	}

	/**
	 * Setter metode for variable maxFaceValue.
	 * 
	 * Sætter den globle variable maxFaceValue til at være 
	 * lig parameter værdien maxFaceValue.
	 * 
	 * @param maxFaceValue Maximumsværdi for faceValue.
	 */
	public void setMaxFaceValue(int maxFaceValue) {
		this.maxFaceValue = maxFaceValue;
	}

}