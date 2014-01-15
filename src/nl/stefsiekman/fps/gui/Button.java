package nl.stefsiekman.fps.gui;

import nl.stefsiekman.fps.Color;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Button extends Component {
	
	private String text = "";
	private Texture texture;
	
	public Button(){
		super(100, 30);
		
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
	
	public void setTexture(Texture texture){
		this.texture = texture;
	}
	
	@Override
	protected void extraUpdate(){
		
	}
	
	@Override
	protected void draw(){
		if(texture == null){
			getColor("normal").bind();
		}else{
			texture.bind();
		}
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2i(location.x, location.y);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2i(location.x + width, location.y);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2i(location.x + width, location.y + height);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2i(location.x, location.y + height);
		GL11.glEnd();
		
		// draw the text
	}
	
	@Override
	protected void onClick(){
		newAction(new ActionEvent(this));
	}
}