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
    public static final int RED = 2;
    public static final int YELLOW = 3;
	public static final int GREEN = 4;
	
	private int[][] shape;
	private int color;
	
	//Consturctor
	public Piece(int[][] shape, int color) {
		this.shape = shape;
		this.color = color;
	}
	
	public Color getColor()
	   {
	      switch (this.color)
	      {
	         case BLUE: return Color.BLUE;
	         case RED: return Color.RED;
	         case YELLOW: return Color.YELLOW;
	         case GREEN: return new Color(0, 128, 0);
	         default: return Color.LIGHT_GRAY;
	      }
	   }
	
	public int getColorNum() {
		return this.color;
	}
	
	public int getValue(int x, int y) {
		return this.shape[y][x];
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
