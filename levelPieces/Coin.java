package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Coin extends GamePiece {

	// Constructor sets up a GamePiece
	public Coin(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {

		// Give a point to a player if they land on a coin
		if (super.getLocation() == playerLocation) {
			this.setLocation(100);
			gameBoard[playerLocation] = null;
			return InteractionResult.GET_POINT;
			
		}
		else {
			return InteractionResult.NONE;
		}
	}

}
