package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import Engine.Frames;

public abstract class Entitie{
	
	protected Position position;
	protected Frames frame;
	
	public Entitie(int x,int y) {
		position = new Position();
		position.setX(x);
		position.setY(y);
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

	
	public boolean checkCollision(Entitie e) {
		Rectangle rec = new Rectangle();
		Rectangle rec1 = new Rectangle();
		if(rec.intersects(rec1)) {
			return true;
		}
		return false;
	}

}