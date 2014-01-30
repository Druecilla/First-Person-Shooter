package nl.stefsiekman.fps.world.entity;

import nl.stefsiekman.fps.math.Vector3f;
import nl.stefsiekman.fps.world.Mesh;

public class EntityPlayer extends Entity {
	
	private Vector3f headrotation;
	private int health = 100;
	
	public EntityPlayer(Vector3f position, Vector3f rotation, Mesh mesh, Vector3f headrotation){
		super(position, rotation, mesh);
		this.headrotation = headrotation;
	}
	
	public Vector3f getHeadrotation(){
		return headrotation;
	}
	
	public void setHeadrotation(Vector3f headrotation){
		this.headrotation = headrotation;
	}

	public int getHealth(){
		return health;
	}

	public void setHealth(int health){
		this.health = health;
	}
}