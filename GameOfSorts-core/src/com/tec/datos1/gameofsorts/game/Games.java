package com.tec.datos1.gameofsorts.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Games extends Game {
	SpriteBatch batch;
	Texture img;
	MainScreen main;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		main = new MainScreen(this);
		setScreen(main);
	}

	@Override
	public void render () {
		super.render();
	}
	
	public void dispose (int width, int height) {
		super.resize(width, height);
	}
}
