import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.graphics.Graphics;
import edu.digipen.math.PFRandom;
import edu.digipen.math.Vec2;

/**
 * Created by TestPro on 7/10/2018, updated 4/17/2022.
 */
public class Obstacle extends GameObject
{
	public Vec2 direction_;
	// DISCLAIMER: THE NAME OF THIS CLASS WAS NAMED BEFORE I CHANGED THE "Obstacle"

	//Keep track of the enemies killed
	public static int enemiesKilled = 0;


	public Obstacle()
	{
		//reset the collision parameters so it isn't to big and they will be killed when projectile isn't very close to them
		super("Obstacle", 32, 64, "enemy.png");
		setRectangleCollider(8,16);
		direction_ = new Vec2();

		//make it so they come downwards towards player, vary in speed
		direction_.setY(PFRandom.randomRange(-.3f, -1.3f));
	}

	@Override
	//update every frame
	public void update(float dt)
	{
		//Get the player from the object manager
		GameObject player = ObjectManager.getGameObjectByName("Player");

		// Compute the vector from the enemy to the player
		Vec2 vector = new Vec2();
		vector.setX(player.getPositionX() - getPositionX());
		vector.setY(player.getPositionY() - getPositionY());

		//normal
		vector.normalize();

		//Use the vector to move the enemy to the player, homing to try and "kill" the player
		setPositionX(getPositionX() + vector.getX());
		setPositionY(getPositionY() + vector.getY());


		//set the x,y position of the enemy
		setPositionX(getPositionX() + direction_.getX());
		setPositionY(getPositionY() + direction_.getY());

		float heightOverTwo = getHeight() / 2.0f;
		float windowHeightOverTwo = Graphics.getWindowHeight()/2;

		// Makes it so when your enemy goes past the boundaries of the screen, it reappears
		// on the opposite side of the screen

		if(getPositionY() > windowHeightOverTwo + heightOverTwo)
		{
		//	setPositionY(-windowHeightOverTwo - heightOverTwo);
		}

		if(getPositionY() < -windowHeightOverTwo - heightOverTwo)
		{
			setPositionY(windowHeightOverTwo + heightOverTwo);
		}
	}
}

