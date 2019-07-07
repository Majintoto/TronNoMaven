package model;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import contract.Intersection;
import contract.Shape;


public abstract class Player extends GameObject {
	
	// player's colors
	Color color;
	
	// states of the player
	boolean alive = true;
	boolean jump = false;

	
	// initial conditions
	int startVel = 0;

	// static values to be used by all Player objects
	static int WIDTH = 5;
	static int HEIGHT = 5;
		
	// Player object's path
	ArrayList<Shape> lines = new ArrayList<Shape>();
	
	// constructor initializes initial conditions, timer, and color
	public Player(int randX, int randY, int velx, int vely, Color color) {
		super(randX, randY, velx, vely, WIDTH, HEIGHT);
		startVel = Math.max(Math.abs(velx), Math.abs(vely));
		this.color = color;
	}
	
	// changes state of Player if it exits the bounds
	public void accelerate() {
		if (x < 0 || x > rightBound) {
			velocityX = 0;
			alive = false;
		}
		if (y < 0 || y > bottomBound) {
			velocityY = 0;
			alive = false;
		}
	}	
	
	// draws Player and path
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x - WIDTH/2, y - HEIGHT/2, WIDTH, HEIGHT);
		for (Shape k: lines) {
			k.draw(g);
		}
	}
	
	// returns the state of the Player
	public boolean getAlive() {
		return alive;
	}
	
	// returns the Player's path
	public ArrayList<Shape> getPath() {
		return lines;
	}
	
	// checks if the Player has crashed with a path
	public void crash(Intersection i) {
		if (i == Intersection.UP) {
			velocityX = 0;
			velocityY = 0;
			alive = false;
		}
	}
	
	// moves the Player on the screen based on its velocity
	public abstract void move();
	
	// adds Player objects to the field
	abstract void addPlayers(Player[] players);
	
}