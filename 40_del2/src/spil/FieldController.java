/**
 * @author Peter EL-Habr
 */

package spil;

import java.awt.Color;

import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;
import test.Player;

public abstract class FieldController {

	public static void createField(Player player1,Player player2){
		Field[] felter = {
				new Street.Builder().setBgColor(Color.GREEN).setFgColor(Color.BLACK).setTitle("2").setSubText("subtext").setDescription("desc").build(),
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
		GUI.addPlayer(player1.name, 3000);
		GUI.addPlayer(player2.name, 3000);
	}
	
	public static void placePlayer(Player player){
		GUI.addPlayer(player.name, 3000);
	}
	
	public static void move(Player player,int roll1, int roll2){
		GUI.showMessage("Player "+player.id+" is rolling...");
		GUI.setDice(roll1, roll2);
		GUI.setCar(roll1+roll2, player.name);
	}
}
