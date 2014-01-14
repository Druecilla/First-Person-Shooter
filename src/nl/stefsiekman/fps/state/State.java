package nl.stefsiekman.fps.state;

import java.util.HashMap;

import nl.stefsiekman.fps.state.GameState;

public class State {
	
	public enum States {
		MAIN_MENU, SINGLEPLAYER, SINGLEPLAYER_MENU, MULTIPLAYER,
		MULTIPLAYER_MENU, PERSP_TEST
	}
	
	private static States currentState = States.MAIN_MENU;
	private static HashMap<States, GameState> states = new HashMap<States, GameState>();
	
	public static void addState(States state, GameState gamestate){
		states.put(state, gamestate);
	}
	
	public static void setState(States state){
		currentState = state;
		
		if(states.get(currentState) != null){
			states.get(currentState).init();
		}
	}
	
	public static void call(){
		if(states.get(currentState) != null){
			states.get(currentState).update();
			states.get(currentState).render();
		}
	}
}