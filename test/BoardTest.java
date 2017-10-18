import static org.junit.Assert.*;

import org.junit.Test;


public class BoardTest {

	@Test
	public void testGetLastRow() {
		Board board = new Board();
		int expected = 5;
		int result = board.getLastRow(0);
		assertEquals(expected, result, 0.01);
	}
	
	@Test
	public void testGetLastRow1() {
		Board board = new Board();
		board.updateBoard(5, 0, 1);
		board.updateBoard(4, 0, 2);
		board.updateBoard(3, 0, 1);
		board.updateBoard(2, 0, 2);
		board.updateBoard(1, 0, 1);
		int expected = 0;
		int result = board.getLastRow(0);
		assertEquals(expected, result, 0.01);
	}
	
	@Test
	public void testGetLastRow2() {
		Board board = new Board();
		board.updateBoard(5, 0, 1);
		board.updateBoard(4, 0, 2);
		board.updateBoard(3, 0, 1);
		board.updateBoard(2, 0, 2);
		board.updateBoard(1, 0, 1);
		board.updateBoard(0, 0, 2);
		int expected = 0;
		int result = board.getLastRow(0);
		assertEquals(expected, result, 0.01);
	}

	@Test
	public void testIsfullBoard() {
		Board board = new Board();
		boolean expected = false;
		boolean result = board.isfullBoard();
		assertEquals(expected, result);
	}
	
	@Test
	public void testIsfullBoard1() {
		Board board = fillBoard();
		board.printBoard();
		boolean expected = true;
		boolean result = board.isfullBoard();
		assertEquals(expected, result);
	}
	
	public Board fillBoard(){
		Board board = new Board();
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 7; j++){
				board.updateBoard(i, j, 2);
			}
		}
		return board;
	}
}
