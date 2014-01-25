package nl.stefsiekman.fps.gui;

import java.util.ArrayList;
import java.util.HashMap;

import nl.stefsiekman.fps.Color;
import nl.stefsiekman.fps.Game;
import nl.stefsiekman.fps.math.Vector2i;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.TextureImpl;

public abstract class Component {
	
	protected Vector2i location = new Vector2i();
	protected int width;
	protected int height;
	protected HashMap<String, Color> colors = new HashMap<String, Color>();
	protected int bordersize = 1;
	private String state = "normal";
	private ArrayList<ActionListener> actionlisteners = new ArrayList<ActionListener>();
	private boolean mousedown;
	private boolean hovered;
	protected String actioncommand = "";
	protected static Component selected;
	
	protected abstract void extraUpdate();
	
	protected abstract void draw();
	
	protected abstract void onClick();
	
	public Component(int width, int height){
		this.width = width;
		this.height = height;
		
		colors.put("border_normal", Color.WHITE);
		colors.put("border_hovered", Color.WHITE);
		colors.put("border_pressed", Color.WHITE);
		
		colors.put("normal_normal", Color.BLACK);
		colors.put("normal_hovered", Color.BLACK);
		colors.put("normal_pressed", Color.BLACK);
	}
	
	public void addActionListener(ActionListener actionlistener){
		actionlisteners.add(actionlistener);
	}
	
	public void setActionCommand(String actioncommand){
		this.actioncommand = actioncommand;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public Vector2i getLocation(){
		return location;
	}
	
	public void setLocation(Vector2i location){
		this.location = location;
	}
	
	public int getBordersize(){
		return bordersize;
	}
	
	public void setBordersize(int bordersize){
		this.bordersize = bordersize;
	}
	
	public Color getBordercolor(){
		return colors.get("border_normal");
	}
	
	public void setBordercolor(Color bordercolor){
		colors.put("border_normal", bordercolor);
	}
	
	public Color getHoveredBordercolor(){
		return colors.get("border_hovered");
	}
	
	public void setHoveredBordercolor(Color bordercolor){
		colors.put("border_hovered", bordercolor);
	}
	
	public Color getPressedBordercolor(){
		return colors.get("border_pressed");
	}
	
	public void setPressedBordercolor(Color bordercolor){
		colors.put("border_pressed", bordercolor);
	}
	
	public Color getColor(){
		return colors.get("normal_normal");
	}
	
	public void setColor(Color color){
		colors.put("normal_normal", color);
	}
	
	public Color getHoveredcolor(){
		return colors.get("normal_hovered");
	}
	
	public void setHoveredcolor(Color color){
		colors.put("normal_hovered", color);
	}
	
	public Color getPressedcolor(){
		return colors.get("normal_pressed");
	}
	
	public void setPressedcolor(Color color){
		colors.put("normal_pressed", color);
	}
	
	protected boolean isSelected(){
		if(selected == this){
			return true;
		}else{
			return false;
		}
	}
	
	protected void newAction(ActionEvent e){
		for(ActionListener al : actionlisteners){
			al.ActionPerformed(e);
		}
	}
	
	protected Color getColor(String name){
		if(colors.get(name + "_" + state) != null){
			return colors.get(name + "_" + state);
		}else{
			return Color.TRANSPARENT;
		}
	}
	
	public boolean isHovered(){
		return hovered;
	}
	
	protected void init(){
		selected = null;
	}
	
	protected void update(){
		state = "normal";
		hovered = false;
		if(Mouse.getX() >= location.x && Mouse.getX() <= location.x + width){
			if(Game.HEIGHT - Mouse.getY() >= location.y && Game.HEIGHT - Mouse.getY() <= location.y + height){
				hovered = true;
				state = "hovered";
			}
		}
		
		if(Mouse.isButtonDown(0)){
			if(hovered){
				state = "pressed";
				mousedown = true;
			}
		}else if(mousedown){
			if(hovered){
				selected = this;
				onClick();
			}
			mousedown = false;
		}
		
		extraUpdate();
	}
	
	protected void render(){
		if(bordersize >= 1){
			getColor("border").bind();
			
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2i(location.x - bordersize, location.y - bordersize);
			GL11.glVertex2i(location.x + width + bordersize, location.y - bordersize);
			GL11.glVertex2i(location.x + width + bordersize, location.y + height + bordersize);
			GL11.glVertex2i(location.x - bordersize, location.y + height + bordersize);
			GL11.glEnd();
		}
		
		draw();
		TextureImpl.bindNone();
	}
}