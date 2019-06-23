package controllers;

import java.util.Set;

import field.GameField;
import gameObjects.BallObject;
import gameObjects.MovingObject;
import gameObjects.PlayerObject;


public class LogicController {
	
	public void DoLogic(GameField _field, Set<Integer> _inputs)
	{
		checkPlayerInputs(_inputs, _field, _field.getFirstPlayer(), 87, 83);
		checkPlayerInputs(_inputs, _field, _field.getSecondPlayer(), 38, 40);
		
		checkBallCollision(_field);
		
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

}
