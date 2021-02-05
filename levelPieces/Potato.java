package levelPieces;

import gameEngine.Drawable;

public class Potato implements Drawable {

	@Override
	public void draw() {
		
		// potato is only drawable, not a GamePiece
		System.out.print("@");

	}

}
