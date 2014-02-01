package nl.stefsiekman.fps.math;

public class Matrix4f {

	private float m[][];
	
	public Matrix4f() {
		m = new float[4][4];
	}
	
	public Matrix4f initIdentity() {
		m[0][0] = 1;	m[0][1] = 0;	m[0][2] = 0;	m[0][3] = 0;
		m[1][0] = 0;	m[1][1] = 1;	m[1][2] = 0;	m[1][3] = 0;
		m[2][0] = 0;	m[2][1] = 0;	m[2][2] = 1;	m[2][3] = 0;
		m[3][0] = 0;	m[3][1] = 0;	m[3][2] = 0;	m[3][3] = 1;
		
		return this;
	}
	
	public Matrix4f initTranslation(float x, float y, float z) {
		m[0][0] = 1;	m[0][1] = 0;	m[0][2] = 0;	m[0][3] = x;
		m[1][0] = 0;	m[1][1] = 1;	m[1][2] = 0;	m[1][3] = y;
		m[2][0] = 0;	m[2][1] = 0;	m[2][2] = 1;	m[2][3] = z;
		m[3][0] = 0;	m[3][1] = 0;	m[3][2] = 0;	m[3][3] = 1;
		
		return this;
	}
	
	public Matrix4f initScale(float x, float y, float z) {
		m[0][0] = x;	m[0][1] = 0;	m[0][2] = 0;	m[0][3] = 0;
		m[1][0] = 0;	m[1][1] = y;	m[1][2] = 0;	m[1][3] = 0;
		m[2][0] = 0;	m[2][1] = 0;	m[2][2] = z;	m[2][3] = 0;
		m[3][0] = 0;	m[3][1] = 0;	m[3][2] = 0;	m[3][3] = 1;
		
		return this;
	}
	
	public Matrix4f initRotation(float x, float y, float z) {
		// Convert degrees to radians
		x = Mathf.toRadians(x);
		y = Mathf.toRadians(y);
		z = Mathf.toRadians(z);
		
		Matrix4f rx = new Matrix4f();
		Matrix4f ry = new Matrix4f();
		Matrix4f rz = new Matrix4f();

		rz.m[0][0] = Mathf.cos(z);	rz.m[0][1] = -Mathf.sin(z);	rz.m[0][2] = 0;	rz.m[0][3] = 0;
		rz.m[1][0] = Mathf.sin(z);	rz.m[1][1] = Mathf.cos(z);	rz.m[1][2] = 0;	rz.m[1][3] = 0;
		rz.m[2][0] = 0;				rz.m[2][1] = 0;				rz.m[2][2] = 1;	rz.m[2][3] = 0;
		rz.m[3][0] = 0;				rz.m[3][1] = 0;				rz.m[3][2] = 0;	rz.m[3][3] = 1;

		rx.m[0][0] = 1;	rx.m[0][1] = 0;				rx.m[0][2] = 0;				rx.m[0][3] = 0;
		rx.m[1][0] = 0;	rx.m[1][1] = Mathf.cos(x);	rx.m[1][2] = -Mathf.sin(x);	rx.m[1][3] = 0;
		rx.m[2][0] = 0;	rx.m[2][1] = Mathf.sin(x);	rx.m[2][2] = Mathf.cos(x);	rx.m[2][3] = 0;
		rx.m[3][0] = 0;	rx.m[3][1] = 0;				rx.m[3][2] = 0;				rx.m[3][3] = 1;

		ry.m[0][0] = Mathf.cos(y);	ry.m[0][1] = 0;	ry.m[0][2] = -Mathf.sin(y);	ry.m[0][3] = 0;
		ry.m[1][0] = 0;				ry.m[1][1] = 1;	ry.m[1][2] = 0;				ry.m[1][3] = 0;
		ry.m[2][0] = Mathf.sin(y);	ry.m[2][1] = 0;	ry.m[2][2] = Mathf.cos(y);	ry.m[2][3] = 0;
		ry.m[3][0] = 0;				ry.m[3][1] = 0;	ry.m[3][2] = 0;				ry.m[3][3] = 1;
		
		m = rz.mul(ry.mul(rx)).getM();
		return this;
	}
	
	public Vector3f mul(Vector3f v) {
		float x = m[0][0] * v.x + m[0][1] * v.y + m[0][2] * v.z + m[0][3];
		float y = m[1][0] * v.x + m[1][1] * v.y + m[1][2] * v.z + m[1][3];
		float z = m[2][0] * v.x + m[2][1] * v.y + m[2][2] * v.z + m[2][3];
		
		return new Vector3f(x, y, z);
	}
	
	public Matrix4f mul(Matrix4f v) {
		Matrix4f res = new Matrix4f();
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				res.m[i][j] = m[i][0] * v.get(0, j) +
							  m[i][1] * v.get(1, j) +
							  m[i][2] * v.get(2, j) +
							  m[i][3] * v.get(3, j);
		
		return res;
	}
	
	public float get(int m, int n) {
		return this.m[m][n];
	}
	
	public void set(int m, int n, float value) {
		this.m[m][n] = value;
	}
	
	public float[][] getM() {
		float[][] res = new float[4][4];
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				res[i][j] = m[i][j];
		
		return res;
	}
	
}
