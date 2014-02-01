package nl.stefsiekman.fps.world;

import static org.lwjgl.opengl.GL11.GL_FILL;
import static org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK;
import static org.lwjgl.opengl.GL11.GL_LINE;
import static org.lwjgl.opengl.GL11.glPolygonMode;

import java.util.ArrayList;
import java.util.List;

import nl.stefsiekman.fps.Game;
import nl.stefsiekman.fps.math.Vector3f;
import nl.stefsiekman.fps.world.entity.Entity;
import nl.stefsiekman.fps.world.entity.EntityPlayablePlayer;

public class GameWorld {
	
	private Camera camera;
	
	private EntityPlayablePlayer player;
	private List<GameObject> objects = new ArrayList<GameObject>();
	
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
		
		for(GameObject object : objects)
			object.render();
	}
	
	public void addStaticObject(GameObject object) {
		objects.add(object);
	}
	
	public void addEntity(Entity entity){
		if(entity instanceof EntityPlayablePlayer){
			this.player = (EntityPlayablePlayer) entity;
		}
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	public static List<GameObject> loadWorldObjects(String file) {
		return null;
	}

}
