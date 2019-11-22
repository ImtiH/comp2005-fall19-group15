package testing;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
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
	 * Test method for {@link ComputerPlayer#getScore()}.
	 */
	@Test
	public final void testGetScore() {
		//positive test
		assertEquals("get Score", 0, compPlayer.getScore());
		//negative test
		assertThat("get Score Fail",compPlayer.getScore(),not(equalTo(10)));
	}
	/**
	 * Test method for {@link ComputerPlayer#getFirstTurn()}.
	 */

	@Test
	public final void testGetFirstTurn() {
		//positive test
		assertEquals("get first turn", true, compPlayer.getFirstTurn());
		//negative test
		assertThat("get first turn fail",compPlayer.getFirstTurn(),not(equalTo(false)));
	}

	/**
	 * Test method for {@link ComputerPlayer#getPlaying()}.
	 */
	@Test
	public final void testGetPlaying() {
		//positive test
		assertEquals("get playing", true, compPlayer.getPlaying());
		//negative test
		assertThat("get playing fail",compPlayer.getPlaying(),not(equalTo(false)));
	}
	
	/**
	 * Test method for {@link ComputerPlayer#getTurn()}.
	 */
	@Test
	public final void testGetTurn() {
		//positive test
		assertEquals("get Turn", true, compPlayer.getTurn());
		//negative test
		assertThat("get turn fail",compPlayer.getTurn(),not(equalTo(false)));
	}

}
