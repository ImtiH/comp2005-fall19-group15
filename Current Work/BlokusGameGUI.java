/**
 * The BlokusGameGUI is the main display for the blokus game and will provide the way we interact with the game.
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BlokusGameGUI extends JFrame {
	public static final int WHITE = 0;
    public static final int BLUE = 1;
    public static final int RED = 2;
    public static final int YELLOW = 3;
	public static final int GREEN = 4;
	public static final int BOARD_RESOLUTION = 500;
	public static final int PIECE_RESOLUTION = 120;
	public static final Color GRID_LINE_COLOR = Color.GRAY;
	public static final Color PIECE_LINE_COLOR = Color.BLACK;
	
	private Point selected;
	private int index;
	
	private JPanel board;
	private JPanel pieces;
	private JLabel boardLabel;
	private BlokusPieceLabel piecesLabel;
	private JScrollPane pageScroll;
	private ImageIcon boardImage;
	private BlokusBoard displayGrid;
	private Blokus game;
	
	BlokusGameGUI(Blokus game) {
		this.game = game;
		this.displayGrid = new BlokusBoard();
		this.setSize(660,540);
        this.setTitle("Blokus");
        this.setLocationRelativeTo(null);
        
        this.board = new JPanel();
        this.pieces = new JPanel();
        
        this.pieces.setLayout(new BoxLayout(pieces, BoxLayout.PAGE_AXIS));
        
        this.pageScroll = new JScrollPane(pieces);
        
        this.pageScroll.getVerticalScrollBar().setUnitIncrement(PIECE_RESOLUTION / 3);
        this.pageScroll.setPreferredSize(new Dimension(PIECE_RESOLUTION + 20, BOARD_RESOLUTION  - 30));
        
        this.boardImage = new ImageIcon(this.renderBoard());
        this.boardLabel = new JLabel(boardImage);
        BoardLabelMouseListener blms = new BoardLabelMouseListener();
        this.boardLabel.addMouseListener(blms);
        this.boardLabel.addMouseMotionListener(blms);
        this.board.add(boardLabel);
        
        drawPlayerPieces();
        
        getContentPane().setLayout( new BorderLayout());
        getContentPane().add( this.board, BorderLayout.CENTER);
        getContentPane().add(this.pageScroll, BorderLayout.WEST);
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public BufferedImage renderBoard() {
		BufferedImage image = new BufferedImage(BOARD_RESOLUTION, BOARD_RESOLUTION, BufferedImage.TYPE_INT_RGB);
	    int cellSize = BOARD_RESOLUTION / (BlokusBoard.BOARD_SIZE);
	    Graphics2D g = (Graphics2D) image.getGraphics();
	    
	    for(int y = 0; y < BlokusBoard.BOARD_SIZE; y++) {
			for(int x = 0; x < BlokusBoard.BOARD_SIZE; x++) {
				g.setColor(displayGrid.getSquareAt(x, y).getColor());
				g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
	            g.setColor(GRID_LINE_COLOR);
	            g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
			}
		}
		return image;
	}
	
	public BufferedImage renderPieceList(Piece p) {
		BufferedImage image = new BufferedImage(PIECE_RESOLUTION, PIECE_RESOLUTION, BufferedImage.TYPE_INT_RGB);
		int cellSize = PIECE_RESOLUTION / (Piece.SHAPE_SIZE);
		Graphics2D g = (Graphics2D) image.getGraphics();
		
		g.setColor(Color.WHITE);
	    g.fillRect(0, 0, PIECE_RESOLUTION, PIECE_RESOLUTION);
	    
	    for (int x = 0; x < Piece.SHAPE_SIZE; x++)
	    {
	    	for (int y = 0; y < Piece.SHAPE_SIZE; y++)
	        {
	    		if (p.getValue(x, y) == Piece.PIECE)
	            {
	               g.setColor(p.getColor());
	               g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
	               g.setColor(PIECE_LINE_COLOR);
	               g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
	            }
	        }
	    }
		return image;
	}
	
	public void drawBoard() {
       boardImage.setImage(renderBoard());
       boardLabel.repaint();
    }
	
	public void drawPlayerPieces() {
		pieces.removeAll();
		for(int i = 0; i < game.getPlayers(game.getCurrentTurn()).getPieces().size(); i++) {
			piecesLabel = new BlokusPieceLabel(i, game.getPlayers(game.getCurrentTurn()).getPieces().get(i));
			piecesLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			piecesLabel.addMouseListener(new PieceLabelMouseListener());
			pieces.add(piecesLabel);
		}
		drawBorder();
		pieces.repaint();
	}
	
	
	public boolean isInBounds(int x, int y) {
		return (x >= 0 && y >= 0 && x < BlokusBoard.BOARD_SIZE && y < BlokusBoard.BOARD_SIZE);
	}
	
	public void moveDisplay(Piece p, int xOff, int yOff) {
		displayGrid.reset();
		for(int x = 0; x < Piece.SHAPE_SIZE; x++) {
			for(int y = 0; y < Piece.SHAPE_SIZE; y++) {
				if(isInBounds(x + xOff - Piece.SHAPE_SIZE / 2, y + yOff - Piece.SHAPE_SIZE / 2) && p.getValue(x, y) == Piece.PIECE) {
					displayGrid.getSquareAt(x + xOff - Piece.SHAPE_SIZE / 2 , y + yOff - Piece.SHAPE_SIZE / 2).setColor(p.getColorNum());
				}
			}
		}
	}
	
	public void drawBorder() {
       JComponent piece = (JComponent) pieces.getComponent(index);
       piece.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
    }
	
	public void clearBorder() {
       JComponent piece = (JComponent) pieces.getComponent(index);
       piece.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }
	
	public class BlokusPieceLabel extends JLabel {  
		public int pieceIndex;
	      
	    public BlokusPieceLabel(int pieceIndex, Piece p) {
	    	super(new ImageIcon(renderPieceList(p)));
	        this.pieceIndex = pieceIndex;
	    }
    }
	
    private class BoardLabelMouseListener implements MouseListener, MouseMotionListener {

		public void mouseClicked(MouseEvent e) {
			displayGrid.placePiece(game.getPlayers(0).getPieces().get(index), selected.x, selected.y, true);
			drawBoard();
			game.getPlayers(0).getPieces().remove(index);
			drawPlayerPieces();
			setVisible(true);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseMoved(MouseEvent e) {
			Point p = displayGrid.getCoordinates(e.getPoint(), BOARD_RESOLUTION);
			if(!p.equals(selected)) {
				selected = p;
				//moveDisplay(game.getPlayers(0).getPieces().get(index), selected.x, selected.y);
				drawBoard();
			}
		}
		
	}
	
    private class PieceLabelMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			BlokusPieceLabel p = (BlokusPieceLabel) e.getComponent();
			clearBorder();
			index = p.pieceIndex;
			drawBorder();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}