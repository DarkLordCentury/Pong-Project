package field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ui.GameButton;
import ui.GameWindow;
import ui.PlayButton;
import ui.QuitButton;

public class MenuField {
	
	private GameButton playButton;
	private GameButton controlsButton;
	private GameButton quitButton;
	private List<GameButton> buttons;
	
	public MenuField(GameWindow _gameWindow)
	{
		playButton = new PlayButton("PLAY", _gameWindow.getWidth() / 2, 300);
		//controlsButton = new GameButton("CONTROLS", _gameWindow.getWidth() / 2, 400);
		quitButton = new QuitButton("LEAVE", _gameWindow.getWidth() / 2, 500);
		
		buttons = new ArrayList<GameButton>();
		buttons.add(playButton);
		//buttons.add(controlsButton);
		buttons.add(quitButton);
	}
	
	public GameButton getPlayButton() { return playButton; }
	public GameButton getControlsButton() { return controlsButton; }
	public GameButton getQuitButton() { return quitButton; }
	public List<GameButton> getButtons() { return Collections.unmodifiableList(buttons); }
	
}
