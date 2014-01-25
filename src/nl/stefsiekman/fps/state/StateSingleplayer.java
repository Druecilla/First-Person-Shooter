package nl.stefsiekman.fps.state;

import nl.stefsiekman.fps.world.GameWorld;

public class StateSingleplayer extends GameState {

	private GameWorld world;
	
	@Override
	public void init() {
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {
		if(world == null)
			return;
		
		world.render();
	}
	
	public void openWorld(GameWorld world) {
		System.out.println("Opened new world!");
	}

}
