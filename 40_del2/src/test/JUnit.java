package test;

import spil.models.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @author Peter El-Habr (s165202)
 * @author Loui Southwick (s161788)
 * @version 1.2
 */

public class JUnit {
	
	static Player player1;
	static Player player2;

	@Before
	public void setUp() throws Exception {
		
		player1= new Player("Player 1");
		player2= new Player("Player 2");
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		player1=null;
		player2=null;
	}

	@Test
	public final void testAddCoins() {
		
		int expected = 1500;
		
		player1.addCoins(500);
		
		assertEquals(expected, player1.getCoins());
		
		expected = 500;
		
		player1.addCoins(-1000);
		
		assertEquals(expected, player1.getCoins());
	}
	
	@Test
	public final void testOverflow(){
		int expected = 2147483647;
		
	
		player1.addCoins(-player1.getCoins());
		player1.addCoins(Integer.MAX_VALUE+1);
		
		assertEquals(expected,player1.getCoins());
	}
	
	@Test
	public final void testUnderflow(){
		int expected = -2147483648;
		
		player1.addCoins(-player1.getCoins());
		player1.addCoins(Integer.MIN_VALUE-1);
		
		assertEquals(expected,player1.getCoins());
	}

}