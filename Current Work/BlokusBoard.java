/**
 * The BlokusBoard class will be composed of Squares from the square class and hold functions that affect the state of the board.
 */
public class BlokusBoard {
	private Squares[][] grid;
	
	BlokusBoard() {
		grid = new Squares [20][20];
		for(int y = 0; y < 20; y++) {
			for(int x = 0; x < 20; x++) {
				grid[y][x] = new Squares(x, y);
			}
		}
	}
	
	public void reset() {
		for(int y = 0; y < 20; y++) {
			for(int x = 0; x < 20; x++) {
				grid[y][x].setValue(0);
				grid[y][x].setColor(0);
			}
		}
	}
	
	public void placePiece() {
		
	}
	
	public boolean isValidPlacement() {
		return true;
	}
	
	public int getXCorrd() {
		return 0;
	}
	
	public int getYCorrd() {
		return 0;
	}
	
	public Squares getSquareAt(int x, int y){
		return this.grid[y][x];
	}
}
