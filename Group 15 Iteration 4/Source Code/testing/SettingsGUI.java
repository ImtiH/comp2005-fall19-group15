package testing;
/**
 * Blokus settings display and control.
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SettingsGUI extends JFrame implements ActionListener {
    private JPanel options;
    private JButton run;
    private JCheckBox colorBlindMode, AdvanceScoreMode;
    private JComboBox playerNumber, humanNumber, computerDifficulty;
    private JLabel playof, human, diff;
    private String computerDiff[] = {"Easy", "Normal", "Hard"};
    private Blokus game;
    private int one = 1, two = 2, three = 3, four = 4;
    
    /**
     * Constructor for objects of class GUI
     */
	public SettingsGUI (Blokus game) {
        this.game = game;
        this.setSize(350,250);
        this.setTitle("Blokus Settings");
        this.setLocationRelativeTo(null);
        
        options = new JPanel();
        options.setLayout(new GridLayout(5, 2));
        options.setSize(300, 200);

        playerNumber = new JComboBox();
        playerNumber.addItem(four);
        playerNumber.addItem(three);
        playerNumber.addItem(two);
        playerNumber.addActionListener(this);
        
        humanNumber = new JComboBox();
        humanNumber.addItem(four);
        humanNumber.addItem(three);
        humanNumber.addItem(two);
        humanNumber.addItem(one);
        humanNumber.addActionListener(this);
        
        computerDifficulty = new JComboBox(computerDiff);
        computerDifficulty.addActionListener(this);
        
        colorBlindMode = new JCheckBox("ColorBlindMode");
        colorBlindMode.addActionListener(this);
        
        AdvanceScoreMode = new JCheckBox("AdvanceScoreMode");
        AdvanceScoreMode.addActionListener(this);
        
        run = new JButton("Click to Start Game!");
        run.addActionListener(this);
        
        playof = new JLabel("Number of Players:");
        human = new JLabel("Human Players: ");
        diff = new JLabel("Computer Difficulty:");
        
        options.add(playof);
        options.add(playerNumber);
        options.add(human);
        options.add(humanNumber);
        options.add(diff);
        options.add(computerDifficulty);
        options.add(colorBlindMode);
        options.add(AdvanceScoreMode);
        options.add(run);
        
        options.setVisible(true);
        
        getContentPane().setLayout(null);
        getContentPane().add(options);
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		Object selected = e.getSource();
		if(selected.equals(playerNumber)) {
			game.setNumPlayers((int) playerNumber.getSelectedItem());
		}
		else if(selected.equals(humanNumber)) {
			game.setHumanPlayers((int) humanNumber.getSelectedItem());
		}
		else if(selected.equals(computerDifficulty)) {
			game.setDifficulty(computerDifficulty.getSelectedIndex());
		}
		else if(selected.equals(colorBlindMode)){
			if(colorBlindMode.isSelected()) {
				game.setColorBlindMode(true);
			}
			else {
				game.setColorBlindMode(false);
			}
		}
		else if(selected.equals(AdvanceScoreMode)) {
			if(AdvanceScoreMode.isSelected()) {
				game.setAdvanceScoreMode(true);
			}
			else {
				game.setAdvanceScoreMode(false);
			}
		}
		else if(selected.equals(run)) {
			if(game.getNumPlayers() < game.getHumanPlayers())
	        {
	            JFrame error = new JFrame("ERROR");
	            error.setSize(400,100);
	            JLabel message = new JLabel("Error! To many players!");
	            error.add(message);
	            message.setOpaque(true);
	            message.setForeground(Color.RED);
	            
	            error.setLocationRelativeTo(null);
	            error.setVisible(true);
	        }
	        else{
	        	setVisible(false);
	        	game.startGame();
	        }
		}
	}
}
