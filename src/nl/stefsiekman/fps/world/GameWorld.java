package nl.stefsiekman.fps.world;

import static org.lwjgl.opengl.GL11.GL_FILL;
import static org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK;
import static org.lwjgl.opengl.GL11.GL_LINE;
import static org.lwjgl.opengl.GL11.glPolygonMode;

import java.util.ArrayList;
import java.util.List;

import nl.stefsiekman.fps.Game;
import nl.stefsiekman.fps.Util;
import nl.stefsiekman.fps.math.Vector3f;

public class GameWorld {
	
	private static Camera camera;
	
	private List<GameObject> objects = new ArrayList<>();
	
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

	public static Camera getCamera() {
		return camera;
	}

	public static void setCamera(Camera camera) {
		GameWorld.camera = camera;
	}
	
	public static List<GameObject> loadWorldObjects(String file) {
		String[] lines = Util.removeEmpty(file.split("\n"));
		List<GameObject> objects = new ArrayList<>();
		
		for(String line : lines) {
			String[] tokens = Util.removeEmpty(line.split(" "));
			
			if(tokens.length < 2) {
				System.err.println("MAP LOADER ERROR: To few tokens on line: " + line);
				continue;
			}
			
			if(tokens[0].equals("shape")) {
				if(tokens[1].equals("cube")) {
					if(tokens.length < 4)
						System.out.println("MAP LOADER ERROR: To few tokens for a cube, line: " + line);
					
					String[] coord1 = tokens[2].split(",");
					if(coord1.length < 3)
						System.err.println("MAP LOADER ERROR: To few tokens for coordinate, line: " + line);
					Vector3f p1 = new Vector3f(
							Float.parseFloat(coord1[0]),
							Float.parseFloat(coord1[1]),
							Float.parseFloat(coord1[2]));
					
					String[] coord2 = tokens[2].split(",");
					if(coord2.length < 3)
						System.err.println("MAP LOADER ERROR: To few tokens for coordinate, line: " + line);
					Vector3f p2 = new Vector3f(
							Float.parseFloat(coord2[0]),
							Float.parseFloat(coord2[1]),
							Float.parseFloat(coord2[2]));
					
					Vertex[] vertices = new Vertex[] {
						new Vertex(new Vector3f()),
					};
				}
			}
		}
		
		return null;
	}

}
