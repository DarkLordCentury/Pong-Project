package gameObjects;

import java.awt.Rectangle;

public abstract class MovingObject {
	
	//The x and y position of the object
	protected double x, y;
	//The size of the object
	protected int width, height;
	//The current velocity of the object
	protected int velocityX, velocityY;
	//Determines whether or not the object is visible to the user
	protected boolean isVisible;
	
	/**
	 * Constructor for moving object
	 * @param _width The objects width
	 * @param _height The objects height
	 */
	public MovingObject(double _x, double _y, int _width, int _height)
	{
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		velocityX = 0;
		velocityY = 0;
		isVisible = true;
	}
	
	/**
	 * Moves object by its velocity
	 * @param _timeDelta The time that has passed in seconds
	 */
	public void move(double _timeDelta)
	{
		x += (velocityX * _timeDelta);
		y += (velocityY * _timeDelta);
	}
	
	/**
	 * Checks if object is colliding with target object.
	 * @param _target The object you are testing collision with
	 * @return True if objects are colliding
	 */
	public boolean isColliding(MovingObject _target)
	{
		return this.getRectangle().intersects(_target.getRectangle());
	}
	
	/**
	 * Checks if object is above y position
	 * @param _y The desired y position
	 * @return True if object is above y position
	 */
	public boolean isAbove(int _y) { return getRectY() <= _y; }
	/**
	 * Checks if object is below y position
	 * @param _y The desired y position
	 * @return True if object is below y position
	 */
	public boolean isBelow(int _y) { return getRectY() + height >= _y; }
	/**
	 * Sets the position so that the top of the object is right above the desired y position
	 * @param _y The desired y position
	 */
	public void setPositionAbove(int _y) { y = _y - (height / 2) + 1; }
	/**
	 * Sets the position so that the top of the object is right below the desired y position
	 * @param _y The desired y position
	 */
	public void setPositionBelow(int _y) { y = _y + (height / 2) - 1; }
	
	//Getters
	public double getX() { return x; }
	public double getY() { return y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getVelocityX() { return velocityX; }
	public int getVelocityY() { return velocityY; }
	public boolean isVisible() { return isVisible; }
	//Returns the rectangle used for collision detection
	public double getRectX() { return x - (width / 2); }
	public double getRectY() { return y - (height / 2); }
	public Rectangle getRectangle() { return new Rectangle((int) getRectX(), (int) getRectY(), width, height); }
	
	//Setters
	public void setPosition(int _x, int _y) { x = _x; y = _y; }
	public void setVelocityX(int _velocityX) { velocityX = _velocityX; }
	public void setVelocityY(int _velocityY) { velocityY = _velocityY; }
	public void setVelocity(int _velocityX, int _velocityY) { velocityX = _velocityX; velocityY = _velocityY; }
	public void setVisible(boolean _isVisible) { isVisible = _isVisible; }
}
