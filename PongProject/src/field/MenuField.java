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
	private GameButton quitButton;
	private List<GameButton> buttons;
	
	public MenuField(GameWindow _gameWindow)
	{
		playButton = new PlayButton("PLAY", (int) (_gameWindow.getPreferredSize().getWidth() / 2), 325, 100);
		quitButton = new QuitButton("LEAVE", (int) (_gameWindow.getPreferredSize().getWidth() / 2), 475, 100);
		
		buttons = new ArrayList<GameButton>();
		buttons.add(playButton);
		buttons.add(quitButton);
	}
	
	public GameButton getPlayButton() { return playButton; }
	public GameButton getQuitButton() { return quitButton; }
	public List<GameButton> getButtons() { return Collections.unmodifiableList(buttons); }
	
}
