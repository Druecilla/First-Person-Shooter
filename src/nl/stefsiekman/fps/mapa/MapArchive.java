package nl.stefsiekman.fps.mapa;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class MapArchive {
	
	private File file;
	private ZipFile zip;
	private Texture icon;
	private ZipEntry introfile;
	
	public MapArchive(File file){
		this.file = file;
	}
	
	public String load(){
		try{
			zip = new ZipFile(file);
			
			if(!loadIcon()){
				return "Unable to load icon";
			}else if(!checkIntro()){
				return "Unable to load intro";
			}else{
				return "ok";
			}
		}catch(ZipException e){
			return "Unable to load mapa";
		}catch(IOException e){
			return "Unable to load mapa";
		}
	}
	
	private boolean loadIcon(){
		ZipEntry iconfile;
		
		if((iconfile = zip.getEntry("icon.png")) != null){
			if(!iconfile.isDirectory()){
				try{
					icon = TextureLoader.getTexture("PNG", zip.getInputStream(iconfile));
					return true;
				}catch(IOException e){
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	private boolean checkIntro(){
		ZipEntry introfile;
		
		if((introfile = zip.getEntry("intro.png")) != null){
			if(!introfile.isDirectory()){
				this.introfile = introfile;
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public String getName(){
		return "lol";
	}
	
	public String getLongName(){
		return "heyho";
	}
	
	public Texture getIcon(){
		return icon;
	}
	
	public Texture getIntro() throws IOException{
		return TextureLoader.getTexture("PNG", zip.getInputStream(introfile));
	}
}