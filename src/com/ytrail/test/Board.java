package com.ytrail.test;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Board {

	public int width;
	public int height;

	private Field fields[][] = new Field[11][11];
	List<Ant> ants = new ArrayList<Ant>();
	
	public Board (int w, int h) {
		width = w;
		height = h;
	}

	public void init (int count) {
		int x, y;
		Random rand = new Random();
		
		for (int h = 1; h <= height; h++) {
			for (int w = 1; w <= width; w++) {
				fields[w][h] = new Field();
			}
		}

		for (int c = 1; c <= count; c++) {
			x = rand.nextInt(10) + 1;
			y = rand.nextInt(10) + 1;
			System.out.println(x +","+ y);
			fields[x][y].hasWheat = true;
		}
}
	
	public void place (Ant ant, int x, int y) {
		ant.setPosition(x, y);
		ants.add(ant);
		
		fields[x][y].antIndex = ants.size() - 1;
		fields[x][y].hasAnt = true;
	}

	public void show() {
	    
	    for (int h = 1; h <= height; h++) {
			System.out.print("+");
			for (int w = 1; w <= width; w++) {
				System.out.print("----+");
			}
			System.out.println("");
			System.out.print("|");
			for (int w = 1; w <= width; w++) {
				Field f = fields[w][h];
				String s = " ";

				if (f.hasAnt) {
					Ant ant = ants.get(f.antIndex);
					s = ant.getColorChar();
				}
				s += (f.hasWheat) ? "W":" ";

				System.out.print(" "+ s +" |");
			}
			System.out.println("");
		}

		System.out.print("+");
		for (int w = 1; w <= width; w++) {
			System.out.print("----+");
		}
		System.out.println("");
	}

	public void play () {
		for (int i = 0; i < ants.size(); i++) {
			ants.get(i).moveOn(fields);
		}
	}
}
