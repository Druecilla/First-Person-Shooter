package nl.stefsiekman.fps.world;

import nl.stefsiekman.fps.math.Vector3f;

public class Vertex {
	
	public static final int SIZE = 3;
	
	public Vector3f position;

	public Vertex(Vector3f position) {
		this.position = position;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

}
