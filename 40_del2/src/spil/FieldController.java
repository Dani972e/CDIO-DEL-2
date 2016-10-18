/**
 * @author Peter EL-Habr
 */

package spil;

import java.awt.Color;

import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public abstract class FieldController {

	private static final int DEFAULT_BALANCE=1000;
	
	public static void createArea(Player p1,Player p2){
		Field[] felter = {
				//TODO create Field object from Field class
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("2").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("3").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("4").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("5").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("6").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("7").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("8").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("9").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("10").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("11").setSubText("subtext").setDescription("desc").build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("12").setSubText("subtext").setDescription("desc").build()
		};
		GUI.create(felter);
		FieldController.placePlayer(p1);
		FieldController.placePlayer(p2);
	}
	
	public static void placePlayer(Player player){
		GUI.addPlayer(player.getName(), DEFAULT_BALANCE);
		GUI.setCar(1, player.getName());
	}
	
	public static void play(Player player1, Player player2, int[] player1roll, int[] player2roll){
		move(player1,player1roll[0],player1roll[1]);
		move(player2,player2roll[0],player2roll[1]);
		GUI.showMessage("--- END OF THE TURN ---");
		replacePlayer(player1,player1roll[0],player1roll[1]);
		replacePlayer(player2,player2roll[0],player2roll[1]);
	}
	
	private static void move(Player player,int roll1, int roll2){
		GUI.showMessage(player.getName()+" is rolling...");
		GUI.setDice(roll1, roll2);
		GUI.removeCar(1, player.getName());
		GUI.setCar(roll1+roll2-1, player.getName());
		
		//TODO change balance + or -
		
		GUI.setBalance(player.getName(), player.getBalance());
	}
	
	private static void replacePlayer(Player player, int roll1, int roll2){
		GUI.removeCar(roll1+roll2-1, player.getName());
		GUI.setCar(1, player.getName());
	}
	
}
