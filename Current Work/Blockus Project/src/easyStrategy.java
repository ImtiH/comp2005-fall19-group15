
public class easyStrategy implements StrategyInterface {

	@Override
	public void makeMove(BlokusGameGUI blokusGame) {
		blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).setPlaying(false);
        blokusGame.newTurn();
		/*for(int y = 0; y < BlokusBoard.BOARD_SIZE; y++) {
			for(int x = 0; x < BlokusBoard.BOARD_SIZE; x++) {
				if(blokusGame.isValidMove(blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getPieces().get(blokusGame.getIndex()), x, y, blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getFirstTurn())) {
					if(blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getFirstTurn()) {
						blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).setFirstTurn(false);
					}
					if(blokusGame.oneSquarePlacedLast(blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getPieces().get(blokusGame.getIndex()))) {
						blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).setSquareOneLast(true);
					}
					blokusGame.placePiece(blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getPieces().get(blokusGame.getIndex()), x, y, blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getFirstTurn());
					blokusGame.drawBoard();
					blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getPieces().remove(blokusGame.getIndex());
					blokusGame.getGame().newTurn();
				}
			}
		}
		*/
	}

}
