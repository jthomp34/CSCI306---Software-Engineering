package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Hoard extends GamePiece {
	
	public Hoard(char symbol, String name, int location) {
		super(symbol, name, location);
		}
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if (super.getLocation() == playerLocation) {
			// You nabbed the dragon's gold, advance to the next level
			return InteractionResult.ADVANCE;
		}
		else {
			return InteractionResult.NONE;
		}
		
	}
}
