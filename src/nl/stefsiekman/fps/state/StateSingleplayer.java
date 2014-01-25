package nl.stefsiekman.fps.state;

import nl.stefsiekman.fps.Time;
import nl.stefsiekman.fps.math.Vector3f;
import nl.stefsiekman.fps.world.Camera;
import nl.stefsiekman.fps.world.GameWorld;
import nl.stefsiekman.fps.world.Mesh;
import nl.stefsiekman.fps.world.Vertex;

public class StateSingleplayer extends GameState {

	private GameWorld world;
	private Mesh mesh;
	
	@Override
	public void init() {
		world = new GameWorld(new Vector3f(1000, 1000, 100));
		GameWorld.setCamera(new Camera(new Vector3f(0, 0, 0), new Vector3f(30, 0, 0)));
		GameWorld.getCamera().setWireFrameMode(false);
		
		Vertex[] vertices = new Vertex[] {
			new Vertex(new Vector3f(-1, -1, -10)),
			new Vertex(new Vector3f(0, 1, -10)),
			new Vertex(new Vector3f(1, -1, -10)),
		};
		int[] indices = new int[] {
			0, 1, 2
		};
		mesh = new Mesh(indices, vertices);
	}

	float f = 0;
	@Override
	public void update() {
		f += Time.getDeltaTime();
		
		GameWorld.getCamera().fov = 75 + (float)Math.cos(f) * 25; 
	}

	@Override
	public void render() {
		world.render();
		mesh.draw();
	}

}
