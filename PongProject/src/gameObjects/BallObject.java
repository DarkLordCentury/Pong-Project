package gameObjects;

public class BallObject extends MovingObject{
	
	static final int WIDTH = 2;
	static final int HEIGHT = 2;
	
	public BallObject(int _x, int _y) {
		super(_x, _y, WIDTH, HEIGHT);
	}

}
