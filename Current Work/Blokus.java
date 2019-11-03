package Blokus15;


public class Blokus
{
    private int numPlayers;
    private int humanPlayers;
    private boolean color;
    private int difficulty;
    private Settings startgame;
    
    public Blokus()
    {
        startgame = new Settings(this);
    }

    public void setNumPlayers(int num)
    {
        this.numPlayers = num;
    }
    
    public void setNumHumanPlayers(int num){
    	this.humanPlayers = num;
    }
    
    public void setDifficulty(int diff)
    {
        this.difficulty = diff;
    }
    
    
    public void setColor(boolean col)
    {
        this.color = col;
    }
    
    
    public int getNumPlayers()
    {
        return this.numPlayers;
    }
    
    public int getNumHumanPlayers() {
    	return this.humanPlayers;
    }
    
    public int getDifficulty()
    {
        return this.difficulty;
    }
    
    public void startGame()
    {
        this.startgame.settingInterface();
    }


}
