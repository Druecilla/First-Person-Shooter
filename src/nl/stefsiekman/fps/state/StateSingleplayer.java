package nl.stefsiekman.fps.state;

import nl.stefsiekman.fps.Time;
import nl.stefsiekman.fps.math.Vector3f;
import nl.stefsiekman.fps.world.Camera;
import nl.stefsiekman.fps.world.GameWorld;
import nl.stefsiekman.fps.world.Mesh;
import nl.stefsiekman.fps.world.Vertex;

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
		
	}
	
	public void openWorld(GameWorld world) {
		System.out.println("Opened new world!");
	}

}
