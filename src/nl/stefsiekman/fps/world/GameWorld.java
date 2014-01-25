package nl.stefsiekman.fps.world;

import nl.stefsiekman.fps.Game;
import nl.stefsiekman.fps.math.Vector3f;

import static org.lwjgl.opengl.GL11.*;

public class GameWorld {
	
	private static Camera camera;
	
	public GameWorld(Vector3f size) {
		
	}
	
	public void render() {
		if(camera == null)
			return;
		
		Game.getInstance().init3D(camera);
		
		if(camera.wireFrameMode) {
			glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		} else {
			glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
		}
	}

	public static Camera getCamera() {
		return camera;
	}

	public static void setCamera(Camera camera) {
		GameWorld.camera = camera;
	}

}
