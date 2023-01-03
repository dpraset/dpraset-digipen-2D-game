import edu.digipen.SoundManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

/**
 * Created by TestPro on 7/10/2018, updated 4/17/2022.
 */
public class Projectile extends GameObject
{
	public Vec2 direction_;

	public Projectile(Vec2 direction, Vec2 location)
	{

		//set projectile to throw a sword/knife, goes in direction that player is facing, in this game, it is North, always
		super("BaseProjectile", 100, 200, "sword.png");
		setRectangleCollider(10,20);
		direction_ = new Vec2();
		direction_.setX(direction.getX());
		direction_.setY(direction.getY());
		setScale(0.2f, 0.2f);
		setPosition(location);
	}

	@Override public void update(float dt)
	{
		//Increase the speed by 2, not too fast, but not overly slow
		setPositionX(getPositionX() + direction_.getX() * 2);
		setPositionY(getPositionY() + direction_.getY() * 2);

		//If projectiles shot isn't in window, the projectile is killed
		if (isInViewport() == false)
		{
			kill();
		}

	}

	@Override public void collisionReaction(GameObject collideWith)
	{
		//Check if sword collides with an enemy
		if (collideWith.getName().equals("Obstacle"))
		{
			//kills obstacle whenever they collide
			collideWith.kill();
			kill();

			//Play the sound when an enemy is killed
			SoundManager.playSoundEffect("killen");

			//Count for each enemy killed
			Obstacle.enemiesKilled++;

		}

	}
}
