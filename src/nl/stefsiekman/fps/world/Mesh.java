package nl.stefsiekman.fps.world;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import nl.stefsiekman.fps.Util;

public class Mesh {
        
        public enum Shape {
                CUBE
        }
        
        private int vbo;
        private int ibo;
        private int size;
        
        public Mesh() {
        	this(null, null);
        }
        
        public Mesh(Shape shape) {
                // TODO: load shape from local .obj file
        }
        
        public Mesh(int[] indices, Vertex[] vertices) {
        	if(indices == null || vertices == null)
        		return;
        	
                vbo = glGenBuffers();
                ibo = glGenBuffers();
                size = 0;
                
                addVertices(indices, vertices);
        }
        
        private void addVertices(int[] indices, Vertex[] vertices) {
                // Set size to the amount of indices
                size = indices.length;
                
                // Allocate and set vertices buffer
                glBindBuffer(GL_ARRAY_BUFFER, vbo);
                glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
                
                // Allocate and set indices buffer
                glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
                glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indices), GL_STATIC_DRAW);
        }
        
        public void draw() {
        	
                // Enable the attribute arrays we need
                glEnableVertexAttribArray(0);
                
                // Set how to layout the vertex buffer
                glBindBuffer(GL_ARRAY_BUFFER, vbo);
                glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
                
                // Draw the faces (elements)
                glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
                glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);
                
                // Disable the attribute arrays
                glDisableVertexAttribArray(0);
        }

}