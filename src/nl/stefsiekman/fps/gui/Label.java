package nl.stefsiekman.fps.gui;

import nl.stefsiekman.fps.Color;
import nl.stefsiekman.fps.FontRenderer;

import org.lwjgl.opengl.GL11;

public class Label extends Component {
	
	private String text = "";
	
	public Label(){
		super(100, FontRenderer.getHeight());
		
		bordersize = 0;
		
		colors.put("normal_normal", Color.TRANSPARENT);
		colors.put("normal_hovered", Color.TRANSPARENT);
		colors.put("normal_pressed", Color.TRANSPARENT);
		
		colors.put("text_normal", Color.WHITE);
		colors.put("text_hovered", Color.WHITE);
		colors.put("text_pressed", Color.WHITE);
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
	
	public Color getTextcolor(){
		return colors.get("text_normal");
	}
	
	public void setTextcolor(Color textcolor){
		colors.put("text_normal", textcolor);
	}
	
	public Color getHoveredTextcolor(){
		return colors.get("text_hovered");
	}
	
	public void setHoveredTextcolor(Color textcolor){
		colors.put("text_hovered", textcolor);
	}
	
	public Color getPressedTextcolor(){
		return colors.get("text_pressed");
	}
	
	public void setPressedTextcolor(Color textcolor){
		colors.put("text_pressed", textcolor);
	}
	
	@Override
	protected void extraUpdate(){
		
	}
	
	@Override
	protected void draw(){
		getColor("normal").bind();
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2i(location.x, location.y);
		GL11.glVertex2i(location.x + width, location.y);
		GL11.glVertex2i(location.x + width, location.y + height);
		GL11.glVertex2i(location.x, location.y + height);
		GL11.glEnd();
		
		FontRenderer.drawString(location.x, location.y, text, getColor("text"));
	}
	
	@Override
	protected void onClick(){
		new ActionEvent(this);
	}
}