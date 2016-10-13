package spil;

import java.awt.Color;

import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class guiDriver {

	public static void main(String[] args) {

		Field[] felter = {
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("2").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("3").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("4").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("5").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("6").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("7").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("8").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("9").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("10").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("11").setSubText("subtext").setDescription("desc")
						.build(),
				new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle("12").setSubText("subtext").setDescription("desc")
						.build()

		};

		GUI.create(felter);
		
		GUI.addPlayer("Daniel", 1000);
	}

}
