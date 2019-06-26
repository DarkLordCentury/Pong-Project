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
	public void doLogic(FieldHolder _field, InputHolder _inputs)
	{
		GameField gameField = _field.getGameField();
		
		checkPlayerInputs(_inputs.getPressedKeys(), gameField, gameField.getFirstPlayer(), 87, 83);
		checkPlayerInputs(_inputs.getPressedKeys(), gameField, gameField.getSecondPlayer(), 38, 40);
		
		checkBallCollision(gameField);
		checkScore(gameField);
		checkResetBall(gameField.getBall());
		
		checkWinCondition(_field.getGameField());
		
		for(MovingObject moving : gameField.getAllObjects())
			moving.move();
	}
	
	private void checkPlayerInputs(Set<Integer> _inputs, GameField _gamefield, PlayerObject _player, int _up, int _down)
	{
		if(_inputs.contains(_up) && !_player.isAbove(0))
			_player.moveUp();
		else if(_inputs.contains(_down) && !_player.isBelow(_gamefield.getHeight()))
			_player.moveDown();
		else
			_player.stop();
	}
	
	private void checkBallCollision(GameField _gamefield)
	{
		BallObject ball = _gamefield.getBall();
		//Checks if ball is colliding with players.
		if(ball.isColliding(_gamefield.getFirstPlayer()))
			ball.bouncePlayer(_gamefield.getFirstPlayer());
		else if(ball.isColliding(_gamefield.getSecondPlayer()))
			ball.bouncePlayer(_gamefield.getSecondPlayer());
		
		//Checks if ball is hitting top and bottom limits
		if(ball.isAbove(0))
			ball.bounceDown();
		else if (ball.isBelow(_gamefield.getHeight()))
			ball.bounceUp();
	}
	
	private void checkScore(GameField _gamefield)
	{
		BallObject ball = _gamefield.getBall();
		
		if(ball.isLeftOf(0))
			startResetBall(_gamefield, ball, _gamefield.getSecondPlayer());
		else if(ball.isRightOf(_gamefield.getWidth()))
			startResetBall(_gamefield, ball, _gamefield.getFirstPlayer());
	}
	
	private void startResetBall(GameField _gamefield, BallObject _ball, PlayerObject _scoringPlayer)
	{
		//System.out.println("RESET: " + _scoringPlayer.getPlayerIndex());
		_scoringPlayer.alterScore(1);
		lastScoringPlayer = _scoringPlayer;
		ballResetStartTime = System.currentTimeMillis();
		_ball.setVisible(false);
		_ball.setPosition((_gamefield.getWidth() / 2) - (_ball.getWidth() / 2), (_gamefield.getHeight() / 2) - (_ball.getWidth() / 2));
		_ball.setVelocity(0, 0);
	}
	
	private void checkResetBall(BallObject _ball)
	{
		if(lastScoringPlayer != null && (System.currentTimeMillis() - ballResetStartTime) > BALL_RESET_WAIT_TIME)
		{
			//Random Number Generator
			Random ran = new Random();
			double degreePercent = ran.nextDouble();
			int desiredAngle = (int) (BALL_RESET_DEGREE_FULL_RANGE * degreePercent)  + (90 - BALL_RESET_DEGREE_MAX);
			
			if(lastScoringPlayer.getPlayerIndex() == PLAYER_INDEX.SECOND_PLAYER)
				desiredAngle = 360 - desiredAngle;
			
			_ball.setToDegree(desiredAngle);
			_ball.setVisible(true);
			lastScoringPlayer = null;
		}
	}
	
	private void checkWinCondition(GameField _gameField)
	{
		if(_gameField.getFirstPlayer().getScore() >= GameField.getWinningScore() || _gameField.getSecondPlayer().getScore() >= GameField.getWinningScore())
			GameController.getInstance().setGameScreen(GAME_SCREEN.WINNING_SCREEN);
	}
	
}
