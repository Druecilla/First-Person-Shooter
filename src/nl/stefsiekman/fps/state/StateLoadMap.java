package nl.stefsiekman.fps.state;

public class StateLoadMap {
	
	public StateLoadMap(){
		
	}
	
	public static void loadMap(String name){
		State.setState(State.States.LOADMAP);
	}
}