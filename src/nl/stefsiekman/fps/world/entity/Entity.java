package nl.stefsiekman.fps.world.entity;

import nl.stefsiekman.fps.math.Vector3f;
import nl.stefsiekman.fps.world.Mesh;

public class Entity {
	
	private Vector3f position;
	private Vector3f rotation;
	private Mesh mesh;
	
	public Entity(Vector3f position, Vector3f rotation, Mesh mesh){
		this.position = position;
		this.rotation = rotation;
		this.mesh = mesh;
	}
	
	public Vector3f getPosition(){
		return position;
	}
	
	public void setPosition(Vector3f position){
		this.position = position;
	}
	
	public Vector3f getRotation(){
		return rotation;
	}
	
	public void setRotation(Vector3f rotation){
		this.rotation = rotation;
	}

	public Mesh getMesh(){
		return mesh;
	}
}