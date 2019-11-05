import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Settings extends JFrame implements ActionListener
{

    private JFrame setupScreen;
    private JFrame board;
    private JButton two, three, four,hpone,hptwo, hpthree,hpfour, cbyes, cbno, easy, medium, hard, run;
    private Blokus game;
    /**
     * Constructor for objects of class GUI
     */
    public Settings(Blokus game)
    {
        this.game = game;
        this.setupScreen = new JFrame("New Game");
        this.board = new JFrame("Board");
        two = new JButton("");
        three = new JButton("");
        four = new JButton("");
        
        hpone  = new JButton("");
        hptwo  = new JButton("");
        hpthree  = new JButton("");
        hpfour  = new JButton("");
        
        cbyes = new JButton("");
        cbno = new JButton("");
        
        easy = new JButton("");
        medium = new JButton("");
        hard = new JButton("");
        run = new JButton("Click to Start");


        two.setText("Two");
        three.setText("Three");
        four.setText("Four");
        
        hpone.setText("1");
        hptwo.setText("2");
        hpthree.setText("3");
        hpfour.setText("4");

        easy.setText("Easy");
        medium.setText("Medium");
        hard.setText("Hard");
        
        cbyes.setText("Yes");
        cbno.setText("No");
        
        //run.setText("Click To Start");
    }

  
    public void settingInterface()
    {
        setupScreen.setSize(500, 600);
        setupScreen.setVisible(true);
        JLabel settings = new JLabel("Blokus Settings");

        JLabel numof = new JLabel("Number of Players:");
        JLabel humanPlayer = new JLabel("Human Players: ");
        JLabel difficulty = new JLabel("Difficulty:");
 
        JLabel colorBlind = new JLabel("Color Blind Mode: ");

        
        setupScreen.setLayout(null);
        setupScreen.getContentPane().setBackground(Color.WHITE);
        run.setBackground(Color.WHITE);
        setupScreen.setLocationRelativeTo(null);
        setupScreen.add(run);
        setupScreen.add(cbyes);
        setupScreen.add(cbno);
        setupScreen.add(colorBlind);

        setupScreen.add(easy);
        setupScreen.add(medium);
        setupScreen.add(hard);
        setupScreen.add(difficulty);

        setupScreen.add(two);
        setupScreen.add(three);
        setupScreen.add(four);
        setupScreen.add(hpone);
        setupScreen.add(hptwo);
        setupScreen.add(hpthree);
        setupScreen.add(hpfour);
        setupScreen.add(numof);
        setupScreen.add(humanPlayer);

        setupScreen.add(settings);
        

        run.setBounds(170, 450, 120, 60); //this is needed for the start button
        settings.setBounds(160,15,500,100);

        numof.setBounds(35, 135, 125, 25);
        humanPlayer.setBounds(35,230,125,15);
        difficulty.setBounds(35, 320, 125, 25);

        two.setBounds(155, 120, 83, 50);
        three.setBounds(250, 120, 83, 50);
        four.setBounds(345, 120, 83, 50);
        
        hpone.setBounds(138,215,60,60);
        hptwo.setBounds(212,215,60,60);
        hpthree.setBounds(295,215,60,60);
        hpfour.setBounds(370,215,60,60);
        
        easy.setBounds(105,300, 100, 55);
        medium.setBounds(220, 300, 100, 55);
        hard.setBounds(335, 300, 95, 55);
        
;
        colorBlind.setBounds(35,390, 225, 25);
        cbyes.setBounds(150,375, 65, 55);
        cbno.setBounds(250, 375, 65, 55);

        two.setBackground(Color.GREEN);
        three.setBackground(Color.RED);
        four.setBackground(Color.BLUE);
        
        two.setForeground(Color.WHITE);
        three.setForeground(Color.WHITE);
        four.setForeground(Color.WHITE);
        
        hpone.setBackground(Color.GREEN);
        hptwo.setBackground(Color.RED);

        hpthree.setBackground(Color.ORANGE);
        hpfour.setBackground(Color.BLUE);
        

       
        hpone.setForeground(Color.WHITE);
        hptwo.setForeground(Color.WHITE);
        hpthree.setForeground(Color.WHITE);
        hpfour.setForeground(Color.WHITE);
        
        easy.setBackground(Color.RED);
        medium.setBackground(Color.ORANGE);
        hard.setBackground(Color.BLUE);
        
        easy.setForeground(Color.WHITE);
        medium.setForeground(Color.WHITE);
        hard.setForeground(Color.WHITE);

        
        
        cbyes.setBackground(Color.BLACK);
        cbno.setBackground(Color.RED);
        
        cbyes.setForeground(Color.WHITE);
        cbno.setForeground(Color.WHITE);
        
        run.setBackground(Color.DARK_GRAY);
        run.setForeground(Color.WHITE);

        
        

        two.setFocusable(false);
        three.setFocusable(false);
        four.setFocusable(false);
        
        hpone.setFocusable(false);
        hptwo.setFocusable(false);
        hpthree.setFocusable(false);
        hpfour.setFocusable(false);
        

        cbyes.setFocusable(false);
        cbno.setFocusable(false);
        easy.setFocusable(false);
        medium.setFocusable(false);
        hard.setFocusable(false);
        run.setFocusable(false);

        two.setFont(new Font("Arial", Font.BOLD, 18));
        three.setFont(new Font("Arial", Font.BOLD, 18));
        four.setFont(new Font("Arial", Font.BOLD, 18));
        
        hpone.setFont(new Font("Arial", Font.PLAIN, 40));
        hptwo.setFont(new Font("Arial", Font.PLAIN, 40));
        hpthree.setFont(new Font("Arial", Font.PLAIN, 40));
        hpfour.setFont(new Font("Arial", Font.PLAIN, 40));
        
        
        easy.setFont(new Font("Arial", Font.BOLD, 15));
        medium.setFont(new Font("Arial", Font.BOLD, 15));
        hard.setFont(new Font("Arial", Font.BOLD, 15));
        cbyes.setFont(new Font("Arial", Font.BOLD, 15));
        cbno.setFont(new Font("Arial", Font.BOLD, 15));

        settings.setFont(new Font("Arial", Font.BOLD, 18));
        run.setFont(new Font("Arial", Font.BOLD, 13));
        

        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        
        hpone.addActionListener(this);
        hptwo.addActionListener(this);
        hpthree.addActionListener(this);
        hpfour.addActionListener(this);
        

        easy.addActionListener(this);
        medium.addActionListener(this);
        hard.addActionListener(this);
        cbyes.addActionListener(this);
        cbno.addActionListener(this);
        run.addActionListener(this);
    }
 
    public void openSetupGUI()
    {
        setupScreen.setVisible(true);
    }
    
    public void closeSetupGUI()
    {
        setupScreen.setVisible(false);
    }
    
    
    public void gameInterface()
    {
        this.board.setSize(1000,650);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        JLabel future = new JLabel("The game feautres will be here in the next iteration");
        board.setLayout(null);
        board.add(future);
        future.setBounds(300,150,500,200);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton) e.getSource();
 
        if (button.getText() == "Two")
        {
       	 this.game.setNumPlayers(2);
         button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
         three.setBorder(BorderFactory.createEmptyBorder());
         four.setBorder(BorderFactory.createEmptyBorder());
        }
        else if (button.getText() == "Three")
        {
        	this.game.setNumPlayers(3);
        	button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
        	two.setBorder(BorderFactory.createEmptyBorder());
        	four.setBorder(BorderFactory.createEmptyBorder());
        }
        else if (button.getText() == "Four")
        {
        	this.game.setNumPlayers(4);
        	button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
        	two.setBorder(BorderFactory.createEmptyBorder());
        	three.setBorder(BorderFactory.createEmptyBorder());
        }
        else if (button.getText() == "1")
        {
        	 this.game.setNumHumanPlayers(1);
             button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
             hptwo.setBorder(BorderFactory.createEmptyBorder());
             hpthree.setBorder(BorderFactory.createEmptyBorder());
             hpfour.setBorder(BorderFactory.createEmptyBorder());
        }
        else if (button.getText() == "2")
        {
       	    this.game.setNumHumanPlayers(2);
            button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
            hpone.setBorder(BorderFactory.createEmptyBorder());
            hpthree.setBorder(BorderFactory.createEmptyBorder());
            hpfour.setBorder(BorderFactory.createEmptyBorder());
       }
        else if (button.getText() == "3")
        {
       	    this.game.setNumHumanPlayers(3);
            button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
            hptwo.setBorder(BorderFactory.createEmptyBorder());
            hpone.setBorder(BorderFactory.createEmptyBorder());
            hpfour.setBorder(BorderFactory.createEmptyBorder());
       }
        else if (button.getText() == "4")
        {
       	 	this.game.setNumHumanPlayers(4);
            button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
            hptwo.setBorder(BorderFactory.createEmptyBorder());
            hpthree.setBorder(BorderFactory.createEmptyBorder());
            hpone.setBorder(BorderFactory.createEmptyBorder());
       }
       else if(button.getText() == "Easy")
        {
            this.game.setDifficulty(1);
            button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
            medium.setBorder(BorderFactory.createEmptyBorder());
            hard.setBorder(BorderFactory.createEmptyBorder());
        }
        else if(button.getText() == "Medium")
        {
            this.game.setDifficulty(2);
            button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
            easy.setBorder(BorderFactory.createEmptyBorder());
            hard.setBorder(BorderFactory.createEmptyBorder());
        }
        else if(button.getText() == "Hard")
        {
            this.game.setDifficulty(3);
            button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
            medium.setBorder(BorderFactory.createEmptyBorder());
            easy.setBorder(BorderFactory.createEmptyBorder());
        }
        else if(button.getText() == "Yes")
        {
            this.game.setColor(true);
            button.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
            cbno.setBorder(BorderFactory.createEmptyBorder());
;
            two.setBackground(Color.BLACK);
            three.setBackground(Color.BLACK);
            four.setBackground(Color.BLACK);

            
            hpone.setBackground(Color.BLACK);
            hptwo.setBackground(Color.BLACK);
            hpthree.setBackground(Color.BLACK);
            hpfour.setBackground(Color.BLACK);
            
            easy.setBackground(Color.BLACK);
            medium.setBackground(Color.BLACK);
            hard.setBackground(Color.BLACK);
            
            cbno.setBackground(Color.BLACK);
        }
        else if(button.getText() == "No")
        {
            this.game.setColor(false);
            button.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
            cbyes.setBorder(BorderFactory.createEmptyBorder());
 
            two.setBackground(Color.GREEN);
            three.setBackground(Color.RED);
            four.setBackground(Color.BLUE);
            hpone.setBackground(Color.GREEN);
            hptwo.setBackground(Color.RED);
            hpthree.setBackground(Color.ORANGE);
            hpfour.setBackground(Color.BLUE);
            
            easy.setBackground(Color.RED);
            medium.setBackground(Color.ORANGE);
            hard.setBackground(Color.BLUE);
            
            cbno.setBackground(Color.RED);
        }
        else if(button.getText() == "Click to Start")
        {
        	blokusBoard();
        }
    }
    
    public void blokusBoard()
    {
        if(this.game.getNumPlayers() <= 1 || this.game.getDifficulty() == 0 || this.game.getNumHumanPlayers() == 0)
        {
            JFrame error = new JFrame("ERROR");
            error.setSize(400,100);
            JLabel message = new JLabel("Error! Make sure you select all the settings to start the game");
            error.add(message);
            message.setOpaque(true);
            message.setForeground(Color.RED);
            
            error.setLocationRelativeTo(null);
            error.setVisible(true);
        }
        else{
        	gameInterface();
        }
    }
}
