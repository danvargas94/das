
/**
 * Board class 
 * @author danielavargas
 *
 */

public class Board {
	private static int rows = 6;
	private static int columns = 7;
	static int[][] board;
	

	/**
	 * Constructs and initializes the board
	 */
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
	

	/**
	 * Verifies is a space is empty
	 * @param x row
	 * @param y colum
	 * @return if the space is empty
	 */
	public boolean isOccupied(int x, int y){
		if (board[x][y] != 0){
			return false;
		}
		return true;
	}
	

	/**
	 * Prints the board with format
	 */
	public void printBoard(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	

	/**
	 * Updates the board filling the given space
	 * @param x row
	 * @param y colum
	 * @param player
	 */
	public void updateBoard(int x, int y, int player){
		board[x][y] = player;
	}
	

	/**
	 * Gets the last row taken from the given column
	 * @param column
	 * @return next free space
	 */
	public int getLastRow(int column){
		for(int i = rows - 1; i  >= 0; i--){
			if(board[i][column] == 0){
				return i;
			}
		}
		return 0;
	}
	

	/**
	 * Verifies that the given column has free spaces
	 * @param column
	 * @return is there are free spaces
	 */
	public boolean isColumnFull(int column){
		if(board[0][column] > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Verifies is the board is full
	 * @return if the board has any empty space
	 */
	public boolean isfullBoard(){
		for(int i = 0; i < columns; i++){
			if (!isColumnFull(i)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Determines the value of the tile
	 * @param x row
	 * @param y column
	 * @return value of the tile
	 */
	public int getSpace(int x, int y){
		return board[x][y];
	}
}
