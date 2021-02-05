package levelPieces;

import gameEngine.Drawable;
import java.util.Random;
import gameEngine.InteractionResult;
import gameEngine.Moveable;


public class Knight extends GamePiece implements Moveable {

	// Constructor sets up a GamePiece
	public Knight(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		// no interaction
		return InteractionResult.NONE;

	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Generate random number 0 or 1
		Random generator = new Random();
		int direction = generator.nextInt(2);
		int oldLocation = super.getLocation();
		
		// Base on the random number either move left or right 4 spaces, stopping at gameboard boundaries
		if (oldLocation >= (gameBoard.length - 4) && direction == 0) {
			
			for (int i = gameBoard.length - 1; i >= 0; --i) {
				if (gameBoard[i] == null) {
					gameBoard[i] = this;
					super.setLocation(i);
					break;
				}
			}
			
		}
		else if (oldLocation <= 4 && direction == 1) {
			
			for (int i = 0; i < gameBoard.length; ++i) {
				if (gameBoard[i] == null) {
					gameBoard[i] = this;
					super.setLocation(i);
					break;
				}
			}
		}
		else if (direction == 0) {
			
			for (int i = oldLocation + 4; i >= 0; --i) {
				if (gameBoard[i] == null) {
					gameBoard[i] = this;
					super.setLocation(i);
					break;
				}
			}
		}
		else {
			
			for (int i = oldLocation - 4; i < gameBoard.length; ++i) {
				if (gameBoard[i] == null) {
					gameBoard[i] = this;
					super.setLocation(i);
					break;
				}
			}
		}
		
		if (oldLocation != super.getLocation()) {
			gameBoard[oldLocation] = null;
		}
		
	}
}
