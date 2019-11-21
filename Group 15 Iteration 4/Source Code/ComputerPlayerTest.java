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
public class ComputerPlayerTest {
	Shapes shape=new Shapes();
	private BlokusBoard boardState;
	
	ComputerPlayer compPlayer=new ComputerPlayer(2,shape,1,boardState);

	
	/**
	 * Test method for {@link ComputerPlayer#getFirstTurn()}.
	 */

	@Test
	public final void testGetFirstTurn() {
		//positive test
		assertEquals("get first turn", true, compPlayer.getFirstTurn());
		//negative test
		assertThat("get first turn fail",compPlayer.getFirstTurn(),equalTo(false));
	}

	/**
	 * Test method for {@link ComputerPlayer#getPlaying()}.
	 */
	@Test
	public final void testGetPlaying() {
		//positive test
		assertEquals("get playing", true, compPlayer.getPlaying());
		//negative test
		assertThat("get playing fail",compPlayer.getPlaying(),equalTo(false));
	}

	

}
