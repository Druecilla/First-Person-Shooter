package nl.stefsiekman.fps.world;

import nl.stefsiekman.fps.math.Vector3f;

public class Camera {

	public Vector3f position;
	
	public Camera(float x, float y, float z) {
		this(new Vector3f(x, y, z));
	}

	public Camera(Vector3f position) {
		this.position = position;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
}
