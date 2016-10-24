package test;

import spil.Account;

public class TestAccount {

	public static void main(String[] args) {

		Account acc = new Account();

		boolean status = acc.addCoins(-525);
		System.out.println(status);
		System.out.println(acc.getCoins());
		
		status = acc.addCoins(400);
		System.out.println(status);
		System.out.println(acc.getCoins());
		
		status = acc.addCoins(-76);
		System.out.println(status);
		System.out.println(acc.getCoins());
		
		status = acc.addCoins(-523);
		System.out.println(status);
		System.out.println(acc.getCoins());
		
		status = acc.addCoins(50);
		System.out.println(status);
		System.out.println(acc.getCoins());
	
		status = acc.addCoins(-327);
		System.out.println(status);
		System.out.println(acc.getCoins());
		

	}

}
