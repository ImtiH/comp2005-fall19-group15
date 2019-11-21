import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.Test;

/**
 * @author Yee Teing
 *
 */
public class PieceTest {
	Shapes shape = new Shapes();
	int[][] shapeX=shape.getShape(20);
	Piece piece = new Piece(shapeX, 1);
	

	/**
	 * Test method for {@link Piece#getColor()}.
	 */
	@Test
	public final void testGetColor() {
		//positive Test
		assertEquals("get color", Color.BLUE, piece.getColor());
		//negative test
	}

	/**
	 * Test method for {@link Piece#getColorNum()}.
	 */
	@Test
	public final void testGetColorNum() {
		//positive test
		assertEquals("get colour number", 1, piece.getColorNum());
		//negative test
	//	assertThat("get score fail",piece.getColorNum(),equalTo(10));
			
	}
/**
 * Test method for {@link Piece#getValue(int, int)}.
 */

  @Test public final void testGetValue() { 
	  //positive Test
	  assertEquals("get value", shapeX[6][6], piece.getValue(6,6));
	  //negative test
  }
  
 /**
	 * Test method for {@link Piece#getShape()}.
	 */
  @Test public final void testGetShape() { 
	  //positive Test
	  assertEquals("get shape", shapeX, piece.getShape());
	  //negative test
  }
  }
  
 