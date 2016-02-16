package com.ytrail.test;

public class AntBoard {

	public static void main (String[] args) throws InterruptedException {

		Board board = new Board(10,10);
		board.init(25);
		
		Ant blueAnt = new Ant("BLUE");
		Ant greenAnt = new Ant("GREEN");
		Ant blackAnt = new Ant("BLACK");
		
		board.place(blueAnt, 1, 1);
		board.place(greenAnt, 5, 5);
		board.place(blackAnt, 10, 10);
		
		while (true) {
			board.show();
			board.play();
			Thread.sleep(200);
		}
	}
	
}
