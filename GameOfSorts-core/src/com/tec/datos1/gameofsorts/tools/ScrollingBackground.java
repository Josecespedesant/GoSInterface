package com.tec.datos1.gameofsorts.tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollingBackground {
	//Attributes of the class ScrollingBackground.
	public static final int DEFAULT_SPEED = 180;
	public static final int ACCELERATION = 150;
	public static final int GOAL_REACH_ACCELERATION = 300;
	
	Texture image;
	float y1, y2;
	int speed;
	int goalSpeed;
	float imageScale;
	boolean speedFixed;
	/**
	 * Constructor of the class ScrollingBackground.
	 */
	public ScrollingBackground () {
		image = new Texture("fondoEstrellas.png");
		
		y1 = 0;
		y2 = image.getHeight();
		speed = 0;
		goalSpeed = DEFAULT_SPEED;
		imageScale = 1200 / image.getWidth();
		speedFixed = true;
	}
	
	/**
	 * Keep the background updated and rendered.
	 * @param deltaTime
	 * @param batch
	 */
	public void updateAndRender (float deltaTime, SpriteBatch batch) {
		if (speed < goalSpeed) {
			speed += GOAL_REACH_ACCELERATION * deltaTime;
			if (speed > goalSpeed)
				speed = goalSpeed;
		} else if (speed > goalSpeed) {
			speed -= GOAL_REACH_ACCELERATION * deltaTime;
			if (speed < goalSpeed)
				speed = goalSpeed;
		}
		
		if (!speedFixed)
			speed += ACCELERATION * deltaTime;
		
		y1 -= speed * deltaTime;
		y2 -= speed * deltaTime;
		
		//if the image reaches the bottom of screen and is not visible, put it back on top.
		if (y1 + image.getHeight() * imageScale <= 0)
			y1 = y2 + image.getHeight() * imageScale;
		
		if (y2 + image.getHeight() * imageScale <= 0)
			y2 = y1 + image.getHeight() * imageScale;
		
		batch.draw(image, 0, y1, 1200, image.getHeight() * imageScale);
		batch.draw(image, 0, y2, 1200, image.getHeight() * imageScale);
	}
	
	/**
	 * Sets the speed of the background
	 * @param goalSpeed
	 */
	public void setSpeed (int goalSpeed) {
		this.goalSpeed = goalSpeed;
	}
	
	/**
	 * Allows you to set if the speed is fixed or not.
	 * @param speedFixed
	 */
	public void setSpeedFixed (boolean speedFixed) {
		this.speedFixed = speedFixed;
	}

	
	
}
