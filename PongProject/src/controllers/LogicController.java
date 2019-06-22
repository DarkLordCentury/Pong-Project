package controllers;

import java.util.Set;

import field.Field;
import gameObjects.MovingObject;
import gameObjects.PlayerObject;


public class LogicController {
	
	public void DoLogic(Field _field, Set<Integer> _inputs)
	{
		checkPlayerInputs(_inputs, _field.getFirstPlayer(), 87, 83);
		checkPlayerInputs(_inputs, _field.getSecondPlayer(), 38, 40);
		
		for(MovingObject moving : _field.getAllObjects())
			moving.move();
	}
	
	public void checkPlayerInputs(Set<Integer> _inputs, PlayerObject _player, int _up, int _down)
	{
		if(_inputs.contains(_up))
			_player.moveUp();
		else if(_inputs.contains(_down))
			_player.moveDown();
		else
			_player.stop();
	}
	

}
