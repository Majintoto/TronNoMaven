package contract;

import java.awt.Graphics;

// interface for all shapes drawn on the court
// allows for more shapes to be drawn if necessary
public interface Shape {

	public void draw(Graphics gc);
	public boolean isVertical();
	public int getStartX();
	public int getStartY();
	public int getEndX();
	public int getEndY();
	
}


