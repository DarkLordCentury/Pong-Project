package gameObjects;

import java.awt.Rectangle;

public abstract class MovingObject {
	
	//The x and y position of the object
	int x, y;
	//The size of the object
	int width, height;
	//The current velocity of the object
	int velocityX, velocityY;
	
	/**
	 * Constructor for moving object
	 * @param _x The object's x position on the field
	 * @param _y The object's y position on the field
	 * @param _width The objects width
	 * @param _height The objects height
	 */
	public MovingObject(int _x, int _y, int _width, int _height)
	{
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		velocityX = 0;
		velocityY = 0;
	}
	
	/**
	 * Moves object by its velocity
	 */
	public void Move()
	{
		x += velocityX;
		y += velocityY;
	}
	
	/**
	 * Checks if object is colliding with target object.
	 * @param _target The object you are testing collision with
	 * @return True if objects are colliding
	 */
	public boolean IsColliding(MovingObject _target)
	{
		return this.GetRectangle().intersects(_target.GetRectangle());
	}
	
	//Getters
	public int GetX() { return x; }
	public int GetY() { return y; }
	public int GetWidth() { return width; }
	public int GetHeight() { return height; }
	public int GetVelocityX() { return velocityX; }
	public int GetVelocityY() { return velocityY; }
	//Returns the rectangle used for collision detection
	public Rectangle GetRectangle() { return new Rectangle(x, y, width, height); }
	
	//Setters
	public void SetVelocityX(int _velocityX) { velocityX = _velocityX; }
	public void SetVelocityY(int _velocityY) { velocityY = _velocityY; }
	public void SetVelocity(int _velocityX, int _velocityY) { velocityX = _velocityX; velocityY = _velocityY; }
}
