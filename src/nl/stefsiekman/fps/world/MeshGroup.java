package nl.stefsiekman.fps.world;

import java.util.ArrayList;

public class MeshGroup {
	
	private ArrayList<Mesh> meshes = new ArrayList<Mesh>();
	
	public int addMesh(Mesh mesh){
		int size = meshes.size();
		meshes.add(size, mesh);
		return size;
	}
	
	public Mesh getMesh(int index){
		return meshes.get(index);
	}
}