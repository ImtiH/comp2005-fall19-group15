package testing;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
/**
 * @author Yee Teing
 *
 */
public class HumanPlayerTest1 {
	Shapes shape=new Shapes();
	HumanPlayer humanPlayer=new HumanPlayer(2,shape);


	/**
	 * Test method for {@link HumanPlayer#getScore()}.
	 */
	
	@Test
	public final void testGetScore() {
		//positive test
		assertEquals("get score", 0, humanPlayer.getScore());
		//negative test
		assertThat("get score fail",humanPlayer.getScore(),not(equalTo(10)));
	}
	/**
	 * Test method for {@link HumanPlayer#getFirstTurn()}.
	 */
	@Test
	public final void testGetFirstTurn() {
		//positive test
		assertEquals("get First Turn", true, humanPlayer.getFirstTurn());
		//negative test
		assertThat("get First Turn fail",humanPlayer.getFirstTurn(),not(equalTo(false)));
	}
	/**
	 * Test method for {@link HumanPlayer#getPlaying()}.
	 */
	
	@Test
	public final void testGetPlaying() {
		//positive test
		assertEquals("get playing", true, humanPlayer.getPlaying());
		//negative test
		assertThat("get playing fail",humanPlayer.getPlaying(),not(equalTo(false)));
	}
	/**
	 * Test method for {@link HumanPlayer#getturn()}.
	 */
	@Test
	public final void testGetTurn() {
		//positive test
		assertEquals("get Turn", false, humanPlayer.getTurn());
		//negative test
		assertThat("get Turn fail",humanPlayer.getTurn(),not(equalTo(true)));
	}
	
	

}
