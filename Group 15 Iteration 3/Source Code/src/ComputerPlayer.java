/**
 * The ComputerPlayer class holds the attributes of computer players and the funcations that the computer player will use to interact with the game.
 */
import java.util.LinkedList;

public class ComputerPlayer implements Player {
	private LinkedList<Piece> pieces;
	private boolean firstTurn;
	private boolean playing;
	private boolean turn;
	private int points;
	private int difficulty;
	private BlokusBoard boardState;
	
	public ComputerPlayer(int color, int difficulty, BlokusBoard boardState) {
		Shapes shapes = new Shapes();
		pieces = new LinkedList<Piece>();
	    
	    for (int i = 0; i < 21; i++)
	    {
	       pieces.add(new Piece(shapes.getShape(i), color));
	    }
	    this.firstTurn = true;
	    this.playing = true;
	    this.turn = true;
	    this.difficulty = difficulty;
	    this.boardState = boardState;
	}
	
	public void move() {
		//TODO make move function.
	}
	
	public int getScore() {
		//TODO make Score function.
		this.points = 0;
		return points;
	}
	
	public boolean getFirstTurn() {
		return this.firstTurn;
	}
	
	public void setFirstTurn(boolean firstTurn) {
		this.firstTurn = firstTurn;
	}
	
	public LinkedList<Piece> getPieces() {
		return pieces;
	}
}
