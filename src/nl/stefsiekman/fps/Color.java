package nl.stefsiekman.fps;

import org.lwjgl.opengl.GL11;

public class Color {
	
	public static Color BLACK = new Color();
	public static Color BLUE = new Color(0, 0, 255, 255);
	public static Color GREEN = new Color(0, 255, 0, 255);
	public static Color RED = new Color(255, 0, 0, 255);
	public static Color TRANSPARENT = new Color(0, 0, 0, 0);
	public static Color WHITE = new Color(255, 255, 255, 255);
	private int r;
	private int g;
	private int b;
	private int a;
	
	public Color(){
		this.r = 0;
		this.g = 0;
		this.b = 0;
		this.a = 255;
	}
	
	public Color(int r, int g, int b, int a){
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public float getRed(){
		return (float) r / 255;
	}
	
	public float getGreen(){
		return (float) g / 255;
	}
	
	public float getBlue(){
		return (float) b / 255;
	}
	
	public float getAlpha(){
		return (float) a / 255;
	}
	
	public void bind(){
		GL11.glColor4f((float) r / 255, (float) g / 255, (float) b / 255, (float) a / 255);
	}
}