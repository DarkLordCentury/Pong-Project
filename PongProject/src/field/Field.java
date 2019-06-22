package field;

import java.util.ArrayList;
import java.util.List;

import gameObjects.BallObject;
import gameObjects.MovingObject;
import gameObjects.PlayerObject;
import gameObjects.PlayerObject.PLAYER_INDEX;

public class Field {
	
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	
	PlayerObject firstPlayer;
	PlayerObject secondPlayer;
	BallObject ball;
	List<MovingObject> movingObjects;
	
	public Field()
	{
		firstPlayer = new PlayerObject(PLAYER_INDEX.FIRST_PLAYER);
		firstPlayer.setPosition(10, (HEIGHT / 2) - (firstPlayer.getHeight() / 2));
		secondPlayer = new PlayerObject(PLAYER_INDEX.SECOND_PLAYER);
		secondPlayer.setPosition(WIDTH - 10 - secondPlayer.getWidth(), (HEIGHT / 2) - (secondPlayer.getHeight() / 2));
		ball = new BallObject();
		ball.setPosition((WIDTH / 2) - (ball.getWidth() / 2), (HEIGHT / 2) - (ball.getWidth() / 2));
		
		movingObjects = new ArrayList<MovingObject>();
		movingObjects.add(firstPlayer);
		movingObjects.add(secondPlayer);
		movingObjects.add(ball);
	}
	
	//Getters
	public int getWidth() { return WIDTH; }
	public int getHeight() { return HEIGHT; }
	
	public PlayerObject getFirstPlayer() { return firstPlayer; }
	public PlayerObject getSecondPlayer() { return secondPlayer; }
	public BallObject fetBall() { return ball; }
	public List<MovingObject> getAllObjects() { return movingObjects; }

}
