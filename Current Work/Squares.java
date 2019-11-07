/**
 * The Squares class will be the squares which makeup the board and all attributes asocciated with each square in the board.
 */
//TODO Assign colors to numbers.

import java.awt.Color;
import javax.swing.*;

public class Squares {
	public static final int NONE = 0;
    public static final int BLUE = 1;
    public static final int RED = 2;
    public static final int YELLOW = 3;
	public static final int GREEN = 4;
	private int x, y, value, color;
	
	public Squares(int x, int y) {
		this.x = x;
		this.y = y;
		this.value = NONE;
		this.color = NONE;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Color getColor() {
	      switch (this.color)
	      {
	         case BLUE: return Color.BLUE;
	         case RED: return Color.RED;
	         case YELLOW: return Color.YELLOW;
	         case GREEN: return new Color(0, 128, 0);
	         default: return Color.WHITE;
	      }
	   }
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
}
