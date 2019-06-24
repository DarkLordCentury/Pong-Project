package controllers;

import java.util.Random;
import java.util.Set;

import field.GameField;
import gameObjects.BallObject;
import gameObjects.MovingObject;
import gameObjects.PlayerObject;
import gameObjects.PlayerObject.PLAYER_INDEX;


public class LogicController {
	
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
	
	public void DoLogic(GameField _field, Set<Integer> _inputs)
	{
		checkPlayerInputs(_inputs, _field, _field.getFirstPlayer(), 87, 83);
		checkPlayerInputs(_inputs, _field, _field.getSecondPlayer(), 38, 40);
		
		checkBallCollision(_field);
		checkScore(_field);
		checkResetBall(_field.getBall());
		
		for(MovingObject moving : _field.getAllObjects())
			moving.move();
	}
	
	private void checkPlayerInputs(Set<Integer> _inputs, GameField _field, PlayerObject _player, int _up, int _down)
	{
		if(_inputs.contains(_up) && !_player.isAbove(0))
			_player.moveUp();
		else if(_inputs.contains(_down) && !_player.isBelow(_field.getHeight()))
			_player.moveDown();
		else
			_player.stop();
	}
	
	private void checkBallCollision(GameField _field)
	{
		BallObject ball = _field.getBall();
		//Checks if ball is colliding with players.
		if(ball.isColliding(_field.getFirstPlayer()))
			ball.bouncePlayer(_field.getFirstPlayer());
		else if(ball.isColliding(_field.getSecondPlayer()))
			ball.bouncePlayer(_field.getSecondPlayer());
		
		//Checks if ball is hitting top and bottom limits
		if(ball.isAbove(0))
			ball.bounceDown();
		else if (ball.isBelow(_field.getHeight()))
			ball.bounceUp();
	}
	
	private void checkScore(GameField _field)
	{
		BallObject ball = _field.getBall();
		
		if(ball.isLeftOf(0))
			startResetBall(_field, ball, _field.getSecondPlayer());
		else if(ball.isRightOf(_field.getWidth()))
			startResetBall(_field, ball, _field.getFirstPlayer());
	}
	
	private void startResetBall(GameField _field, BallObject _ball, PlayerObject _scoringPlayer)
	{
		//System.out.println("RESET: " + _scoringPlayer.getPlayerIndex());
		_scoringPlayer.alterScore(1);
		lastScoringPlayer = _scoringPlayer;
		ballResetStartTime = System.currentTimeMillis();
		_ball.setVisible(false);
		_ball.setPosition((_field.getWidth() / 2) - (_ball.getWidth() / 2), (_field.getHeight() / 2) - (_ball.getWidth() / 2));
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

}
