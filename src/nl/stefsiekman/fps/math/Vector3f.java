package nl.stefsiekman.fps.math;

public class Vector3f {

	public float x;
	public float y;
	public float z;
	
	public Vector3f() {
		this(0, 0, 0);
	}

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float getLength() {
		return Mathf.sqrt(x * x + y * y + z * z);
	}
	
	/*
	 * Returns a new vector of this one rotated (degrees)
	 */
	public Vector3f rotated(float x, float y, float z) {
		Matrix4f m = new Matrix4f().initRotation(x, y, z);
		return m.mul(this);
	}
	
	/*
	 * Rotates THIS vector (degrees)
	 */
	public void rotate(float x, float y, float z) {
		Matrix4f m = new Matrix4f().initRotation(x, y, z);
		Vector3f res = m.mul(this);
		
		x = res.x;
		y = res.y;
		z = res.z;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
}
