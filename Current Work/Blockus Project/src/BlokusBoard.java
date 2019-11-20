/**
 * The BlokusBoard class will be composed of Squares from the square class and hold functions that affect the state of the board.
 */
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.*;

public class BlokusBoard {
	public static final int BOARD_SIZE = 20;
    public static final int BLUE = 1;
    public static final int YELLOW = 2;
    public static final int RED = 3;
	public static final int GREEN = 4;
	public static final int CB_BLUE = 5;
	public static final int CB_YELLOW = 6;
	public static final int CB_RED = 7;
	public static final int CB_GREEN = 8;
	
	private Squares[][] grid;
	
	BlokusBoard() {
		grid = new Squares [BOARD_SIZE][BOARD_SIZE];
		for(int y = 0; y < BOARD_SIZE; y++) {
			for(int x = 0; x < BOARD_SIZE; x++) {
				grid[y][x] = new Squares(x, y);
			}
		}
	}
	
	public void reset() {
		for(int y = 0; y < BOARD_SIZE; y++) {
			for(int x = 0; x < BOARD_SIZE; x++) {
				grid[y][x].setValue(0);
				grid[y][x].setColor(0);
			}
		}
	}
	
	public void placePiece(Piece p, int xOff, int yOff, boolean firstMove) {
		
		for(int x = 0; x < Piece.SHAPE_SIZE; x++) {
			for(int y = 0; y < Piece.SHAPE_SIZE; y++) {
				if(p.getValue(x, y) == Piece.PIECE) {
					this.grid[y + yOff][x + xOff].setColor(p.getColorNum());
					this.grid[y + yOff][x + xOff].setValue(Piece.PIECE);
				}
			}
		}
	}
	
	public Point getCoordinates(Point pixel, int res) {
		return new Point(pixel.x / (res / BOARD_SIZE), pixel.y / (res / BOARD_SIZE));
	}
	
	public Squares getSquareAt(int x, int y){
		return this.grid[y][x];
	}
	
	public Point getCorner(int color) {
		switch(color) 
		{
		   case BLUE :
		   case CB_BLUE: return new Point(BOARD_SIZE - 1, 0);
		   case YELLOW:
		   case CB_YELLOW: return new Point(BOARD_SIZE - 1, BOARD_SIZE - 1);
           case GREEN:
           case CB_GREEN: return new Point(0, 0);
           case RED:
           case CB_RED: return new Point(0, BOARD_SIZE - 1);
           default: throw new IllegalArgumentException();
		}
	}
}
