/**
 * The BlokusBoard class will be composed of Squares from the square class and hold functions that affect the state of the board.
 */
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.*;

public class BlokusBoard {
	public static final int BOARD_SIZE = 20;
	
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
					this.grid[y + yOff - Piece.SHAPE_SIZE / 2][x + xOff - Piece.SHAPE_SIZE / 2].setColor(p.getColorNum());
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
}
