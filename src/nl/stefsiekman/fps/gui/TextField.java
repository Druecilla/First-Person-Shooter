package nl.stefsiekman.fps.gui;

import nl.stefsiekman.fps.Color;
import nl.stefsiekman.fps.FontRenderer;
import nl.stefsiekman.fps.Game;
import nl.stefsiekman.fps.Input;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class TextField extends Component {
	
	private String text;
	private long last;
	private boolean cursor;
	
	public TextField(){
		super(200, 30);
		
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
		text += Input.getTypedText();
		
		if(Input.isKeyPressed(Keyboard.KEY_BACK)){
			if(text.length() != 0){
				text = text.substring(0, text.length() - 1);
			}
		}
		
		if(isSelected()){
			if(Game.getInstance().getTime() - last >= 600){
				cursor = !cursor;
				
				last = Game.getInstance().getTime();
			}
			
			if(Input.isKeyPressed(Keyboard.KEY_RETURN)){
				newAction(new ActionEvent(this));
			}
		}else{
			cursor = false;
		}
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
		
		if(cursor){
			getColor("text").bind();
			GL11.glBegin(GL11.GL_LINES);
			GL11.glVertex2i(location.x + FontRenderer.getWidth(text) + 4, location.y + 2);
			GL11.glVertex2i(location.x + FontRenderer.getWidth(text) + 4, location.y + height - 2);
			GL11.glEnd();
		}
		
		FontRenderer.drawString(location.x + 2, location.y + (height / 2 - FontRenderer.getHeight() / 2), text, getColor("text"));
	}
	
	@Override
	protected void onClick(){
		
	}
}