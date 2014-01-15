package nl.stefsiekman.fps.math;

public class Vector2i {
	
	public int x;
	public int y;
	
	public Vector2i() {
		this(0, 0);
	}
	
	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Sets all the fields to the ones given
	 */
	public Vector2i set(int x, int y) {
		this.x = x;
		this.y = y;
		
		return this;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
