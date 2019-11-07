/**
 * The Blokus class controls the game and all other classes.
 */
public class Blokus {
    private int numberPlayers;
    private int humanPlayers;
    private int difficulty;
    private boolean colorBlindMode;
    private SettingsGUI settings;
    private Player players[];
    private int currentTurn;
    private boolean gameOver;
    private BlokusGameGUI blokusGame;
    
    public Blokus() {
        this.numberPlayers = 2;
        this.humanPlayers = 1;
        this.difficulty = 0;
        this.colorBlindMode = false;
        this.settings = new SettingsGUI(this);
    }

    public void setNumPlayers(int num) {
        this.numberPlayers = num;
    }
    
    public void setHumanPlayers(int num) {
    	this.humanPlayers = num;
    }
    
    public void setDifficulty(int diff) {
        this.difficulty = diff;
    }
    
    
    public void setColorBlindMode(boolean col) {
        this.colorBlindMode = col;
    }
    
    public int getNumPlayers() {
        return this.numberPlayers;
    }
    
    public int getHumanPlayers() {
    	return this.humanPlayers;
    }
    
    public int getDifficulty() {
        return this.difficulty;
    }
    
    public int getCurrentTurn() {
    	return this.currentTurn;
    }
    
    public Player getPlayers(int i) {
    	return this.players[i];
    }
    
    public void startGame() {
    	players = new Player [4];
    	for(int i = 0; i < getNumPlayers(); ++i) {
    		if(i < getHumanPlayers()) {
    			HumanPlayer human = new HumanPlayer(i + 1); 
    			players[i] = human;
    		}
    		else {
    			ComputerPlayer computer = new ComputerPlayer(i + 1, difficulty, new BlokusBoard());
    			players[i] = computer;
    		}
    	}
    	currentTurn = 0;
    	this.blokusGame = new BlokusGameGUI(this);
    }
}
