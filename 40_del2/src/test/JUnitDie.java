package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.models.Die;

public class JUnitDie {

	private Die die1;
	private Die die2;

	@Before
	public void setUp() throws Exception {
		die1 = new Die(6);
		die2 = new Die(6);
	}

	@After
	public void tearDown() throws Exception {
		die1 = null;
		die2= null;
	}

	@Test
	public void testRoll10() {
		die1.setMaxFaceValue(10);

		int iterations = 1000000;

		int[] rollArray = new int[11];

		for (int i = 0; i < iterations; i++) {
			int roll = die1.roll();

			switch (roll) {
			case 1:
				rollArray[0]++;
				break;
			case 2:
				rollArray[1]++;
				break;
			case 3:
				rollArray[2]++;
				break;
			case 4:
				rollArray[3]++;
				break;
			case 5:
				rollArray[4]++;
				break;
			case 6:
				rollArray[5]++;
				break;
			case 7:
				rollArray[6]++;
				break;
			case 8:
				rollArray[7]++;
				break;
			case 9:
				rollArray[8]++;
				break;
			case 10:
				rollArray[9]++;
				break;
			default:
				rollArray[10]++;
				break;
			}

		}
		System.out.println("-------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println((i + 1) + ": " + rollArray[i]);
		}

		int other = rollArray[10];
		System.out.println("other: " + other);

		int expected = 0;

		assertEquals(expected, other);
	}
	
	//Til 2 Dice med MAX_FACE_VALUE 6
	@Test
	public void testDoubleRoll() {
		
		die1.setMaxFaceValue(6);
		
		die2.setMaxFaceValue(6);
		
		int iterations = 1000000;

		int[] rollArray = new int[11];

		for (int i = 0; i < iterations; i++) {
			int roll = die1.roll()+die2.roll();

			switch (roll) {
			case 2:
				rollArray[0]++;
				break;
			case 3:
				rollArray[1]++;
				break;
			case 4:
				rollArray[2]++;
				break;
			case 5:
				rollArray[3]++;
				break;
			case 6:
				rollArray[4]++;
				break;
			case 7:
				rollArray[5]++;
				break;
			case 8:
				rollArray[6]++;
				break;
			case 9:
				rollArray[7]++;
				break;
			case 10:
				rollArray[8]++;
				break;
			case 11:
				rollArray[9]++;
				break;
			case 12:
				rollArray[10]++;
				break;
			default:
				rollArray[11]++;
				break;
			}

		}
		System.out.println("-------------------");
		
		for (int i = 0; i < 11; i++) {
			System.out.println((i+2) + ": " + rollArray[i]);
		}
		
		int other = 0;
		System.out.println("other: " + other);

		int expected = 0;

		assertEquals(expected, other);
	}

}