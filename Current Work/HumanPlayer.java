/**
 * The HumanPlayer class holds the attributes of human players and the funcations that the human player will use to interact with the game.
 */
import java.util.LinkedList;

public class HumanPlayer {
	private LinkedList<Piece> pieces;
	private boolean firstTurn;
	private boolean playing;
	private boolean turn;
	private int points;
	
	public HumanPlayer(int color) {
		Shapes shapes = new Shapes();
		pieces = new LinkedList<Piece>();
	    
	    for (int i = 0; i < 21; i++)
	    {
	       pieces.add(new Piece(shapes.getShape(i), color));
	    }
	    this.firstTurn = true;
	    this.playing = true;
	    this.turn = true;
	}
	
	public void move() {
		//TODO make move function.
	}
	
	public int getScore() {
		//TODO make Score function.
		this.points = 0;
		return points;
	}
	
	public LinkedList<Piece> getPieces() {
		return pieces;
	}
}
