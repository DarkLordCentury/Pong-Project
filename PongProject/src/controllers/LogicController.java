package controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import controllers.GameController.GAME_SCREEN;
import gameObjects.GameField;
import logic.GameLogic;


public class LogicController {
	
	private Map<GAME_SCREEN, GameLogic> logic;
	
	public LogicController()
	{
		logic = new HashMap<GAME_SCREEN, GameLogic>();
	}
	
	public void doLogic(GAME_SCREEN _currGameScreen, GameField _field, Set<Integer> _inputs)
	{
		gameLogic.doLogic(_field, _inputs);
	}
	
	

}
