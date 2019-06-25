package controllers;

import java.util.Set;

import controllers.GameController.GAME_SCREEN;
import field.GameField;
import logic.GameLogic;


public class LogicController {
	
	private GameLogic gameLogic;
	
	public LogicController()
	{
		gameLogic = new GameLogic();
	}
	
	public void doLogic(GAME_SCREEN _currGameScreen, GameField _field, Set<Integer> _inputs)
	{
		gameLogic.doLogic(_currGameScreen, _field, _inputs);
	}
	
	

}
