import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;
import edu.digipen.text.FontTypes;
import edu.digipen.text.TextObject;

import java.awt.event.KeyEvent;

/**
 * Created by TestPro on 7/13/2018, updated 4/17/2022.
 */
public class Instructions extends GameLevel
{

	@Override public void create()
	{
		TextObject instructTitle = new TextObject("InstructionTitle", "Controls and Instructions", FontTypes.FELIX_TITLING_48);
		instructTitle.setPosition(-300,300);

		// Display the instructions to the player
		TextObject controls = new TextObject("instructionsControls", "Use A and D as well as the left and right arrows to strafe",
				FontTypes.TIMES_NEW_ROMAN_32);
		controls.setPosition(-300, 100);

		TextObject shootcontrols = new TextObject("shootControls", "Use SPACE to throw your weapon",
				FontTypes.TIMES_NEW_ROMAN_32);
		shootcontrols.setPosition(-160, 50);

		TextObject lifehelp = new TextObject("LivesHelp", "You can take 3 hits before it's game over", FontTypes.TIMES_NEW_ROMAN_32);
		lifehelp.setPosition(-170,20);

		TextObject obj = new TextObject("Objective1", "Victory will be yours when ", FontTypes.TIMES_NEW_ROMAN_32);
		obj.setPosition(-140,-50);
		TextObject obj2 = new TextObject("Objective2", " a set number of enemies have been defeated", FontTypes.TIMES_NEW_ROMAN_32);
		obj2.setPosition(-220, -80);

		TextObject returnMain = new TextObject("returnMain", "Press BACKSPACE to go back", FontTypes.TIMES_NEW_ROMAN_32);
		returnMain.setPosition(-330, -220);
	}

	@Override public void initialize()
	{

	}

	@Override public void update(float v)
	{
		//Press Backspace to return to main
		if(InputManager.isPressed(KeyEvent.VK_BACK_SPACE))
		{
			// Return to Main Menu
			GameLevelManager.goToLevel(new MainMenu());
		}
	}

	@Override public void uninitialize()
	{

	}
}
