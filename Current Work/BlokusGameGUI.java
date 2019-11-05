/**
 * The BlokusGameGUI is the main display for the blokus game and will provide the way we interact with the game.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlokusGameGUI extends JFrame implements MouseListener {
	private JPanel board;
	private JPanel pieces;
	private BlokusBoard displayGrid;
	private Blokus game;
	
	BlokusGameGUI(Blokus game){
		this.game = game;
		this.displayGrid = new BlokusBoard();
		this.setSize(1080,720);
        this.setTitle("Blokus");
        this.setLocationRelativeTo(null);
        
        this.board = new JPanel();
        
        this.draw();
        
        getContentPane().setLayout( new BorderLayout());
        getContentPane().add( this.board, BorderLayout.CENTER);
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}
	
	public void draw() {
		this.board.removeAll();
		this.board.setLayout(new GridLayout(20, 20));
		this.board.setSize(1000,1000);
		for(int y = 0; y < 20; y++) {
			for(int x = 0; x < 20; x++) {
				this.board.add(displayGrid.getSquareAt(x, y));
			}
		}
		this.board.setVisible(false);
		this.board.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
}
