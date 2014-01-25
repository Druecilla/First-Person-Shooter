package nl.stefsiekman.fps;

public class Time {
	
	public static final double SECOND = 1000000000.0;
	private static long lastTime = System.nanoTime();
	private static double delta = 0.0;
	
	public static void updateDelta() {
		long now = System.nanoTime();
		delta = (now - lastTime) / SECOND;
		lastTime = now;
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
	public static float getFramesPerSecond() {
		return (float) (SECOND / delta);
	}
	
}
