/**
 * The HumanPlayer class holds the attributes of human players and the funcations that the human player will use to interact with the game.
 */
import java.util.LinkedList;

public class HumanPlayer implements Player {
	private LinkedList<Piece> pieces;
	private boolean firstTurn;
	private boolean playing;
	private boolean turn;
	private boolean squareOneLast;
	private int points;
	
	public HumanPlayer(int color, Shapes shapes) {
		
		this.pieces = new LinkedList<Piece>();
	    
	    for (int i = 0; i < 21; i++)
	    {
	       pieces.add(new Piece(shapes.getShape(i), color));
	    }
	    this.firstTurn = true;
	    this.playing = true;
	    this.squareOneLast = false;
		this.points = 0;
	}
	
	public HumanPlayer() {
		this.firstTurn = true;
	    this.playing = true;
	    this.squareOneLast = false;
		this.points = 0;
		this.pieces = new LinkedList<Piece>();
	}

	public void move(BlokusGameGUI blokusGame) {
		setTurn(true);
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
	
	public boolean getTurn() {
		return this.turn;
	}
	
	public boolean isSquareOneLast() {
		return this.squareOneLast;
	}
	
	public void setTurn(boolean t) {
		this.turn = t;
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
	
	public void setBoardState(BlokusBoard b) {
		
	}
	
	public void loadStrategy(int difficulty) {

	}
}
