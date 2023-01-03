import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.SoundManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.graphics.Graphics;
import edu.digipen.math.Vec2;

import java.awt.event.KeyEvent;

/**
 * Created by TestPro on 7/10/2018, updated 4/17/2022.
 */
public class Player extends GameObject
{
	//set the direction ship goes in, rotation and movement speed, and 5 lives
	public Vec2 direction = new Vec2(0.0f, 1.0f);
	public float movementSpeed = 1.0f;
	public static int livesCounter = 4;

	public Player()
		{
			super("Player", 80, 120, "Person.png");
			setRectangleCollider(40,60);
		}

		@Override public void update(float dt)
		{
			//will always face north, no rotation, strafe left and right

			//Strafe right
			if(InputManager.isPressed(KeyEvent.VK_A))
			{
				float x = getPositionX();
				x-=3;
				setPositionX(x);
			}
			if(InputManager.isPressed(KeyEvent.VK_LEFT))
			{
				float x = getPositionX();
				x-=3;
				setPositionX(x);
			}


			if(InputManager.isPressed(KeyEvent.VK_D))
			{
				float x = getPositionX();
				x+=3;
				setPositionX(x);
			}
			if(InputManager.isPressed(KeyEvent.VK_RIGHT))
			{
				float x = getPositionX();
				x+=3;
				setPositionX(x);
			}
			//shoot button
			if(InputManager.isTriggered(KeyEvent.VK_SPACE))
			{
				shoot();

			}


			//SCREEN WRAPPING
			float widthOverTwo = getWidth() / 2.0f;
			float heightOverTwo = getHeight() / 2.0f;
			float windowWidthOverTwo = Graphics.getWindowWidth()/2;
			float windowHeightOverTwo = Graphics.getWindowHeight()/2;

			// Makes it so when your person goes to the right side of screen, it cannot appear on other side
			//so player cannot cheese the system by strafing back and forth
			if(getPositionX() > windowWidthOverTwo - widthOverTwo)
			{
				setPositionX(windowWidthOverTwo - widthOverTwo);
			}

			if(getPositionX() < -windowWidthOverTwo + widthOverTwo)
			{
				setPositionX(-windowWidthOverTwo + widthOverTwo);
			}

			if(getPositionY() > windowHeightOverTwo - heightOverTwo)
			{
				setPositionY(windowHeightOverTwo - heightOverTwo);
			}

			if(getPositionY() < -windowHeightOverTwo + heightOverTwo)
			{
				setPositionY(-windowHeightOverTwo + heightOverTwo);
			}

		}

	private void shoot()
	{
		//we want projectile to go in direction of the player
		ObjectManager.addGameObject(new Projectile(direction, getPosition( )));
	}

	public void collisionReaction(GameObject collideWith)
	{
		if(collideWith.getName().equals("Obstacle"))
		{
			//kills whatever it hits, but will take damage
			//will kill the class object "Player" when we collide with an obstacle

			collideWith.kill();
			//Play the sound when an enemy is killed
			SoundManager.playSoundEffect("injured");
			livesCounter--;

			//player can take 3 hits, after that they die
		}

		//If our lives reach 0, the game is over and quits
		if (livesCounter <= 0)
		{
			//After we die, we want a death screen, asking for a retry, or an exit game option

		}
	}

}
