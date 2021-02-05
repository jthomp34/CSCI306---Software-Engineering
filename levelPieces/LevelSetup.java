package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import java.util.ArrayList;

public class LevelSetup {
	
	Drawable[] board;
	ArrayList<Moveable> movingPieces;
	ArrayList<GamePiece> interactingPieces;
	int startLoc;
	
	public void createLevel(int number) {
		// initialize board, movingPieces and interactingPieces
		
		
		switch (number) {
		case 1:
			board = new Drawable[GameEngine.BOARD_SIZE];
			movingPieces = new ArrayList<Moveable>();
			interactingPieces = new ArrayList<GamePiece>();
			for(int i = 0; i < GameEngine.BOARD_SIZE; ++i) {
				
				if(i == 2 || i == 6) {
					board[i] = new Potato();
				}
				else if (i == 3) {
					Knight knight1 = new Knight('K', "Knight 1", i);
					interactingPieces.add(knight1);
					movingPieces.add(knight1);
					board[i] = knight1;
							}
				else if(i == 10 || i == 4) {
					Coin coin = new Coin('C', "gold", i);
					interactingPieces.add(coin);
					board[i] = coin;
				}
				else if (i == 20) {
					Goblin goblin = new Goblin('G', "Steve", i);
					movingPieces.add(goblin);
					interactingPieces.add(goblin);
					board[i] = goblin;
				}
			}
			

			break;
		
		
		case 2:
			board = new Drawable[GameEngine.BOARD_SIZE];
			movingPieces = new ArrayList<Moveable>();
			interactingPieces = new ArrayList<GamePiece>();
			for(int i = 0; i < GameEngine.BOARD_SIZE; ++i) {
				
				if(i == 2 || i == 19) {
					board[i] = new Potato();
				}
				else if (i == 8) {
					Knight knight2 = new Knight('K', "Knight 1", i);
					interactingPieces.add(knight2);
					movingPieces.add(knight2);
					board[i] = knight2;
							}
				else if (i == 12) {
					Hoard hoard2 = new Hoard('H', "Dragon's Hoard", i);
					interactingPieces.add(hoard2);
					board[i] = hoard2;
					
				}
				else if (i == 11) {
					Dragon dragon2 = new Dragon('D', "Dragelle", i);
					movingPieces.add(dragon2);
					interactingPieces.add(dragon2);
					board[i] = dragon2;
				}
				else if(i == 10 || i == 20) {
					Coin coin = new Coin('C', "gold", i);
					interactingPieces.add(coin);
					board[i] = coin;
				}
				else if (i == 15) {
					Goblin goblin2 = new Goblin('G', "Bob", i);
					movingPieces.add(goblin2);
					interactingPieces.add(goblin2);
					board[i] = goblin2;
				}
			}
			break;
			}
		
		
	}
	
	
	public Drawable[] getBoard() {
		return board;
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}
	
	
	
	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}
	
	public int getPlayerStartLoc() {
		return 0;
	}
}
