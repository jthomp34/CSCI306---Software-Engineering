package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Goblin extends GamePiece implements Moveable {
	
	// switches off moving and not moving
	private boolean shouldMove;

	public Goblin(char symbol, String name, int location) {
		super(symbol, name, location);
		shouldMove = true;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		int oldLocation = super.getLocation();
		
		// if on top of the player, move far away so the player is not killed
		if (oldLocation == playerLocation) {
			for (int i = oldLocation - 3; i < gameBoard.length; ++i) {
				if (gameBoard[i] == null) {
					gameBoard[i] = this;
					super.setLocation(i);
					gameBoard[oldLocation] = null;
					break;
				}
			}
			
		}
		
		// The Goblin moves one space toward the player every other player move skipping over pieces if they are already there
		if (playerLocation < oldLocation && shouldMove == true) {
			// move in the left direction until an empty space
			for (int i = oldLocation - 1; i >= 0; --i) {
				if (gameBoard[i] == null) {
					gameBoard[i] = this;
					gameBoard[oldLocation] = null;
					super.setLocation(i);
					shouldMove = false;
					break;
				}
			}
		}
		else if (shouldMove == true) {
			// move in the left direction until an empty space
			for (int i = oldLocation + 1; i < gameBoard.length; ++i) {
				if (gameBoard[i] == null) {
					gameBoard[i] = this;
					gameBoard[oldLocation] = null;
					super.setLocation(i);
					shouldMove = false;
					break;
				}
			}
		}
		else {
			shouldMove = true;
		}

	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		// calculate distance between player and the current Goblin
		int distance = playerLocation - super.getLocation();
		
		// If player is 2 or 1 or 0 spaces away in either direction, then give player a HIT
		if (distance > -3 && distance < 3) {
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}

}
