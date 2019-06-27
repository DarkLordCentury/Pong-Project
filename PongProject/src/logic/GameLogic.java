package logic;

import java.util.Random;
import java.util.Set;

import controllers.GameController;
import controllers.GameController.GAME_SCREEN;
import field.FieldHolder;
import field.GameField;
import gameObjects.BallObject;
import gameObjects.MovingObject;
import gameObjects.PlayerObject;
import gameObjects.PlayerObject.PLAYER_INDEX;
import ui.GameWindow;
import util.InputHolder;

public class GameLogic implements Logic{

	//When the ball resets and is given a random velocity, this is the max degree of its random velocity within one quadrant
	private final int BALL_RESET_DEGREE_MAX = 50;
	//When the ball resets, this is the full range of degrees the ball could be set to starting from the north bearing
	private final int BALL_RESET_DEGREE_FULL_RANGE = (BALL_RESET_DEGREE_MAX * 2);
	//After a player scored, this is the time in ms that must pass before the ball is reset
	private final int BALL_RESET_WAIT_TIME = 1500;
	//Holds the time in ms when a player scored their last point
	private long ballResetStartTime;
	//Holds the player that scored last (if this is null the ball has already been reset)
	private PlayerObject lastScoringPlayer;
	
	@Override
	public void doLogic(GameWindow _gameWindow, FieldHolder _field, InputHolder _inputs, double _timeDelta)
	{
		GameField gameField = _field.getGameField();
		
		//87 is w and 83 is s
		//38 is arrow up and 40 is arrow down
		checkPlayerInputs(_inputs.getPressedKeys(), gameField, gameField.getFirstPlayer(), 87, 83);
		checkPlayerInputs(_inputs.getPressedKeys(), gameField, gameField.getSecondPlayer(), 38, 40);
		
		checkBallCollision(gameField);
		checkScore(gameField);
		checkResetBall(gameField.getBall());
		
		for(MovingObject moving : gameField.getAllObjects())
			moving.move(_timeDelta);
		
		checkObjectBounds(gameField, gameField.getFirstPlayer());
		checkObjectBounds(gameField, gameField.getSecondPlayer());
		checkObjectBounds(gameField, gameField.getBall());
		
		checkWinCondition(_field.getGameField());
	}
	
	//Moves the player depending on the inputs
	private void checkPlayerInputs(Set<Integer> _inputs, GameField _gameField, PlayerObject _player, int _up, int _down)
	{
		if(_inputs.contains(_up) && !_player.isAbove(0))
			_player.moveUp();
		else if(_inputs.contains(_down) && !_player.isBelow(_gameField.getHeight()))
			_player.moveDown();
		else
			_player.stop();
	}
	
	/**
	 * Checks if the object hits the top or bottom bounds
	 * @param _gameField The game field
	 * @param _object The desired object
	 */
	private void checkObjectBounds(GameField _gameField, MovingObject _object)
	{
		if(_object.isAbove(0))
			_object.setPositionBelow(0);
		else if(_object.isBelow(_gameField.getHeight()))
			_object.setPositionAbove(_gameField.getHeight());
	}
	
	//Checks ball collision
	private void checkBallCollision(GameField _gameField)
	{
		BallObject ball = _gameField.getBall();
		//Checks if ball is colliding with players.
		if(ball.isColliding(_gameField.getFirstPlayer()))
			ball.bouncePlayer(_gameField.getFirstPlayer());
		else if(ball.isColliding(_gameField.getSecondPlayer()))
			ball.bouncePlayer(_gameField.getSecondPlayer());
		
		//Checks if ball is hitting top and bottom limits
		if(ball.isAbove(0))
			ball.bounceDown();
		else if (ball.isBelow(_gameField.getHeight()))
			ball.bounceUp();
	}
	
	//Checks the score
	private void checkScore(GameField _gameField)
	{
		BallObject ball = _gameField.getBall();
		
		if(ball.isLeftOf(0))
			startResetBall(_gameField, ball, _gameField.getSecondPlayer());
		else if(ball.isRightOf(_gameField.getWidth()))
			startResetBall(_gameField, ball, _gameField.getFirstPlayer());
	}
	
	/**
	 * Starts to reset the ball
	 * @param _gameField The game field
	 * @param _ball The ball
	 * @param _scoringPlayer The player who scored
	 */
	private void startResetBall(GameField _gameField, BallObject _ball, PlayerObject _scoringPlayer)
	{
		_scoringPlayer.alterScore(1);
		lastScoringPlayer = _scoringPlayer;
		ballResetStartTime = System.currentTimeMillis();
		_ball.setVisible(false);
		_ball.setPosition((_gameField.getWidth() / 2) - (_ball.getWidth() / 2), (_gameField.getHeight() / 2) - (_ball.getWidth() / 2));
		_ball.setVelocity(0, 0);
	}
	
	/**
	 * Resets the ball after enough time has passed
	 * @param _ball The ball
	 */
	private void checkResetBall(BallObject _ball)
	{
		if(lastScoringPlayer != null && (System.currentTimeMillis() - ballResetStartTime) > BALL_RESET_WAIT_TIME)
		{
			//Random Number Generator
			Random ran = new Random();
			double degreePercent = ran.nextDouble();
			int desiredAngle = (int) (BALL_RESET_DEGREE_FULL_RANGE * degreePercent)  + (90 - BALL_RESET_DEGREE_MAX);
			
			//Switches directions if it is the second player
			if(lastScoringPlayer.getPlayerIndex() == PLAYER_INDEX.SECOND_PLAYER)
				desiredAngle = 360 - desiredAngle;
			
			//Sets the ball to the desired angle
			_ball.setToDegree(desiredAngle);
			_ball.setVisible(true);
			lastScoringPlayer = null;
		}
	}
	
	//Changes screen to win screen if player has won
	private void checkWinCondition(GameField _gameField)
	{
		if(_gameField.getFirstPlayer().getScore() >= GameField.getWinningScore() || _gameField.getSecondPlayer().getScore() >= GameField.getWinningScore())
		{
			GameController.getInstance().setGameScreen(GAME_SCREEN.WINNING_SCREEN);
			lastScoringPlayer = null;
		}
	}
	
}
