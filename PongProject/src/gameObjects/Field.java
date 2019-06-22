package gameObjects;

import java.util.ArrayList;
import java.util.List;

public class Field {
	
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	
	PlayerObject firstPlayer;
	PlayerObject secondPlayer;
	BallObject ball;
	List<MovingObject> movingObjects;
	
	public Field()
	{
		firstPlayer = new PlayerObject(10, (HEIGHT / 2) - PlayerObject.HEIGHT);
		secondPlayer = new PlayerObject(750, (HEIGHT / 2) - PlayerObject.HEIGHT);
		ball = new BallObject(WIDTH / 2 - 1, HEIGHT / 2 - 1);
		
		movingObjects = new ArrayList<MovingObject>();
		movingObjects.add(firstPlayer);
		movingObjects.add(secondPlayer);
		movingObjects.add(ball);
	}
	
	//Getters
	public int GetWidth() { return WIDTH; }
	public int GetHeight() { return HEIGHT; }
	
	public PlayerObject GetFirstPlayer() { return firstPlayer; }
	public PlayerObject GetSecondPlayer() { return secondPlayer; }
	public BallObject GetBall() { return ball; }
	public List<MovingObject> GetAllObjects() { return movingObjects; }

}
