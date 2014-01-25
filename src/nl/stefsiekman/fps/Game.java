package nl.stefsiekman.fps;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_FILL;
import static org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glPolygonMode;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import java.io.File;

import javax.swing.JOptionPane;

import nl.stefsiekman.fps.mapa.MapArchives;
import nl.stefsiekman.fps.state.State;
import nl.stefsiekman.fps.state.StateLoadMap;
import nl.stefsiekman.fps.state.StateMainMenu;
import nl.stefsiekman.fps.state.StateMultiplayerMenu;
import nl.stefsiekman.fps.state.StateOptions;
import nl.stefsiekman.fps.state.StateSingleplayer;
import nl.stefsiekman.fps.state.StateSingleplayerMenu;
import nl.stefsiekman.fps.world.Camera;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.TextureImpl;

public class Game {
	
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	
	private boolean running = true;
	
	private static Game instance;
	@SuppressWarnings("unused")
	private static File launcher;
	private static File gamefolder;
	
	public Game(){
		instance = this;
		initGL();
		init2D();
		MapArchives.loadMaps();
		State.addState(State.States.MAIN_MENU, new StateMainMenu());
		State.addState(State.States.MULTIPLAYER_MENU, new StateMultiplayerMenu());
		State.addState(State.States.SINGLEPLAYER_MENU, new StateSingleplayerMenu());
		State.addState(State.States.OPTIONS, new StateOptions());
		State.addState(State.States.LOADMAP, new StateLoadMap());
		State.addState(State.States.SINGLEPLAYER, new StateSingleplayer());
		State.setState(State.States.MAIN_MENU);
		
		while(!Display.isCloseRequested() && running){
			Time.updateDelta();
			
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
			
			glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			
			FontRenderer.init();
			Input.init();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
	}
	
	public void init2D(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
	}
	
	public void init3D(Camera cam){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(cam.fov, cam.as, cam.zNear, cam.zFar);
		glMatrixMode(GL11.GL_MODELVIEW);
		glLoadIdentity();
		
		// Translate camera
		glTranslatef(-cam.position.x, -cam.position.y, -cam.position.z);
		glRotatef(cam.rotation.x, 1, 0, 0);
		glRotatef(cam.rotation.y, 0, 1, 0);
		glRotatef(cam.rotation.z, 0, 0, 1);
	}
	
	private void clearScreen(){
		glLoadIdentity();
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		TextureImpl.bindNone();
		glColor3f(1.0f, 1.0f, 1.0f);
	}
	
	public long getTime(){
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public File getGameFolder(){
		return gamefolder;
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