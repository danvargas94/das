import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner; 

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * ConnectFour class that allows to visualize and to follow the flow of the game
 * @author danielavargas
 * @see Imagenes
 *
 */

public class ConnectFour extends JFrame implements KeyListener{
	private static Board board = new Board();
	private static final int SPACE = 10;
	private Player player1 = new Player("Player 1", "YELLOW", 1);
	private Player player2 = new Player("Player 2", "RED", 2);
	private static Player turn = null; 
	private static  Tile[][] tiles;
	private Glass cristal;
	private final Color darkBlue = new Color(115, 176, 170);
	private final Color  blueColor = new Color(200, 219, 206);
	
	/**
	 * Constructs and initializes a Connect Four game
	 */
	public ConnectFour(){
		addKeyListener(this);
		Imagenes.Singleton().cargaCarpeta("images");
		this.setSize(600, 560);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//Initialize game
		turn = player1;
		tiles = new Tile[board.getColumns()][board.getRows()];
		for(int i = 0; i < board.getColumns(); i++){
			for(int j = 0; j < board.getRows(); j++){
				int w = 60;
				Tile t = new Tile(i, j, w);
				tiles[i][j] = t;
			}
		}
		cristal = new Glass(this);
        this.setGlassPane(cristal);
        cristal.setOpaque(false);
        cristal.setVisible(true);
        actualiza();
	}
	

	/**
	 * Restarts the board and turn (Player 1)
	 */
	public void restartGame(){
		board.restartBoard();
		turn = player1;
		for(int i = 0; i < board.getColumns(); i++){
			for(int j = 0; j < board.getRows(); j++){
				int w = 60;
				(tiles[i][j]).restartTile();
			}
		}
		actualiza();
	}
	
	/**
	 * Returns the current player
	 * @return Player
	 */
	public Player getTurn(){
		return turn;
	}
	
	public void paint(Graphics g){
		int w = 60;
		g.setColor(darkBlue);
		g.fillRect(0, 0, this.getWidth(), 100);
		g.setColor(Color.white);
		Font myFont = new Font ("Avenir", 1, 35);
		g.setFont (myFont);
		g.drawString("Connect4", 50, 80);
		myFont = new Font ("Avenir", 1, 22);
		g.setFont (myFont);
		g.drawString(turn.getName() + " turn's", 350, 80);
		g.setColor(blueColor);
		g.fillRect(0, 100, this.getWidth(), this.getHeight() - 100);
		for(int i = 0; i < board.getColumns(); i++){
			for(int j = 0; j < board.getRows(); j++){
				Tile t = tiles[i][j];
				g.drawImage(t.getImage().getImage(), ((w + SPACE) * i) + 60, ((w + SPACE) * j) + 130, w, w, null);
			}
		}
	}
	
	/**
	 * Updates the GUI
	 */
	public void actualiza(){
        validate();
        repaint();
    }
	
	
	/**
	 * Updates the board, drops a piece in the given column 
	 * @param column
	 * @param player
	 */
	public static void placePiece(int column, Player player){
		if (isValidMove(column)){
			int lastRow = board.getLastRow(column);
			board.updateBoard(lastRow, column, player.getNumber());
			ImageIcon im = new ImageIcon(Imagenes.Singleton().imagen(player.getColor() + ".png"));
			(tiles[column][lastRow]).setImage(im);
		}
	}
	

	/**
	 * Boolean function that verifies if it is a valid move
	 * The board and the column aren't full
	 * @param column
	 * @return if the move can be made
	 */
	public static boolean isValidMove(int column){
		if (board.isColumnFull(column)){
			return false;
		}else{
			if(board.getLastRow(column) < 0){
				return false;
			}else{
				return true;
			}
		}
	}
	
	/**
	 * Displays a dialog 
	 */
	public void isTie(){
		if(board.isfullBoard()){
			Object[] options = {"Restart game",
            "Close"};
			int n = JOptionPane.showOptionDialog(this,
					"What do you want to do next?",
					"There was a TIE!", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]);
			if (n == JOptionPane.YES_NO_CANCEL_OPTION){
				System.exit(0);
			}else{
				restartGame();
			}
		}
	}
	
	/**
	 * Verifies if there is a winner
	 * @return Player in case there is a winner or null otherwise
	 */
	public Player checkWin(){
		int p1Score = 0;
		int p2Score = 0;
		//rows
		for(int i = 0; i <= 5; i++){
			//columns
			for(int j = 0; j <= 6; j++){
				//Check horizontal to right
				if(j <= 3){
					for(int k = 0; k < 4; k++){
						if (board.getSpace(i, j + k) == 1){
							p1Score++;
						}else if(board.getSpace(i, j + k) == 2){
							p2Score++;
						}else{
							break;
						}
					}
					if(p1Score == 4){
						return player1;
					}
					if(p2Score == 4){
						return player2;
					}
					p1Score = 0; 
					p2Score = 0;
				}
				
				//Check vertical down
				if(i <= 2){
					for(int k = 0; k < 4; k++){
						if(board.getSpace(i + k, j) == 1){
							p1Score++;
						}else if(board.getSpace(i + k, j) == 2){
							p2Score++;
						}else{
							break;
						}
					}
					if(p1Score == 4){
						return player1;
					}
					if(p2Score == 4){
						return player2;
					}
					p1Score = 0; 
					p2Score = 0;
				}
				
				//Check diagonal up-right
				if(i >= 3 && j <= 3){
					for(int k = 0; k < 4; k++){
						if(board.getSpace(i - k, j + k) == 1){
							p1Score++;
						}else if(board.getSpace(i - k, j + k) == 2){
							p2Score++;
						}else{
							break;
						}
					}
					if(p1Score == 4){
						return player1;
					}
					if(p2Score == 4){
						return player2;
					}
					p1Score = 0; 
					p2Score = 0;
				}
				
				//Check diagonal up-left
				if(i >= 3 && j >= 3){
					for(int k = 0; k < 4; k++){
						if(board.getSpace(i - k, j - k) == 1){
							p1Score++;
						}else if(board.getSpace(i - k, j - k) == 2){
							p2Score++;
						}else{
							break;
						}
					}
					if(p1Score == 4){
						return player1;
					}
					if(p2Score == 4){
						return player2;
					}
					p1Score = 0; 
					p2Score = 0;
				}
			}
			
		}
		return null;
	}
	
	
	/**
	 * Game flow
	 */
	public void playTime(){
		Scanner scan = new Scanner(System.in);
		int column;
		Player winner = null;
		turn = player1;
		while(true){
			System.out.println(turn.getName() + " turn's\n Enter a column");
			column = scan.nextInt();
			while(column < 0 || column > 6 || !isValidMove(column)){
				System.out.println("Invalid column \n Enter a new one");
				column = scan.nextInt();
			}
			placePiece(column, turn);
			board.printBoard();
			winner = checkWin();
			if(winner == null){
				if (turn.equals(player1)){
					turn = player2;
				}else{
					turn = player1;
				}
			}else if (winner.equals(player2)){
				System.out.println(player2.getName() + " wins!!!");
				break;
			}else{
				System.out.println(player1.getName() + " wins!!!");
				break;
			}
		}
	}

	/**
	 * Shows a dialog to restart or resume the game
	 */
	public void stopGame(){
    	Object[] options = {"Restart game",
                "Resume"};
		int n = JOptionPane.showOptionDialog(this,
				"What do you want to do next?",
				"Connect4", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				options,
				options[1]);
		if (n == JOptionPane.YES_NO_CANCEL_OPTION){
		}else{
			restartGame();
		}
    }
	
	/**
	 * Changes the current player 
	 */
	public void changeTurn(){
		if (turn.equals(player1)){
			turn = player2;
		}else{
			turn = player1;
		}
	}
	

	/**
	 * Determines if there is a winner and announces it, otherwise it changes the turn
	 * @return Player 
	 */
	public Player updateGame(){
		Player winner = null;
		winner = checkWin();
		if(winner == null){
			changeTurn();
			return null;
		}else if (winner.equals(player2)){
			System.out.println(player2.getName() + " wins!!!");
			return player2;
		}else{
			System.out.println(player1.getName() + " wins!!!");
			return player1;
		}
	}
	
	public static void main(String args[]) {
		ConnectFour game = new ConnectFour();
		game.playTime();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_R){
			stopGame();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
