package com.tec.datos1.gameofsorts.entities;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.applet.Applet;

import javax.swing.ImageIcon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import javafx.animation.*;
import com.tec.datos1.gameofsorts.tools.HitBox;



public class Player extends ApplicationAdapter{

	private int speed = 300;
	private static int HEIGHT = 200;
	private static int WIDTH = 200;
	private HitBox hitbox;
	private SpriteBatch batch;
	private Texture img;
	TextureRegion[][] animationFrames;
	private Sprite sprite;
	int frame = 0;
	int row = 0;
	private float x;
	private float y;

	
	public Player() {
		this.hitbox = new HitBox(x,y,WIDTH, HEIGHT);
	}
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("griphSprite.png");
		animationFrames = TextureRegion.split(img, 200, 200);
		sprite = new Sprite(animationFrames[0][0]);
		sprite.setPosition(500, 500);
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				frame++;
				if(frame>2) {
					frame = 0;
					if(row == 1) {
						row = 0;
					}
					else {
						row = 1;
					}
					
				}
				sprite.setRegion(animationFrames[0][1]);
			}
		}, 0, 1f/20f);
	}
	
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img,0,0);
		batch.end();
	}
	
	
}
