
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Glass class is used to receive mouse events
 * @author danielavargas
 *
 */
public class Glass extends JPanel implements MouseListener {
    
    private ConnectFour parent;
    
    /**
     * Constructs and initializes a glass
     * @param parent ConnectFour game
     */
    public Glass(ConnectFour parent){
        super();
        this.setBackground(Color.white);
        this.parent = parent;
        addMouseListener(this);
        parent.actualiza();
    }
        
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	int space = 60;
    	Player winner = null;
        int x = e.getX();
        int y = e.getY();
        // Column 1
        if(x >= (0 + space) && x < (80 + space) && y >= 100){
        	if(parent.isValidMove(0)){
        		parent.placePiece(0, parent.getTurn());
            	parent.actualiza();
            	winner = parent.updateGame();
        	}
        }
        // Column 2
        if(x >= (80 + space) && x < (150 + space) && y >= 100){
        	if(parent.isValidMove(1)){
	        	parent.placePiece(1, parent.getTurn());
	        	parent.actualiza();
	        	winner = parent.updateGame();
        	}
        }
        // Column 3
        if(x >= (150 + space) && x < (220 + space) && y >= 100){
        	if(parent.isValidMove(2)){
	        	parent.placePiece(2, parent.getTurn());
	        	parent.actualiza();
	        	winner = parent.updateGame();
        	}
        }
        // Column 4
        if(x >= (220 + space) && x < (290 + space) && y >= 100){
        	if(parent.isValidMove(3)){
	        	parent.placePiece(3, parent.getTurn());
	        	parent.actualiza();
	        	winner = parent.updateGame();
        	}
        }
        // Column 5
        if(x >= (290 + space) && x < (360 + space) && y >= 100){
        	if(parent.isValidMove(4)){
	        	parent.placePiece(4, parent.getTurn());
	        	parent.actualiza();
	        	winner = parent.updateGame();
        	}
        }
        // Column 6
        if(x >= (360 + space) && x < (430 + space) && y >= 100){
        	if(parent.isValidMove(5)){
	        	parent.placePiece(5, parent.getTurn());
	        	parent.actualiza();
	        	winner = parent.updateGame();
        	}
        }
        // Column 7
        if(x >= (430 + space) && x < (500 + space) && y >= 100){
        	if(parent.isValidMove(6)){
	        	parent.placePiece(6, parent.getTurn());
	        	parent.actualiza();
	        	winner = parent.updateGame();
        	}
        }
        parent.isTie();
        if(winner != null){
        	gameOver(winner);
    	}
    }
    
    /*
	 Method used to end or restart the game, it uses optional Dialog 
	*/
    public void gameOver(Player winner){
    	Object[] options = {"Play again",
                "Close"};
		int n = JOptionPane.showOptionDialog(parent,
				"Congrats " + winner.getName() + "!",
				"Game over",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				options,
				options[1]);
		if (n == JOptionPane.YES_NO_CANCEL_OPTION){
			System.exit(0);
		}else{
			parent.restartGame();
		}
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
        
}
