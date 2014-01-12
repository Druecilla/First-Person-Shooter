package nl.stefsiekman.fps;

import java.io.File;

import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.TextureImpl;

public class Game {
	
	public static int WIDTH = 800;
	public static int HEIGHT = 800;
	
	private static Game instance;
	private static File launcher;
	private static File gamefolder;
	
	public Game(){
		instance = this;
		initGL();
		
		while(!Display.isCloseRequested()){
			clearScreen();			
			
			Display.update();
			Display.sync(60);
		}
	}
	
	private void initGL(){
		try{
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("First Person Shooter");
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
	}
	
	private void clearScreen(){
		GL11.glLoadIdentity();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		TextureImpl.bindNone();
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		GL11.glClearColor(1.0f, 1.0f, 0.0f, 0.0f);
	}
	
	public static Game getInstance(){
		return instance;
	}
	
	public static void main(String[] args){
		try{
			gamefolder = new File(args[0]); //gives problems when there are spaces in the name
			launcher = new File(args[1]); //gives problems when there are spaces in the name
			
			System.setProperty("org.lwjgl.librarypath", new File(gamefolder, "natives").getAbsolutePath());
			
			new Game();
		}catch(ArrayIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "Failed to launch\nWrong launch arguments", "error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}