/**
 * The ComputerPlayer class holds the attributes of computer players and the funcations that the computer player will use to interact with the game.
 */
import java.util.LinkedList;

public class ComputerPlayer implements Player {
	
	public static final int NONE = 0;
	public static final int EASY = 1;
	public static final int NORMAL = 2;
	public static final int HARD = 3;
	
	private LinkedList<Piece> pieces;
	private boolean firstTurn;
	private boolean playing;
	private boolean turn;
	private boolean squareOneLast;
	private int points;
	private int difficulty;
	private BlokusBoard boardState;
	private StrategyInterface strategy;
	
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
	    this.strategy = setStrategy(this.difficulty);
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

	public void move(BlokusGameGUI blokusGame ) {
		strategy.makeMove(blokusGame);
	}
	
	public StrategyInterface setStrategy(int difficulty) {
		switch(difficulty) {
		case(EASY): return new easyStrategy();
		case(NORMAL): return new normalStrategy();
		case(HARD): return new hardStrategy();
		default: return null;
		}
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
	
	public boolean getTurn() {
		return this.turn;
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
}
