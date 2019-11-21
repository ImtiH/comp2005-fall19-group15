import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLoad {
	
	private static String settingsData = "";
	private static String playerData = "";
	private static String boardStateData = "";
	
	public static void saveSettings(Blokus game) {
		settingsData += game.getNumPlayers();
		settingsData += game.getHumanPlayers();
		settingsData += game.getTurn();
		settingsData += game.isColorBlindMode();
		settingsData += game.isAdvanceScore();
	}
	
	public static void savePlayers(Player players[]) {
		for (int i = 0; i < players.length; ++i) {
			playerData += players[i].getFirstTurn();
			playerData += players[i].getPlaying();
			for (int j = 0; j < players[i].getPieces().size(); ++j) {
				playerData += players[i].getPieces().get(j).getColorNum();
				for (int k = 0; k < Piece.SHAPE_SIZE; ++k) {
					for (int l = 0; l < Piece.SHAPE_SIZE; ++l) {
						playerData += players[i].getPieces().get(j).getValue(l, k);
					}
				}
			}
		}
	}
	
	public static void saveBoardState(BlokusBoard boardState) {
		for(int i = 0; i < BlokusBoard.BOARD_SIZE; ++i) {
			for(int j = 0; j < BlokusBoard.BOARD_SIZE; ++j) {
				boardStateData += boardState.getSquareAt(j, i).getColorNum();
				boardStateData += boardState.getSquareAt(j, i).getValue();
			}
		}
	}
	
	public static void SaveGame() {
		File file = new File("BlokusSave");
		try {
			BufferedWriter bw = new BufferedWriter( new FileWriter(file));
			bw.write(settingsData);
			bw.write(playerData);
			bw.write(boardStateData);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void LoadGame() {
		File file = new File("BlokusSave");
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
