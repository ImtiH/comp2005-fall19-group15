package testing;

public class Strategey {
	
	public static final int NONE = 0;
	public static final int EASY = 1;
	public static final int NORMAL = 2;
	public static final int HARD = 3;
	
	public static void getStrategey(int difficulty, BlokusBoard gameBoard, BlokusGameGUI blokusGame) {
		switch(difficulty) {
		case(EASY): easyStrategey(gameBoard, blokusGame);
		case(NORMAL): normalStrategey(gameBoard, blokusGame);
		case(HARD): hardStrategey(gameBoard, blokusGame);
		default: return;
		}
	}
	
	public static void easyStrategey(BlokusBoard gameBoard, BlokusGameGUI blokusGame) {
		for(int y = 0; y < BlokusBoard.BOARD_SIZE; y++) {
			for(int x = 0; x < BlokusBoard.BOARD_SIZE; x++) {
				if(blokusGame.isValidMove(blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getPieces().get(blokusGame.getIndex()), x, y, blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getFirstTurn())) {
					if(blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getFirstTurn()) {
						blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).setFirstTurn(false);
					}
					if(blokusGame.oneSquarePlacedLast(blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getPieces().get(blokusGame.getIndex()))) {
						blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).setSquareOneLast(true);
					}
					gameBoard.placePiece(blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getPieces().get(blokusGame.getIndex()), x, y, blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getFirstTurn());
					blokusGame.drawBoard();
					blokusGame.getGame().getPlayers(blokusGame.getGame().getTurn()).getPieces().remove(blokusGame.getIndex());
					blokusGame.getGame().newTurn();
				}
			}
		}
	}
	
	public static void normalStrategey(BlokusBoard gameBoard, BlokusGameGUI blokusGame) {
		
	}
	
	public static void hardStrategey(BlokusBoard gameBoard, BlokusGameGUI blokusGame) {
		
	}
}
