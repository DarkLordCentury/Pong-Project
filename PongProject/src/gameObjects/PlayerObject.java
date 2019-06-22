package gameObjects;

public class PlayerObject extends MovingObject{
	
	//Player Size
	static final int WIDTH = 4;
	static final int HEIGHT = 10;
	//Player Movement Speed
	static final int SPEED = 1;
	
	public PlayerObject() 
	{
		super(WIDTH, HEIGHT);
	}
	
	//Sets the player's velocity
	public void moveUp() { velocityY = -SPEED; }
	public void moveDown() { velocityY = SPEED; }
	public void stop() { velocityY = 0; }

}
