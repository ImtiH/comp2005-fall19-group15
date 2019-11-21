
public class easyStrategy implements StrategyInterface {

	@Override
	public void makeMove(BlokusGameGUI blokusGame) {
		blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).setPlaying(false);
	}

}
