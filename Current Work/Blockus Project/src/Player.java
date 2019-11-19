import java.util.LinkedList;

/**
 * inferface for both Human and Computer Players.
 */
public interface Player {
	
	void move();
	
	boolean getFirstTurn();
	
	void setFirstTurn(boolean firstTurn);
	
	int getScore();
	
	LinkedList<Piece> getPieces();

}
