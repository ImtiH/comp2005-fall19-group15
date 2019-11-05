/**
 * The Squares class will be the squares which makeup the board and all attributes asocciated with each square in the board.
 */
//TODO Assign colors to numbers.

import java.awt.Color;
import javax.swing.*;

public class Squares extends JPanel {
	private int x, y, value, color;
	
	public Squares(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.value = 0;
		this.color = 0;
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
	
	public int getColor() {
		return this.color;
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
