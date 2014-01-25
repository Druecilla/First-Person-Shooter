package nl.stefsiekman.fps.state;

import nl.stefsiekman.fps.gui.Button;
import nl.stefsiekman.fps.gui.MenuScreen;
import nl.stefsiekman.fps.mapa.MapArchive;
import nl.stefsiekman.fps.mapa.MapArchives;
import nl.stefsiekman.fps.math.Vector2i;

public class StateSingleplayerMenu extends MenuScreen{
	
	private int maps = 0;
	
	public StateSingleplayerMenu(){
		Button mapbutton;
		
		for(MapArchive map : MapArchives.listMaps()){
			mapbutton = new Button();
			
			mapbutton.setTexture(map.getIcon());
			mapbutton.setLocation(new Vector2i(30, maps * 100 + 10));
			mapbutton.setSize(100, 100);
			mapbutton.setActionCommand(map.getName());
			
			add(mapbutton);
			maps += 1;
		}
	}
}