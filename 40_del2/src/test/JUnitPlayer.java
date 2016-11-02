package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.models.Player;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.2
 */

public class JUnitPlayer {

	private Player player1;

	@Before
	public void setUp() throws Exception {
		player1 = new Player("Player 1");
	}

	@After
	public void tearDown() throws Exception {
		player1 = null;
	}

	@Test // Positive Test
	public void testAddCoins() {
		int expected = 1500;

		player1.addCoins(500);

		assertEquals(expected, player1.getCoins());

		expected = 500;

		player1.addCoins(-1000);

		assertEquals(expected, player1.getCoins());
	}

	@Test // Negative Test
	public void testAddCoinsOverflow() {

		int expected = 2147483647;

		player1.addCoins(-player1.getCoins());
		player1.addCoins(Integer.MAX_VALUE + 1);

		assertEquals(expected, player1.getCoins());
	}

	@Test // Negative Test
	public void testAddCoinsUnderflow() {
		int expected = -2147483648;

		player1.addCoins(-player1.getCoins());
		player1.addCoins(Integer.MIN_VALUE - 1);

		assertEquals(expected, player1.getCoins());
	}

	@Test // Positive Test
	public void testHasLost0() {
		boolean expected = true;

		player1.addCoins(-player1.getCoins());

		assertEquals(expected, player1.hasLost());
	}

	@Test // Positive Test
	public void testHasLostNegative() {
		boolean expected = true;

		player1.addCoins(-10000);

		assertEquals(expected, player1.hasLost());
	}

	@Test // Positive Test
	public void testHasLostFalse() {
		boolean expected = false;

		player1.addCoins(10000);

		assertEquals(expected, player1.hasLost());
	}
	
	@Test // Positive Test
	public void testHasWon0() {
		boolean expected = true;

		player1.addCoins(10000);

		assertEquals(expected, player1.hasWon());
	}

	@Test // Positive Test
	public void testHasWon1() {
		boolean expected = true;

		player1.addCoins(2000);

		assertEquals(expected, player1.hasWon());
	}

	@Test // Positive Test
	public void testHasWon2() {
		boolean expected = false;

		player1.addCoins(1999);

		assertEquals(expected, player1.hasWon());
	}
	
	/*
	 * Test addCoins() in cooperation with resetAccount().
	 */
	@Test // Positive Test
	public void testResetAccount() {
		int add1 = 6824;
		int startAmount = 1000;
		
		player1.addCoins(add1);
		
		int expected = add1 + startAmount;
		int actual = player1.getCoins();
		
		assertEquals(expected, actual);
		
		int add2 = 220;
		player1.addCoins(add2);
		
		expected = add1 + add2 + startAmount;
		actual = player1.getCoins();
		
		assertEquals(expected, actual);
		
		player1.resetAccount();
		
		expected = startAmount;
		actual = player1.getCoins();
		
		assertEquals(expected, actual);
	}
	
}