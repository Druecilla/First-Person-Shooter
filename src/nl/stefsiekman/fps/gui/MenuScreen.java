package nl.stefsiekman.fps.gui;

import java.util.ArrayList;

import nl.stefsiekman.fps.Color;
import nl.stefsiekman.fps.Game;
import nl.stefsiekman.fps.state.GameState;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public abstract class MenuScreen extends GameState {
	
	private ArrayList<Component> components = new ArrayList<Component>();
	private Color background = Color.BLACK;
	private Texture texture;
	
	public void add(Component component){
		components.add(component);
	}
	
	public void remove(Component component){
		components.remove(component);
	}
	
	public void setBackgroundColor(Color color){
		this.background = color;
		this.texture = null;
	}
	
	public void setBackgroundImage(Texture texture){
		this.texture = texture;
	}
	
	@Override
	public void update(){
		for(Component component : components){
			component.update();
		}
	}
	
	@Override
	public void render(){
		if(texture == null){
			background.bind();
		}else{
			texture.bind();
		}
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2i(0, 0);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2i(Game.WIDTH, 0);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2i(Game.WIDTH, Game.HEIGHT);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2i(0, Game.HEIGHT);
		GL11.glEnd();
		
		for(Component component : components){
			component.render();
		}
	}
}