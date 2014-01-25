package nl.stefsiekman.fps;

public class Time {
	
	public static final double SECOND = 1000000000.0;
	private static long lastTime = System.nanoTime();
	private static double delta = 0.0;
	
	private static long lastSecondTime = System.currentTimeMillis();
	private static int frames = 0;
	private static int fps = 0;
	
	public static void updateDelta() {
		long now = System.nanoTime();
		delta = (now - lastTime) / SECOND;
		lastTime = now;
		
		frames++;
		long secondNow = System.currentTimeMillis();
		if(secondNow - lastSecondTime >= 1000) {
			fps = frames;
			frames = 0;
			lastSecondTime = secondNow;
		}
	}
	
	public static double getDelta() {
		return delta;
	}
	
	public static float getDeltaTime() {
		return (float)delta;
	}
	
	/*
	 * Returns the most accurate calculation of the estimated frames per second
	 */
	public static float getEstimatedFPS() {
		return (float) (SECOND / delta);
	}
	
	/*
	 * Returns the amount of frames of the last second
	 */
	public static int getFPS() {
		return fps;
	}
	
}
