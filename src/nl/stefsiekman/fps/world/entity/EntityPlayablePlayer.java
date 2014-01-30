package nl.stefsiekman.fps.world.entity;

import nl.stefsiekman.fps.math.Vector3f;
import nl.stefsiekman.fps.world.Camera;
import nl.stefsiekman.fps.world.Mesh;

public class EntityPlayablePlayer extends EntityPlayer{
	
	private Camera camera;
	
	public EntityPlayablePlayer(Vector3f position, Vector3f rotation, Mesh mesh, Vector3f headrotation, Camera camera){
		super(position, rotation, mesh, headrotation);
		this.camera = camera;
	}

	public Camera getCamera(){
		return camera;
	}
}