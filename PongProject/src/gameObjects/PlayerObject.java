package gameObjects;

public class PlayerObject extends MovingObject{
	
	//Player Size
	static final int WIDTH = 4;
	static final int HEIGHT = 10;
	//Player Movement Speed
	static final int SPEED = 1;
	
	/**
	 * Player object constructor
	 * @param _x The x position of the player
	 * @param _y The y position of the player
	 */
	public PlayerObject(int _x, int _y) 
	{
		super(_x, _y, WIDTH, HEIGHT);
	}
	
	//Sets the player's velocity
	public void MoveUp() { velocityY = -SPEED; }
	public void MoveDown() { velocityY = SPEED; }
	public void Stop() { velocityY = 0; }

}
