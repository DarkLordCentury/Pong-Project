package gameObjects;

import java.awt.Rectangle;

public abstract class MovingObject {
	
	//The x and y position of the object
	protected int x, y;
	//The size of the object
	protected int width, height;
	//The current velocity of the object
	protected int velocityX, velocityY;
	
	/**
	 * Constructor for moving object
	 * @param _width The objects width
	 * @param _height The objects height
	 */
	public MovingObject(int _width, int _height)
	{
		width = _width;
		height = _height;
		x = 0;
		y = 0;
		velocityX = 0;
		velocityY = 0;
	}
	
	/**
	 * Moves object by its velocity
	 */
	public void move()
	{
		x += velocityX;
		y += velocityY;
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
	
	//Getters
	public int getX() { return x; }
	public int getY() { return y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getVelocityX() { return velocityX; }
	public int getVelocityY() { return velocityY; }
	//Returns the rectangle used for collision detection
	public Rectangle getRectangle() { return new Rectangle(x, y, width, height); }
	
	//Setters
	public void setPosition(int _x, int _y) { x = _x; y = _y; }
	public void setVelocityX(int _velocityX) { velocityX = _velocityX; }
	public void setVelocityY(int _velocityY) { velocityY = _velocityY; }
	public void setVelocity(int _velocityX, int _velocityY) { velocityX = _velocityX; velocityY = _velocityY; }
}
