package nl.stefsiekman.fps;

import nl.stefsiekman.fps.mapa.MapArchive;
import nl.stefsiekman.fps.mapa.MapArchives;
import nl.stefsiekman.fps.math.Vector3f;
import nl.stefsiekman.fps.state.State;
import nl.stefsiekman.fps.state.StateLoadMap;
import nl.stefsiekman.fps.world.GameWorld;

public class LoadMap {
	
	private static MapArchive map;
	private static StateLoadMap gui;
	
	public static void loadMap(String name){
		map = MapArchives.getMap(name);
		gui = (StateLoadMap) State.getState(State.States.LOADMAP);
		
		gui.loadMap(map);
		
		State.setState(State.States.LOADMAP);
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				GameWorld world = new GameWorld(new Vector3f(100, 100, 100));
				State.getState(State.States.SINGLEPLAYER).openWorld(world);
				
				State.setState(State.States.SINGLEPLAYER);
			}
		});
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}