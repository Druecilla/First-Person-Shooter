package nl.stefsiekman.fps;

import nl.stefsiekman.fps.mapa.MapArchive;
import nl.stefsiekman.fps.mapa.MapArchives;
import nl.stefsiekman.fps.state.State;
import nl.stefsiekman.fps.state.StateLoadMap;

public class LoadMap {
	
	private static MapArchive map;
	private static StateLoadMap gui;
	
	public static void loadMap(String name){
		map = MapArchives.getMap(name);
		gui = (StateLoadMap) State.getState(State.States.LOADMAP);
		
		gui.loadMap(map);
		
		State.setState(State.States.LOADMAP);
	}
}