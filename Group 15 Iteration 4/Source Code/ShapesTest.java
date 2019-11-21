import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Yee Teing
 *
 */
public class ShapesTest {
	
	
	Shapes shape=new Shapes();
	int [][] x= shape.getShape(20);
	/**
	 * Test method for {@link Shapes#getShape(int)}.
	 */
	@Test
	public final void testGetShape() {
		//positive test
		assertEquals("get first turn", x, shape.getShape(20));
		//negative test
		assertThat("get first turn fail",shape.getShape(1),equalTo(x));
	
	}

}
