import java.util.LinkedList;

/**
 * inferface for both Human and Computer Players.
 */
public interface Player {
	
	void move();
	
	boolean getFirstTurn();
	
    boolean getPlaying();
    
    boolean isSquareOneLast();
	
	void setFirstTurn(boolean firstTurn);
	
	void setPlaying(boolean p);
	
	void setSquareOneLast(boolean s);
	
	void calculateBasicScore();
	
	void calculateAdvanceScore();
	
	int getScore();
	
	LinkedList<Piece> getPieces();

}
