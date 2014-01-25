package nl.stefsiekman.fps.mapa;

import java.io.File;
import java.util.ArrayList;

import nl.stefsiekman.fps.Game;

public class MapArchives {
	
	private static ArrayList<MapArchive> maps = new ArrayList<MapArchive>();
	
	public static void loadMaps(){
		File savefolder = new File(Game.getInstance().getGameFolder(), "saves");
		
		if(savefolder.exists()){
			if(!savefolder.isDirectory()){
				savefolder.delete();
				savefolder.mkdirs();
			}
		}else{
			savefolder.mkdirs();
		}
		
		File[] filelist = savefolder.listFiles();
		
		for(File file : filelist){
			if(file.isFile()){
				if(file.getName().endsWith(".mapa")){
					MapArchive map = new MapArchive(file);
					if(map.load() == "ok"){
						maps.add(map);
						System.out.println("Map loaded: " + map.getName());
					}
				}
			}
		}
	}
	
	public static ArrayList<MapArchive> listMaps(){
		return maps;
	}
	
	public static MapArchive getMap(String name){
		for(MapArchive map : maps){
			if(map.getName().equals(name)){
				return map;
			}
		}
		
		return null;
	}
}