package testing;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;


/**
 * 
 */

/**
 * @author Yee Teing
 *
 */

public class SquaresTest {
	
	Squares square = new Squares(0,0);
	
	@Test
	public void testGetX() {
		assertEquals("get x", 0, square.getX());
	}
	
	@Test
	public void testGetY() {
		assertEquals("get y", 0, square.getY());
	}
	
	@Test
	public void testGetValue() {
		assertEquals("get value", 0, square.getValue());
	}
	
	@Test
	public void testGetColorNum() {
		assertEquals("get color number", 0, square.getColorNum());
	}
	
	@Test
	public void testGetColor() {
		assertEquals("get color", Color.WHITE, square.getColor());
		square.setColor(1);
		assertEquals("get color", Color.BLUE, square.getColor());
		square.setColor(2);
		assertEquals("get color", Color.YELLOW, square.getColor());
		square.setColor(3);
		assertEquals("get color", Color.RED, square.getColor());
		square.setColor(4);
		assertEquals("get color", new Color(0, 128, 0), square.getColor());
		square.setColor(5);
		assertEquals("get color", new Color(30, 136, 229), square.getColor());
		square.setColor(6);
		assertEquals("get color", new Color(255, 193, 7), square.getColor());
		square.setColor(7);
		assertEquals("get color", new Color(216, 27, 96), square.getColor());
		square.setColor(8);
		assertEquals("get color", new Color(0, 77, 64), square.getColor());
	}
}

