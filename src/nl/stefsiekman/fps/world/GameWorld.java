package nl.stefsiekman.fps.world;

import nl.stefsiekman.fps.Game;
import nl.stefsiekman.fps.math.Vector3f;

public class GameWorld {
	
	private static Camera camera;
	
	public GameWorld(Vector3f size) {
		
	}
	
	public void render() {
		if(camera == null)
			return;
		
		Game.getInstance().init3D(camera);
	}

	public static Camera getCamera() {
		return camera;
	}

	public static void setCamera(Camera camera) {
		GameWorld.camera = camera;
	}

}
