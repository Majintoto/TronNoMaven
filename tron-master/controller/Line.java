package controller;


import java.awt.Graphics;

import contract.Shape;

//shape of trails drawn on court
public class Line implements Shape {
	
	// positions of the start and end of the line
	private int x;
	private int y;
	private int x2;
	private int y2;
	
	public Line(int x, int y, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	// draws the line
	public void draw(Graphics gc) {
		gc.drawLine(x, y, x2, y2);
	}
	
	// checks if the line is vertical
	public boolean isVertical() {
		return (x == x2);
	}
	
	// returns the starting X position
	public int getStartX() {
		return x;
	}
	
	// returns the starting Y position
	public int getStartY() {
		return y;
	}
	
	// returns the ending X position
	public int getEndX() {
		return x2;
	}
	
	// returns the ending Y position
	public int getEndY() {
		return y2;
	}
}