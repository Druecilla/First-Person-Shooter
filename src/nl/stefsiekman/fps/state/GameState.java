package nl.stefsiekman.fps.state;

import nl.stefsiekman.fps.world.GameWorld;

public abstract class GameState {
	
	public abstract void init();
	
	public abstract void update();
	
	public abstract void render();
	
}