package nl.stefsiekman.fps.state;

import java.io.IOException;

import nl.stefsiekman.fps.Game;
import nl.stefsiekman.fps.gui.MenuScreen;
import nl.stefsiekman.fps.gui.ProgressBar;
import nl.stefsiekman.fps.mapa.MapArchive;
import nl.stefsiekman.fps.math.Vector2i;

public class StateLoadMap extends MenuScreen{
	
	private ProgressBar progress = new ProgressBar();
	
	public StateLoadMap(){
		progress.setLocation(new Vector2i(10, Game.HEIGHT - 20));
		progress.setSize(Game.WIDTH - 20, 10);
		add(progress);
	}
	
	public void loadMap(MapArchive map){
		try{
			setBackgroundImage(map.getIntro());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}