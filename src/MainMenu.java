import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;
import edu.digipen.text.FontTypes;
import edu.digipen.text.TextManager;
import edu.digipen.text.TextObject;

import java.awt.event.KeyEvent;

/**
 * Created by TestPro on 7/11/2018, updated 4/17/2022.
 */
public class MainMenu extends GameLevel
{

	@Override public void create()
	{
		TextObject title = new TextObject("GameTitle", "LAST STAND", FontTypes.FELIX_TITLING_64);
		title.setPosition(-150,300);

		TextObject goToInstructions = new TextObject("goToInstructions", "Press I for Controls and Instructions", FontTypes.TIMES_NEW_ROMAN_32);
		goToInstructions.setPosition(-165, 100);

		//Give a command prompt to start the game
		TextObject keyPrompt = new TextObject("enterPrompt", "Press Enter To Begin", FontTypes.TIMES_NEW_ROMAN_48);
		keyPrompt.setPosition(-150, -50);

		// Give a keyPrompt to exit the current game window
		TextObject leave = new TextObject("LeaveWindow", "Press ESC to Exit The Game", FontTypes.TIMES_NEW_ROMAN_32);
		leave.setPosition(-20, -250);

		//Give creator credit (@me)
		TextObject credit = new TextObject("Credits", "Made by: Daniel Prasetyo", FontTypes.ARIAL_16);
		credit.setPosition(-300, -270);

	}

	@Override public void initialize()
	{
		// Reset static variables to restart game level
		Obstacle.enemiesKilled = 0;
		Player.livesCounter = 4;
	}

	@Override public void update(float v)
	{
		if(InputManager.isPressed(KeyEvent.VK_ENTER))
		{
			//Start the game
			GameLevelManager.goToLevel(new Level1());
		}
		//Press ESC to exit the game
		if(InputManager.isPressed(KeyEvent.VK_ESCAPE))
		{
			Game.quit();
		}
		//Press ESC to exit the game
		if(InputManager.isPressed(KeyEvent.VK_I))
		{
			// Go to Instructions
			GameLevelManager.goToLevel(new Instructions());
		}
	}

	@Override public void uninitialize()
	{

	}
}
