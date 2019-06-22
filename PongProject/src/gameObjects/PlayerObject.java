package gameObjects;

public class PlayerObject extends MovingObject{
	
	//Enum used to differentiate between the two players
	public enum PLAYER_INDEX
	{
		FIRST_PLAYER, SECOND_PLAYER
	}
	
	//Player Size
	static final int WIDTH = 8;
	static final int HEIGHT = 50;
	//Player Movement Speed
	static final int SPEED = 1;
	
	//Dictates whether it is the first or second player
	private PLAYER_INDEX playerIndex;
	
	/**
	 * Constructor for player object
	 * @param _playerIndex Dictates whether it is the first or second player
	 */
	public PlayerObject(PLAYER_INDEX _playerIndex) 
	{
		super(WIDTH, HEIGHT);
		
		playerIndex = _playerIndex;
	}
	
	//Sets the player's velocity
	public void moveUp() { velocityY = -SPEED; }
	public void moveDown() { velocityY = SPEED; }
	public void stop() { velocityY = 0; }
	
	//Getters
	public PLAYER_INDEX getPlayerIndex() { return playerIndex; }
}
