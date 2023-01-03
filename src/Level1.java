import edu.digipen.Game;
import edu.digipen.SoundManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;
import edu.digipen.math.PFRandom;
import edu.digipen.text.FontTypes;
import edu.digipen.text.TextManager;
import edu.digipen.text.TextObject;

import java.util.Random;

/**
 * Created by TestPro on 7/10/2018, updated 4/17/2022.
 */
public class Level1 extends GameLevel
{
	float timer = 0;

	// Create anything that doesn't need to be reset when you restart the level
	@Override public void create()
	{
		//INSERT A BACKGROUND THING AND ART

		GameObject background = new GameObject("Bridge", 800, 620, "Bridge.png");

		// Create and spawn in player
		GameObject player = new Player();
		player.setPosition(1,-260);
		ObjectManager.addGameObject(player);

		// Bit of warning before enemies start coming
		TextObject prep = new TextObject("Prepare", "PREPARE FOR BATTLE", FontTypes.ARIAL_32);
		prep.setPosition(-150,200);


		//set random loaction spawning points for 120 enemies
		for(int i = 0; i < 120; i++)
		{
			GameObject enemy1 = new Obstacle();
			//										      X								Y
			enemy1.setPosition(PFRandom.randomRange(-180, 180), PFRandom.randomRange(1500, 11000));
			ObjectManager.addGameObject(enemy1);
		}

		SoundManager.addSoundEffect("killen", "enemykilled.wav");
		SoundManager.addSoundEffect("injured", "playerhit.wav");
	}

	@Override public void initialize()
	{

	}

	@Override public void update(float dt)
	{
		//Display Prepare for 5 seconds, after that, the enemies will come

		timer += dt;
		if(timer >= 3)
		{
			//gets rid of the text
			TextManager.removeAllTextObjects();
		}

		if(Obstacle.enemiesKilled >= 150)
		{
			// When you kill 75+ enemies, you win
			//if you kill amount of enemies, display victory level
			GameLevelManager.goToLevel(new VictoryLevel());
		}

		//When your life counter is gone, you die and get victory screen
		if(Player.livesCounter <= 0)
		{
			GameLevelManager.goToLevel(new Defeat());
		}
	}

	@Override public void uninitialize()
	{

	}
	float getRandomValue(float min, float max)
	{
		// Create an instance Random class
		Random rand = new Random();

		return rand.nextFloat() * (max - min) + min;
	}
}
