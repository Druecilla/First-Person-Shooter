package nl.stefsiekman.fps;

import java.io.File;

import javax.swing.JOptionPane;

import nl.stefsiekman.fps.state.State;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.TextureImpl;

public class Game {
	
	public static int WIDTH = 800;
	public static int HEIGHT = 800;
	
	private boolean running = true;
	
	private static Game instance;
	private static File launcher;
	private static File gamefolder;
	
	public Game(){
		instance = this;
		initGL();
		init2D();
		
		while(!Display.isCloseRequested() && running){
			clearScreen();
			
			State.call();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		System.exit(0);
	}
	
	private void initGL(){
		try{
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("First Person Shooter");
			Display.create();
			
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			
			FontRenderer.init();
			Input.init();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
	}
	
	public void init2D(){
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
	}
	
	public void init3D(){
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluPerspective(100, (float) WIDTH / HEIGHT, 0.001f, 1000);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	private void clearScreen(){
		GL11.glLoadIdentity();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		TextureImpl.bindNone();
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
	}
	
	public long getTime(){
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public void quit(){
		running = false;
	}
	
	public static Game getInstance(){
		return instance;
	}
	
	public static void main(String[] args){
		try{
			gamefolder = new File(args[0]); // gives problems when there are spaces in the name
			launcher = new File(args[1]); // gives problems when there are spaces in the name
			
			System.setProperty("org.lwjgl.librarypath", new File(gamefolder, "natives").getAbsolutePath());
			
			new Game();
		}catch(ArrayIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "Failed to launch\nWrong launch arguments", "error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}