package com.tec.datos1.gameofsorts.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.tec.datos1.gameofsorts.entities.Player;

public class MainScreen extends Screens{
	private Player player;
	private float shootTimer;
	private static final float SHOOT_WAIT_TIME = 0.6f;

	public MainScreen(Games game) {
		super(game);
		
	}
	
	@Override
	public void show() {
		player = new Player();
		shootTimer = 0;
	}
	
	@Override
	public void render(float delta) {
		game.batch.begin();
		
		
		
		
		player.create();
		
		
		
		
		game.batch.end();
		
	}
	
	

}
