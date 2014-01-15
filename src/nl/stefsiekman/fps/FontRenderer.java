package nl.stefsiekman.fps;

import java.awt.Font;

import org.newdawn.slick.TrueTypeFont;

public class FontRenderer {
	
	private static TrueTypeFont font;
	
	public static void init(){
		Font awt = new Font("Times", Font.PLAIN, 14);
		font = new TrueTypeFont(awt, true);
	}
	
	public static int getWidth(String text){
		return font.getWidth(text);
	}
	
	public static int getHeight(){
		return font.getHeight();
	}
	
	public static void drawString(int x, int y, String text, Color color){
		font.drawString(x, y, text, new org.newdawn.slick.Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()));
	}
}