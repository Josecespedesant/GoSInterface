package com.tec.datos1.gameofsorts.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tec.datos1.gameofsorts.tools.HitBox;

public class FireBall {
	
	public static final int SPEED = 500;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 6;
	
	public static final float HEIGHTSCREEN = Gdx.graphics.getHeight();
	public static final float WIDTHSCREEN = Gdx.graphics.getWidth();
	
	float x, y;
	private HitBox fireHitBox;
	public boolean remove = false;
	private static Texture texture;
	
	public FireBall(float x, float y) {
		this.x = x;
		this.y = y;
		this.fireHitBox = new HitBox(x, y, WIDTH, HEIGHT);
		
		if(texture == null) {
			texture = new Texture("FireBall.png");
		}
		
	}
	
	public void update(float deltaTime) {
		x+=SPEED*deltaTime;
		if(x>WIDTHSCREEN) {
			remove = true;
		}
		
		fireHitBox.move(x,y);
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(texture, x, y);
	}
	
	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public HitBox getFireHitBox() {
		return fireHitBox;
	}


	public void setFireHitBox(HitBox fireHitBox) {
		this.fireHitBox = fireHitBox;
	}


	public boolean isRemove() {
		return remove;
	}


	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	

}
