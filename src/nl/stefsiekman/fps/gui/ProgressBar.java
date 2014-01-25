package nl.stefsiekman.fps.gui;

import nl.stefsiekman.fps.Color;

import org.lwjgl.opengl.GL11;

public class ProgressBar extends Component{
	
	private int progresswidth = 0;
	private int progress = 0;
	private int max = 100;
	private int now = 0;

	public ProgressBar(){
		super(200, 10);
		
		colors.put("progress_normal", Color.WHITE);
		colors.put("progress_hovered", Color.WHITE);
		colors.put("progress_pressed", Color.WHITE);
	}
	
	public void setMax(int max){
		this.max = max;
	}
	
	public void setValue(int value){
		this.now = value;
	}
	
	public void setProgressColor(Color progresscolor){
		colors.put("progress_normal", progresscolor);
	}
	
	public Color getProgressColor(){
		return colors.get("progress_normal");
	}
	
	public void setHoveredProgressColor(Color progresscolor){
		colors.put("progress_hovered", progresscolor);
	}
	
	public Color getHoveredProgressColor(){
		return colors.get("progress_hovered");
	}
	
	public void setPressedProgressColor(Color progresscolor){
		colors.put("progress_pressed", progresscolor);
	}
	
	public Color getPressedProgressColor(){
		return colors.get("progress_pressed");
	}
	
	@Override
	protected void extraUpdate(){
		progress = (int) ((float) now / (float) max * 100);
		
		progresswidth = getWidth() / 100 * progress;
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
		
		getColor("progress").bind();
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2i(location.x, location.y);
		GL11.glVertex2i(location.x + progresswidth, location.y);
		GL11.glVertex2i(location.x + progresswidth, location.y + height);
		GL11.glVertex2i(location.x, location.y + height);
		GL11.glEnd();
	}

	@Override
	protected void onClick(){
		new ActionEvent(this);
	}	
}