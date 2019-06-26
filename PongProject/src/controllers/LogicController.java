package controllers;

import java.util.HashMap;
import java.util.Map;

import controllers.GameController.GAME_SCREEN;
import field.FieldHolder;
import logic.GameLogic;
import logic.Logic;
import logic.MenuLogic;
import logic.WinningLogic;
import util.InputHolder;


public class LogicController {

	private Map<GAME_SCREEN, Logic> logic;
	
	public LogicController()
	{
		//Instantiates the logic and populates the hashmap
		logic = new HashMap<GAME_SCREEN, Logic>();
		logic.put(GAME_SCREEN.GAME, new GameLogic());
		logic.put(GAME_SCREEN.MENU, new MenuLogic());
		logic.put(GAME_SCREEN.WINNING_SCREEN, new WinningLogic());
	}
	
	/**
	 * Runs the logic within the current screen
	 * @param _currGameScreen The current screen
	 * @param _field The game fields
	 * @param _inputs The user inputs
	 */
	public void doLogic(GAME_SCREEN _currGameScreen, FieldHolder _field, InputHolder _inputs, double _timeDelta)
	{
		if(logic.containsKey(_currGameScreen))
			logic.get(_currGameScreen).doLogic(_field, _inputs, _timeDelta);
	}
	
	

}
