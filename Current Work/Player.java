import java.util.LinkedList;

/**
 * inferface for both Human and Computer Players.
 */
public interface Player {
	
	void move();
	
	int getScore();
	
	LinkedList<Piece> getPieces();

}
