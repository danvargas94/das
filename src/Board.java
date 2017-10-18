/**
 * 
 * @author danielavargas
 *
 */

public class Board {
	private static int rows = 6;
	private static int columns = 7;
	static int[][] board;
	
	//Board constructor
	public Board(){
		board = new int[rows][columns];
		//Initialize to 0 the board
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				board[i][j] = 0;
			}
		}
	}
	
	/**
	 * Restarts the board
	 */
	public void restartBoard(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				board[i][j] = 0;
			}
		}
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getColumns(){
		return columns;
	}
	
	/*
	 Function that verifies if a space if empty
	 @params x and y position
	 @return boolean
	*/
	public boolean isOccupied(int x, int y){
		if (board[x][y] != 0){
			return false;
		}
		return true;
	}
	
	/*
	 Function that prints the board with format
	*/
	public void printBoard(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 Function that updates the board filling the given space
	 @params x and y position
	*/
	public void updateBoard(int x, int y, int player){
		board[x][y] = player;
	}
	
	/*
	 Function that gets the last row taken from the given column
	 @params column number
	 @return int: the last space used of the given column 
	*/
	public int getLastRow(int column){
		for(int i = rows - 1; i  >= 0; i--){
			if(board[i][column] == 0){
				return i;
			}
		}
		return 0;
	}
	
	/*
	 Function that checks if the given column has free spaces
	 @params column number
	 @return Boolean
	*/
	public boolean isColumnFull(int column){
		if(board[0][column] > 0){
			return true;
		}
		return false;
	}
	
	public boolean isfullBoard(){
		for(int i = 0; i < columns; i++){
			if (!isColumnFull(i)){
				return false;
			}
		}
		return true;
	}
	
	public int getSpace(int x, int y){
		return board[x][y];
	}
}
