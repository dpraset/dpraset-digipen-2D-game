import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;
import edu.digipen.text.FontTypes;
import edu.digipen.text.TextObject;

import java.awt.event.KeyEvent;

/**
 * Created by TestPro on 7/11/2018, updated 4/17/2022.
 */
public class VictoryLevel extends GameLevel
{
	@Override public void create()
	{
		// Display that the player has won this level, VICTORY, end level "story" and keyPrompts

		TextObject vicWords = new TextObject("VictoryWords", "???: You did it. Against all odds, you managed to make a last stand against the enemy.", FontTypes.ARIAL_16);
		vicWords.setPosition(-150, 250);

		TextObject vicWords2 = new TextObject("VicWords", "The enemy suffered heavy loses, and ordered a retreat.", FontTypes.ARIAL_16);
		vicWords2.setPosition(-150, 230);

		TextObject vicWords3 = new TextObject("VicWords2", "All thanks to you. Good work soldier.", FontTypes.ARIAL_16);
		vicWords3.setPosition(-130, 210);

		TextObject won = new TextObject("VictoryTitle", "Victory", FontTypes.FELIX_TITLING_64);
		won.setPosition(-100,80);

		TextObject replay = new TextObject("VicReplay", "Press N to Replay", FontTypes.FELIX_TITLING_48);
		replay.setPosition(-100,20);

		TextObject quit = new TextObject("Quit", "Press ESC to quit the game", FontTypes.FELIX_TITLING_32);
		quit.setPosition(-100, -20);

		TextObject credit = new TextObject("Credited", "Made by: Daniel Prasetyo", FontTypes.ARIAL_16);
		credit.setPosition(-300, -270);

	}

	@Override public void initialize()
	{

	}

	@Override public void update(float v)
	{
		//Press N to return to MainMenu
		if(InputManager.isPressed(KeyEvent.VK_N))
		{
			// Return to Main Menu
			GameLevelManager.goToLevel(new MainMenu());
			//reset static variables
		}

		//Press ESC to quit the game window
		if(InputManager.isPressed(KeyEvent.VK_ESCAPE))
		{
			Game.quit();
		}


	}

	@Override public void uninitialize()
	{

	}
}
