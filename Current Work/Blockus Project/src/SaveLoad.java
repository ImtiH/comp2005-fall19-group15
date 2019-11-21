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
	private static int[][] shape;
	
	public static void saveSettings(Blokus game) {
		settingsData += game.getNumPlayers();
		settingsData += game.getHumanPlayers();
		settingsData += game.getDifficulty();
		settingsData += game.getBlokusGame().getIndex();
		settingsData += game.getTurn() + "\n";
		settingsData += game.isColorBlindMode() + "\n";
		settingsData += game.isAdvanceScore() + "\n";
	}
	
	public static void savePlayers(Player players[]) {
		playerData += players.length + "\n";
		for (int i = 0; i < players.length; ++i) {
			playerData += players[i].getFirstTurn() + "\n";
			playerData += players[i].getPlaying() + "\n";
			playerData += players[i].getPieces().size() + "\n";
			for (int j = 0; j < players[i].getPieces().size(); ++j) {
				playerData += players[i].getPieces().get(j).getColorNum();
				for (int k = 0; k < Piece.SHAPE_SIZE; ++k) {
					for (int l = 0; l < Piece.SHAPE_SIZE; ++l) {
						playerData += players[i].getPieces().get(j).getValue(l, k);
					}
				}
			}
			playerData += "\n";
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
	
	public static void LoadGame(Blokus game) throws IOException {
		File file = new File("BlokusSave");
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				int index1;
				int index2;
				int index3;
				int index4;
				line = br.readLine();
				game.setNumPlayers(line.charAt(0) - '0');
				//System.out.println(game.getNumPlayers());
				game.setHumanPlayers(line.charAt(1) - '0');
				//System.out.println(game.getHumanPlayers());
				game.setDifficulty((line.charAt(2) - '0'));
				//System.out.println(game.getDifficulty());
				game.getBlokusGame().setIndex(line.charAt(3) - '0');
				//System.out.println(game.getBlokusGame().getIndex());
				game.SetTurn(line.charAt(4) - '0');
				//System.out.println(game.getTurn());
				line = br.readLine();
				game.setColorBlindMode(Boolean.parseBoolean(line));
				//System.out.println(game.getColorBlindMode());
				line = br.readLine();
				game.setAdvanceScoreMode(Boolean.parseBoolean(line));
				//System.out.println(game.getAdvanceScoreMode());
				line = br.readLine();
				index1 =  line.charAt(0) - '0';
				game.setPlayers(index1);
				//System.out.println(game.getPlayersArray().length);
				for(int i = 0; i < 4; ++i) {
		    		if(i < game.getHumanPlayers()) {
		    			game.setPlayerHuman(i);
		    		}
		    		else {
		    			game.setPlayerComputer(i);
		    		}
		    	}
				for(int i = 0; i < index1; ++i) {
					line = br.readLine();
					game.getPlayers(i).setFirstTurn(Boolean.parseBoolean(line));
					//System.out.println(game.getPlayers(i).getFirstTurn());
					line = br.readLine();
					game.getPlayers(i).setPlaying(Boolean.parseBoolean(line));
					//System.out.println(game.getPlayers(i).getPlaying());
					line = br.readLine();
					index2 = Integer.parseInt(line);
					//System.out.println(index2);
					line = br.readLine();
					index3 = 0;
					for (int j = 0; j < index2; ++j) {
						game.getPlayers(i).addPiece( shape = new int[7][7] , Character.getNumericValue(line.charAt(index3)));
						//System.out.print(Character.getNumericValue(line.charAt(index3)));
						++index3;
						for (int k = 0; k < Piece.SHAPE_SIZE; ++k) {
							for (int l = 0; l < Piece.SHAPE_SIZE; ++l) {
								game.getPlayers(i).getPieces().get(j).setValue(l, k, Character.getNumericValue(line.charAt(index3)));
								//System.out.print(Character.getNumericValue(line.charAt(index3)));
								++index3;
							}
						}
						//System.out.println();
					}
					//System.out.println();
				}
				line = br.readLine();
				index4 = 0;
				for(int i = 0; i < BlokusBoard.BOARD_SIZE; ++i) {
					for(int j = 0; j < BlokusBoard.BOARD_SIZE; ++j) {
						game.getBlokusGame().getBlokusBoard().getSquareAt(j, i).setColor(Character.getNumericValue(line.charAt(index4)));
						//System.out.print(Character.getNumericValue(line.charAt(index4)));
						++index4;
						game.getBlokusGame().getBlokusBoard().getSquareAt(j, i).setValue(Character.getNumericValue(line.charAt(index4)));
						//System.out.print(Character.getNumericValue(line.charAt(index4)));
						++index4;
					}
				}
				for(int i = 0; i < 4; ++i) {
		    		if(i < game.getHumanPlayers()) {
		    			break;
		    		}
		    		else {
		    			game.getPlayers(i).loadStrategy(game.getDifficulty());
		    			game.getPlayers(i).setBoardState(game.getBlokusGame().getBlokusBoard());
		    		}
		    	}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
