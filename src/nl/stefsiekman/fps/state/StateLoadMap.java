package nl.stefsiekman.fps.state;

import nl.stefsiekman.fps.gui.MenuScreen;

public class StateLoadMap extends MenuScreen{
	
	public StateLoadMap(){
		
	}
	
	public static void loadMap(String name){
		State.setState(State.States.LOADMAP);
	}
}