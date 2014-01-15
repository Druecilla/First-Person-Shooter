package nl.stefsiekman.fps;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

public class Input {
	
	private static ArrayList<Key> keys = new ArrayList<Key>();
	private static boolean[] downkeys = new boolean[256];
	
	public static void init(){
		keys.add(new Key(Keyboard.KEY_0, '0', ')'));
		keys.add(new Key(Keyboard.KEY_1, '1', '!'));
		keys.add(new Key(Keyboard.KEY_2, '2', '@'));
		keys.add(new Key(Keyboard.KEY_3, '3', '#'));
		keys.add(new Key(Keyboard.KEY_4, '4', '$'));
		keys.add(new Key(Keyboard.KEY_5, '5', '%'));
		keys.add(new Key(Keyboard.KEY_6, '6', ' '));
		keys.add(new Key(Keyboard.KEY_7, '7', '&'));
		keys.add(new Key(Keyboard.KEY_8, '8', '*'));
		keys.add(new Key(Keyboard.KEY_9, '9', '('));
		keys.add(new Key(Keyboard.KEY_A, 'a', 'A'));
		keys.add(new Key(Keyboard.KEY_B, 'b', 'B'));
		keys.add(new Key(Keyboard.KEY_C, 'c', 'C'));
		keys.add(new Key(Keyboard.KEY_D, 'd', 'D'));
		keys.add(new Key(Keyboard.KEY_E, 'e', 'E'));
		keys.add(new Key(Keyboard.KEY_F, 'f', 'F'));
		keys.add(new Key(Keyboard.KEY_G, 'g', 'G'));
		keys.add(new Key(Keyboard.KEY_H, 'h', 'H'));
		keys.add(new Key(Keyboard.KEY_I, 'i', 'I'));
		keys.add(new Key(Keyboard.KEY_J, 'j', 'J'));
		keys.add(new Key(Keyboard.KEY_K, 'k', 'K'));
		keys.add(new Key(Keyboard.KEY_L, 'l', 'L'));
		keys.add(new Key(Keyboard.KEY_M, 'm', 'M'));
		keys.add(new Key(Keyboard.KEY_N, 'n', 'N'));
		keys.add(new Key(Keyboard.KEY_O, 'o', 'O'));
		keys.add(new Key(Keyboard.KEY_P, 'p', 'P'));
		keys.add(new Key(Keyboard.KEY_Q, 'q', 'Q'));
		keys.add(new Key(Keyboard.KEY_R, 'r', 'R'));
		keys.add(new Key(Keyboard.KEY_S, 's', 'S'));
		keys.add(new Key(Keyboard.KEY_T, 't', 'T'));
		keys.add(new Key(Keyboard.KEY_U, 'u', 'U'));
		keys.add(new Key(Keyboard.KEY_V, 'v', 'V'));
		keys.add(new Key(Keyboard.KEY_W, 'w', 'W'));
		keys.add(new Key(Keyboard.KEY_X, 'x', 'X'));
		keys.add(new Key(Keyboard.KEY_Y, 'y', 'Y'));
		keys.add(new Key(Keyboard.KEY_Z, 'z', 'Z'));
		keys.add(new Key(Keyboard.KEY_SPACE, ' ', ' '));
		keys.add(new Key(Keyboard.KEY_PERIOD, '.', '>'));
		keys.add(new Key(Keyboard.KEY_COMMA, ',', '<'));
		keys.add(new Key(Keyboard.KEY_SLASH, '/', '?'));
		keys.add(new Key(Keyboard.KEY_SEMICOLON, ';', ':'));
		keys.add(new Key(Keyboard.KEY_BACKSLASH, '\\', '|'));
		keys.add(new Key(Keyboard.KEY_LBRACKET, '[', '{'));
		keys.add(new Key(Keyboard.KEY_RBRACKET, ']', '}'));
		keys.add(new Key(Keyboard.KEY_MINUS, '-', '_'));
		keys.add(new Key(Keyboard.KEY_EQUALS, '=', '+'));
	}
	
	public static boolean isKeyDown(int keycode){
		return Keyboard.isKeyDown(keycode);
	}
	
	public static boolean isKeyPressed(int key){
		if(Keyboard.isKeyDown(key)){
			if(!downkeys[key]){
				downkeys[key] = true;
				return true;
			}
		}else{
			downkeys[key] = false;
		}
		return false;
	}
	
	public static String getTypedText(){
		String s = "";
		
		for(Key key : keys){
			if(isKeyPressed(key.key)){
				if(isKeyDown(Keyboard.KEY_LSHIFT) || isKeyDown(Keyboard.KEY_RSHIFT)){
					s += key.sc;
				}else{
					s += key.c;
				}
			}
		}
		
		return s;
	}
}