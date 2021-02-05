package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;


public class Dragon extends GamePiece implements Moveable {
	
	
	private int startingLoc;


	public Dragon(char symbol, String name, int location) {
		super(symbol, name, location);
		startingLoc = location;

	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {

		if (super.getLocation() == playerLocation) {
			// dragon steps on you, you go KERPLOP!
			return InteractionResult.KILL;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Generate random number 0 or 1
		Random generator = new Random();
		int direction = generator.nextInt(2);
		int oldLocation = super.getLocation();
		
		// must stay near the hoard
		if (oldLocation - startingLoc > 5) {
			direction = 1;
		}
		else if (startingLoc - oldLocation > 7) {
			direction = 0;
		}
		
		// move the dragon based on direction, checking whether it wants to go out of bounds
		if (oldLocation >= (gameBoard.length - 3) && direction == 0) {
			gameBoard[gameBoard.length - 1] = this;
			super.setLocation(gameBoard.length - 1);
		}
		else if (oldLocation <= 2 && direction == 1) {
			gameBoard[0] = this;
			super.setLocation(0);
		}
		else if (direction == 0) {
			
			// make sure that the Dragon is not landing on the Hoard
			for (int i = oldLocation + 3; i < gameBoard.length; ++i) {
				if (gameBoard[i] == null) {
					gameBoard[i] = this;
					super.setLocation(i);
					break;
				}
				
			}
		}
		else {

			// make sure that the Dragon is not landing on the Hoard
			for (int i = oldLocation - 3; i >= 0; --i) {
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
