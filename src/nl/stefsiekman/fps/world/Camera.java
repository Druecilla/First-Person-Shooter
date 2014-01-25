package nl.stefsiekman.fps.world;

import nl.stefsiekman.fps.math.Vector3f;

public class Camera {

	public Vector3f position;
	public Vector3f rotation;
	
	public float fov = 75;
	public float as = 800f / 600f;
	public float zNear = 0.1f;
	public float zFar = 1000f;
	
	public Camera(float x, float y, float z) {
		this(new Vector3f(x, y, z));
	}
	
	public Camera(Vector3f position) {
		this(position, new Vector3f());
	}
	
	public Camera(Vector3f position, Vector3f rotation) {
		this(position, rotation, 75, 800f / 600f, 0.1f, 1000f);
	}

	public Camera(Vector3f position, Vector3f rotation, float fov, float as, float zNear, float zFar) {
		this.position = position;
		this.rotation = rotation;
		this.fov = fov;
		this.as = as;
		this.zNear = zNear;
		this.zFar = zFar;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	public float getFov() {
		return fov;
	}

	public void setFov(float fov) {
		this.fov = fov;
	}

	public float getAs() {
		return as;
	}

	public void setAs(float as) {
		this.as = as;
	}

	public float getzNear() {
		return zNear;
	}

	public void setzNear(float zNear) {
		this.zNear = zNear;
	}

	public float getzFar() {
		return zFar;
	}

	public void setzFar(float zFar) {
		this.zFar = zFar;
	}
	
}
