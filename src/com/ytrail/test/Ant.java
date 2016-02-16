package com.ytrail.test;

import java.util.Random;

public class Ant {

	private String color;
	public int posX = 0;
	public int posY = 0;
	
	public Ant (String c) {
		color = c;
	}
	
	private int[] getDirection() {
		Random r = new Random();
		int x = 0;
		int y = 0;

		x = (r.nextInt(100) % 2 == 0) ? -1 : 1;
		y = (r.nextInt(100) % 2 == 0) ? -1 : 1;
		
		int[] direction = new int[]{x,y};
		return direction;
	}
	
	public void moveOn (Field fields[][]) {
		int[] direction = getDirection();
		int oldPosX;
		int oldPosY;
		int newPosX;
		int newPosY;
		
		// check field boundaries
		if (posX + direction[0] == 0)
			direction[0] = 1;
		if (posX + direction[0] == 11)
			direction[0] = -1;
		if (posY + direction[1] == 0)
			direction[1] = 1;
		if (posY + direction[1] == 11)
			direction[1] = -1;

		newPosX = posX + direction[0];
		newPosY = posY + direction[1];

		if (fields[newPosX][newPosY].hasAnt) 
			return;
		
		if (fields[newPosX][newPosY].hasWheat) 
			return;

		Random r = new Random();
		boolean x = (r.nextInt(100) % 2 == 0) ? true : false;

		oldPosX = posX;
		oldPosY = posY;

		if (x)
			posX = newPosX;
		else
			posY = newPosY;
								
		switch (color) {
		case "BLUE":
			if (fields[oldPosX][oldPosY].hasWheat) {
				fields[oldPosX][oldPosY].hasWheat = false;
				fields[posX][posY].hasWheat = true;
			}
			fields[oldPosX][oldPosY].hasAnt = false;
			fields[posX][posY].hasAnt = true;
			break;
		case "GREEN":
			break;
		case "BLACK":
			break;
		}
		
	}
	
	public void setPosition (int x, int y) {
		posX = x;
		posY = y;
	}
	
	public String getColorChar () {
		switch (color) {
		case "BLUE":
			return ("B");
		case "GREEN":
			return ("G");
		case "BLACK":
			return ("K");
		}
		return " ";
	}
}
