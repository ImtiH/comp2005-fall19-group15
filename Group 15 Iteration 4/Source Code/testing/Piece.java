package testing;
import java.awt.Color;

/**
 * The piece class creates and controls each piece that each player owns.
 */
public class Piece {
	public static final int SHAPE_SIZE = 7;
	public static final int PIECE = 3;
	public static final int ADJACENT = 2;
	public static final int CORNER = 1;
	public static final int BLANK = 0;
	public static final int NONE = 0;
    public static final int BLUE = 1;
    public static final int YELLOW = 2;
    public static final int RED = 3;
	public static final int GREEN = 4;
	public static final int CB_BLUE = 5;
	public static final int CB_YELLOW = 6;
	public static final int CB_RED = 7;
	public static final int CB_GREEN = 8;
	
	private int[][] shape;
	private int color;
	
	//Consturctor
	public Piece(int[][] shape, int color) {
		this.shape = shape;
		this.color = color;
	}
	
	public Color getColor() {
		switch (this.color) 
		{
		     case BLUE: return Color.BLUE;
	         case YELLOW: return Color.YELLOW;
	         case RED: return Color.RED;
	         case GREEN: return new Color(0, 128, 0);
	         case CB_BLUE: return new Color(30, 136, 229);
	         case CB_YELLOW: return new Color(255, 193, 7);
	         case CB_RED: return new Color(216, 27, 96);
	         case CB_GREEN: return new Color(0, 77, 64);
	         default: return Color.LIGHT_GRAY;
	    }
	}
	
	public int getColorNum() {
		return this.color;
	}
	
	public int getValue(int x, int y) {
		return this.shape[y][x];
	}
	
	public int[][] getShape() {
		return this.shape;
	}
	
	public void setColorNum(int num) {
		this.color = num;
	}
	
	public void setValue(int x, int y, int v) {
		this.shape[y][x] = v;
	}
	
	public void rotateClockwise() {
		int[][] temp = new int[SHAPE_SIZE][SHAPE_SIZE];
		
		for (int x = 0; x < SHAPE_SIZE; ++x) {
	         for (int y = 0; y < SHAPE_SIZE; ++y) {
	            temp[SHAPE_SIZE - y - 1][x] = this.shape[x][y];
	         }
		}
		
	    this.shape = temp;
	}
	
    public void rotateCounterClockwise() {
        int[][] temp = new int[SHAPE_SIZE][SHAPE_SIZE];
		
		for (int x = 0; x < SHAPE_SIZE; ++x) {
	         for (int y = 0; y < SHAPE_SIZE; ++y) {
	            temp[y][SHAPE_SIZE - x - 1] = this.shape[x][y];
	         }
		}
		
	    this.shape = temp;
	}
    
    public void flip() {
        int[][] temp = new int[SHAPE_SIZE][SHAPE_SIZE];
		
		for (int x = 0; x < SHAPE_SIZE; ++x) {
	         for (int y = 0; y < SHAPE_SIZE; ++y) {
	            temp[SHAPE_SIZE - x - 1][y] = this.shape[x][y];
	         }
		}
		
	    this.shape = temp;
	}
}
