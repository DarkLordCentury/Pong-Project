package gameObjects;

import gameObjects.PlayerObject.PLAYER_INDEX;

public class BallObject extends MovingObject{
	
	static final int WIDTH = 10;
	static final int HEIGHT = 10;
	static final int SPEED = 330;
	
	public BallObject(int _x, int _y) {
		super(_x, _y, WIDTH, HEIGHT);
	}
	
	/**
	 * Checks if ball is to the right of the desired x position
	 * @param _x The desired x position
	 * @return True if the ball is to the right of the x position
	 */
	public boolean isRightOf(int _x) { return x > _x; }
	/**
	 * Checks if ball is to the left of the desired x position
	 * @param _x The desired x position
	 * @return True if the ball is to the left of the x position
	 */
	public boolean isLeftOf(int _x) { return (x - WIDTH) < _x; }
	
	/**If the ball is going down make it go up*/
	public void bounceUp() { if(velocityY > 0) velocityY = -velocityY; }
	/**If the ball is going up make it go down*/
	public void bounceDown() { if(velocityY < 0) velocityY = -velocityY; }
	/**
	 * Bounces the ball when the ball collides with the player. The ball's direction depends on where it
	 * collides with the player.
	 * @param _player Player ball is colliding with
	 */
	public void bouncePlayer(PlayerObject _player)
	{
		//The area leftover when the player and ball collide
		int collisionPossibilitySize = _player.getHeight() + this.height;
		double collisionSize = this.getRectY() - (_player.getRectY() - this.height);
		double collisionPercent = (double) collisionSize / collisionPossibilitySize;
		
		//The max degree the ball's direction will be for one half
		int degreeMax = 60;
		int degreePossibility = degreeMax * 2;
		int desiredDegree = (int) (degreePossibility * collisionPercent) + (90 - degreeMax);
		
		//Reverses direction if player two
		if(_player.getPlayerIndex() == PLAYER_INDEX.SECOND_PLAYER)
			desiredDegree = 360 - desiredDegree;
		
		//Sets the ball to the desired degree
		setToDegree(desiredDegree);
	}
	
	/**
	 * Sets the ball's velocity according to its speed and the desired angle
	 * @param _angle The desired angle in degrees from the north bearing
	 */
	public void setToDegree(int _angle)
	{
		double radians = Math.toRadians(_angle);
		double sin = SPEED * Math.sin(radians);
		double cos = SPEED * Math.cos(radians);
		
		velocityX = (int) sin;
		velocityY = (int) -cos;
	}
}
