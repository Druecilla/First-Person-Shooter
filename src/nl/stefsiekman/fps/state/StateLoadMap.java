package nl.stefsiekman.fps.state;

import java.io.IOException;

import nl.stefsiekman.fps.gui.MenuScreen;
import nl.stefsiekman.fps.mapa.MapArchive;

public class StateLoadMap extends MenuScreen{
	
	public StateLoadMap(){
		
	}
	
	public void loadMap(MapArchive map){
		try{
			setBackgroundImage(map.getIntro());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}