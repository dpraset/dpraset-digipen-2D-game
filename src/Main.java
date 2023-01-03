import edu.digipen.Game;
import edu.digipen.level.EmptyLevel;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;

public class Main
{

	public static void main(String[] args)
	{
		// Initialize Game Window
		Game.initialize(800,1000, 60, new MainMenu());

		//Create a game loop
		while(Game.getQuit() == false)
		{
			//Update the game for every frame
			Game.update();
		}

		//Destroy, cleanup, get rid of everything left by game when we stop playing
		Game.destroy();
	}
	// A top down game where you play as someone who is “moving forward” non-stop, and you must either
	// avoid or shoot/destroy the obstacles as they come at you. You can strafe left and right,
	// and move forward and backwards as well. Life counter. It will take several collisions, a shoot button,
	// kill the projectile when they exit the screen, movement, and several types of obstacles.
}
