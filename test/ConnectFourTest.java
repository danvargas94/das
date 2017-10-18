import static org.junit.Assert.*;

import org.junit.Test;


public class ConnectFourTest {

	@Test
	public void testIsValidMove() {
		boolean expected = true;
		boolean result = ConnectFour.isValidMove(0);
		assertEquals(expected, result);
	}
	
	@Test
	public void testCheckWin() {
		ConnectFour game = new ConnectFour();
		Player expected = null;
		Player result = game.checkWin();
		assertEquals(expected, result);
	}
	
	@Test
	public void testCheckWin1() {
		ConnectFour game = fillGame();
		Player expected = game.getTurn();
		Player result = game.checkWin();
		game.restartGame();
		assertEquals(expected, result);
	}

	@Test
	public void testUpdateGame() {
		ConnectFour game = new ConnectFour();
		Player expected = null;
		Player result = game.updateGame();
		game.restartGame();
		assertEquals(expected, result);
	}
	
	@Test
	public void testUpdateGame1() {
		ConnectFour game = fillGame();
		Player expected = game.getTurn();
		Player result = game.updateGame();
		game.restartGame();
		assertEquals(expected, result);
	}
	
	
	public ConnectFour fillGame(){
		ConnectFour game = new ConnectFour();
		Player player = game.getTurn();
		for(int i = 0; i < 4; i++){
			game.placePiece(0, game.getTurn());
			game.changeTurn();
			game.placePiece(i + 1, game.getTurn());
			game.changeTurn();
		}
		return game;
	}

}
