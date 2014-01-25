package nl.stefsiekman.fps;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import nl.stefsiekman.fps.world.Vertex;

import org.lwjgl.BufferUtils;

public class Util {
	
	/*
	 * Creates a flipped float buffer of a integer array
	 */
	public static IntBuffer createFlippedBuffer(int[] data) {
		// Generate the buffer
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		
		// Put the data in the buffer
		buffer.put(data);
		
		// Flip the buffer
		buffer.flip();
		
		// Return the result
		return buffer;
	}
	
	/*
	 * Creates a flipped float buffer of a float array
	 */
	public static FloatBuffer createFlippedBuffer(Vertex[] data) {
		// Generate the buffer
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length * Vertex.SIZE);
		
		// Put the data in the buffer
		for (int i = 0; i < data.length; i++) {
			buffer.put(data[i].getPosition().x);
			buffer.put(data[i].getPosition().y);
			buffer.put(data[i].getPosition().z);
		}
		
		// Flip the buffer
		buffer.flip();
		
		// Return the result
		return buffer;
	}

}
