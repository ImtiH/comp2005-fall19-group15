/**
 * The ComputerPlayer class holds the attributes of computer players and the funcations that the computer player will use to interact with the game.
 */
import java.util.LinkedList;

public class ComputerPlayer implements Player {
	private LinkedList<Piece> pieces;
	private boolean firstTurn;
	private boolean playing;
	private boolean turn;
	private boolean squareOneLast;
	private int points;
	private int difficulty;
	private BlokusBoard boardState;
	
	public ComputerPlayer(int color, Shapes shapes, int difficulty, BlokusBoard boardState) {
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
	
	public ComputerPlayer() {
		this.firstTurn = true;
	    this.playing = true;
	    this.turn = true;
	    this.squareOneLast = false;
	    this.difficulty = 1;
	    this.points = 0;
	    pieces = new LinkedList<Piece>();
	}

	public void move() {
		//TODO make move function.
	}
	
	public int getScore() {
		return points;
	}
	
	public boolean getFirstTurn() {
		return this.firstTurn;
	}
	
	public boolean getPlaying() {
		return this.playing;
	}
	
	public boolean isSquareOneLast() {
		return this.squareOneLast;
	}
	
	public void setPlaying(boolean s) {
		this.playing = s;
	}
	
	public void setFirstTurn(boolean firstTurn) {
		this.firstTurn = firstTurn;
	}
	
	public void setSquareOneLast(boolean s) {
		this.squareOneLast = s;
	}
	
	public void addPiece(int[][] s, int color) {
		this.pieces.add(new Piece(s, color));
	}
	
	public void calculateBasicScore() {
		for(int i = 0; i < this.getPieces().size(); ++i) {
			Piece temp = this.getPieces().get(i);
			for(int j = 0; j < Piece.SHAPE_SIZE; ++j) {
				for(int k = 0; k < Piece.SHAPE_SIZE; ++k) {
					if(temp.getValue(k, j) == Piece.PIECE) {
						++this.points;
					}
				}
			}
		}
	}
	
	public void calculateAdvanceScore() {
		if(this.getPieces().size() == 0) {
			this.points += 15;
			if(isSquareOneLast()) {
				this.points += 5;
			}
		}
		else {
			for(int i = 0; i < this.getPieces().size(); ++i) {
				Piece temp = this.getPieces().get(i);
				for(int j = 0; j < Piece.SHAPE_SIZE; ++j) {
					for(int k = 0; k < Piece.SHAPE_SIZE; ++k) {
						if(temp.getValue(k, j) == Piece.PIECE) {
							--this.points;
						}
					}
				}
			}
		}
	}
	
	public LinkedList<Piece> getPieces() {
		return pieces;
	}
}
