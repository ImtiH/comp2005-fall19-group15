/**
 * The Blokus class controls the game and all other classes.
 */
public class Blokus {
    private int numberPlayers;
    private int humanPlayers;
    private int difficulty;
    private boolean fourPlayerMode;
    private boolean threePlayerMode;
    private boolean twoPlayerMode;
    private boolean colorBlindMode;
    private boolean advanceScore;
    private SettingsGUI settings;
    private Player players[];
    private Shapes shapes;
    private int turn;
    private BlokusGameGUI blokusGame;
    
    public Blokus() {
        this.numberPlayers = 4;
        this.humanPlayers = 4;
        this.difficulty = 1;
        this.fourPlayerMode = true;
        this.threePlayerMode = false;
        this.twoPlayerMode = false;
        this.colorBlindMode = false;
        this.advanceScore = false;
        this.turn = 0;
        this.shapes = new Shapes();
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
    
    public void SetTurn(int num) {
    	this.turn = num;
    }
    
    public void setPlayers(int num) {
    	this.players = new Player[num];
    }
    
    public void setPlayerHuman(int num) {
    	HumanPlayer human = new HumanPlayer(); 
    	this.players[num] = human;
    }
    
    public void setPlayerComputer(int num) {
    	ComputerPlayer computer = new ComputerPlayer();
    	computer.setStrategy(this.getDifficulty());
    	this.players[num] = computer;
    }
    
    public void setFourPlayerMode(boolean mode) {
    	this.fourPlayerMode = mode;
    }
    
    public void setThreePlayerMode(boolean mode) {
    	this.threePlayerMode = mode;
    }
    
    public void setTwoPlayerMode(boolean mode) {
    	this.twoPlayerMode = mode;
    }
    
    public void setColorBlindMode(boolean mode) {
        this.colorBlindMode = mode;
    }
    
    public void setAdvanceScoreMode(boolean mode) {
    	this.advanceScore = mode;
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
    
    public int getTurn() {
    	return this.turn;
    }
    
    public boolean getColorBlindMode() {
    	return this.colorBlindMode;
    }
    
    public boolean getAdvanceScoreMode() {
    	return this.advanceScore;
    }
    
    public boolean isFourPlayerMode() {
    	return this.fourPlayerMode;
    }
    
    public boolean isThreePlayerMode() {
    	return this.threePlayerMode;
    }
    
    public boolean isTwoPlayerMode() {
    	return this.twoPlayerMode;
    }
    
    public boolean isColorBlindMode() {
    	return this.colorBlindMode;
    }
     public boolean isAdvanceScore() {
    	 return this.advanceScore;
     }
     
    public Shapes getShapes() {
    	return this.shapes;
    }
    
    public Player getPlayers(int i) {
    	return this.players[i];
    }
    
    public Player[] getPlayersArray() {
    	return this.players;
    }
    
    public void startGame() {
    	int color = 0;
    	this.turn = 0;
    	players = new Player[4];
    	for(int i = 0; i < 4; ++i) {
    		if(isColorBlindMode()) {
    			color = i + 5;
    		}
    		else {
    			color = i + 1;
    		}
    		if(i < getHumanPlayers()) {
    			HumanPlayer human = new HumanPlayer(color, this.shapes); 
    			players[i] = human;
    		}
    		else {
    			ComputerPlayer computer = new ComputerPlayer(color, this.shapes, this.difficulty, new BlokusBoard());
    			players[i] = computer;
    		}
    	}
    	this.setBlokusGame(new BlokusGameGUI(this));
    }
    
    public void newTurn() {
    	++this.turn;
    	this.turn %= getNumPlayers();
    	
    	if (isGameOver()) {
    		calculateScore();
    		getBlokusGame().displayScore();
    		System.exit(0);
    	}
    	
    	if (!players[getTurn()].getPlaying()) {
    		newTurn();
    		return;
    	}
    	
    	getPlayers(getTurn()).move(getBlokusGame());
    }
    
    public boolean isGameOver() {
    	for (int i = 0; i < getNumPlayers(); i++)
        {
    	   if (getPlayers(i).isSquareOneLast()) {
    		   return true;
    	   }
           if (getPlayers(i).getPlaying()) {
            	return false;
            }
        }
        return true;
    }
    
    public void calculateScore() {
		if(isAdvanceScore()) {
			for (int i = 0; i < getNumPlayers(); ++i) {
				   getPlayers(i).calculateAdvanceScore();
			}
		}
		else {
			for (int i = 0; i < getNumPlayers(); ++i) {
				getPlayers(i).calculateBasicScore();
			}
		}
    }

	public BlokusGameGUI getBlokusGame() {
		return blokusGame;
	}

	public void setBlokusGame(BlokusGameGUI blokusGame) {
		this.blokusGame = blokusGame;
	}
}