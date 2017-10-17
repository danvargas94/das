import java.awt.*;
import java.awt.Color;

public class Player {
	private String playerName;
	private String playerColor;
	private int number;

	public Player(String playerName, String playerColor, int number){
		this.playerName = playerName;
		this.playerColor = playerColor;
		this.number = number;
	}

	public String getName(){
		return playerName;
	}

	public String getColor(){
		return playerColor;
	}
	
	public int getNumber(){
		return number;
	}
}
