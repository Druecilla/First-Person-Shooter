package nl.stefsiekman.fps.world;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import nl.stefsiekman.fps.math.Vector3f;

public class GameObject {
	
	public Vector3f position;
	public Vector3f rotation;
	public Vector3f scale;
	
	private Mesh mesh;

	public GameObject(Vector3f position, Vector3f rotation, Vector3f scale, Mesh mesh) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.mesh = mesh;
	}
	
	public void render() {
		if(mesh == null)
			return;
		
		glPushMatrix();
			glTranslatef(position.x, position.y, position.z);
			glRotatef(rotation.x, 1, 0, 0);
			glRotatef(rotation.y, 0, 1, 0);
			glRotatef(rotation.z, 0, 0, 1);
			glScalef(scale.x, scale.y, scale.z);
			
			mesh.draw();
		glPopMatrix();
	}
	
}
