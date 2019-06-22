package gameObjects;

public class BallObject extends MovingObject{
	
	static final int WIDTH = 10;
	static final int HEIGHT = 10;
	static final int SPEED = 1;
	
	public BallObject() {
		super(WIDTH, HEIGHT);
	}
	
	/**If the ball is going down make it go up*/
	public void bounceUp() { if(velocityY > 0) velocityY = -velocityY; }
	/**If the ball is going up make it go down*/
	public void bounceDown() { if(velocityY < 0) velocityY = -velocityY; }
	/**
	 * Bounces the ball when the ball collides with the player
	 * @param _player Player ball is colliding with
	 */
	public void bouncePlayer(PlayerObject _player)
	{
		
	}
}
