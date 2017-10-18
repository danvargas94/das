
/**
 * Player class represents a participant of the game
 * @author danielavargas
 *
 */
public class Player {
	private String playerName;
	private String playerColor;
	private int number;

	/**
	 * Constructs and initializes a player
	 * @param playerName 
	 * @param playerColor (YELLOW or RED)
	 * @param number of player
	 */
	public Player(String playerName, String playerColor, int number){
		this.playerName = playerName;
		this.playerColor = playerColor;
		this.number = number;
	}
	
	/**
	 * Determines the name of the player
	 * @return player's name
	 */
	public String getName(){
		return playerName;
	}

	/**
	 * Determines the color of the player
	 * @return RED or YELLOW
	 */
	public String getColor(){
		return playerColor;
	}
	
	/**
	 * Determines the number of the player
	 * @return 1 or 2
	 */
	public int getNumber(){
		return number;
	}
}
