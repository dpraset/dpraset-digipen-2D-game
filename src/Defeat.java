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
public class Defeat extends GameLevel
{
	@Override public void create()
	{

		// Show the player has lost, the word defeat, a bit of "story", and keyPrompts
		TextObject defeattitle = new TextObject("DefeatTitle", "DEFEAT", FontTypes.FELIX_TITLING_64);
		defeattitle.setPosition(-120,100);

		//TextObject failuretitle = new TextObject("FailureTitle", "You failed to hold back the enemy", FontTypes.ARIAL_32);
		//failuretitle.setPosition(-120, 270);

		TextObject failure2 = new TextObject("Fail2", "???: The unofficial story is that you fell in battle.", FontTypes.ARIAL_16);
		failure2.setPosition(-120, 280);

		TextObject failure3 = new TextObject("Fail3", "The hard truth is that the enemy took the castle, and that was the end of it.", FontTypes.ARIAL_16);
		failure3.setPosition(-120,260);

		TextObject failure4 = new TextObject("Fail4", "However, this isn't the end for you...", FontTypes.ARIAL_16);
		failure4.setPosition(-120,240);

		TextObject restart = new TextObject("VicReplay", "Press N to Restart", FontTypes.ARIAL_16);
		restart.setPosition(-120,20);

		TextObject quit = new TextObject("Quit", "Press ESC to quit the game", FontTypes.ARIAL_16);
		quit.setPosition(-130, 0);

		TextObject credit = new TextObject("Credits", "Made by: Daniel Prasetyo", FontTypes.ARIAL_16);
		credit.setPosition(-300, -270);
	}

	@Override public void initialize()
	{

	}

	@Override public void update(float v)
	{
		// Press N to return to main menu
		if(InputManager.isPressed(KeyEvent.VK_N))
		{
			// Return to Main Menu
			GameLevelManager.goToLevel(new MainMenu());
		}

		//Press ESC to exit the game
		if(InputManager.isPressed(KeyEvent.VK_ESCAPE))
		{
			Game.quit();
		}
	}

	@Override public void uninitialize()
	{

	}
}
