package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.models.GameBoard;

public class JUnitGameBoard {

	private GameBoard gameBoard;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
	}

	@After
	public void tearDown() throws Exception {
		gameBoard = null;
	}

	@Test // Positive Test
	public void testGetFieldEffect0() {
		int roll1 = 1;
		int roll2 = 1;
		
		int expected = 250; // Tower of Hope
		
		int actual = gameBoard.getFieldEffect(roll1, roll2);
		
		assertEquals(expected, actual);
	}
	
	@Test // Positive Test
	public void testGetFieldEffect1() {
		int roll1 = 5;
		int roll2 = 4;
		
		int expected = 60; // Huts in the Mountain
		
		int actual = gameBoard.getFieldEffect(roll1, roll2);
		
		assertEquals(expected, actual);
	}
	
	@Test // Positive Test
	public void testGetFieldEffect2() {
		int roll1 = 6;
		int roll2 = 6;
		
		int expected = 650; // Gold Mine
		
		int actual = gameBoard.getFieldEffect(roll1, roll2);
		
		assertEquals(expected, actual);
	}
	
	@Test // Positive Test
	public void testGetFieldEffect3() {
		int roll1 = 5;
		int roll2 = 5;
		
		int expected = -80; // Werewall
		
		int actual = gameBoard.getFieldEffect(roll1, roll2);
		
		assertEquals(expected, actual);
	}
	
	@Test // Negative Test
	public void testGetFieldEffect4() {
		int roll1 = 23;
		int roll2 = 543;
		
		int expected = 0;
		
		int actual = gameBoard.getFieldEffect(roll1, roll2);
		
		assertEquals(expected, actual);
	}
	
	@Test // Negative Test 
	public void testGetFieldEffect5() {
		int roll1 = Integer.MAX_VALUE;
		int roll2 = Integer.MAX_VALUE;
		
		int expected = 0;
		
		int actual = gameBoard.getFieldEffect(roll1, roll2);
		
		assertEquals(expected, actual);
	}
	
	@Test // Negative Test 
	public void testGetFieldEffect6() {
		int roll1 = Integer.MIN_VALUE;
		int roll2 = Integer.MIN_VALUE;
		
		int expected = 0;
		
		int actual = gameBoard.getFieldEffect(roll1, roll2);
		
		assertEquals(expected, actual);
	}
	
	@Test // Negative Test 
	public void testGetFieldEffect7() {
		int roll1 = Integer.MIN_VALUE;
		int roll2 = Integer.MAX_VALUE;
		
		int expected = 0;
		
		int actual = gameBoard.getFieldEffect(roll1, roll2);
		
		assertEquals(expected, actual);
	}

}
