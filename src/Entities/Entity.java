package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import Engine.Frames;

public abstract class Entity{
	protected boolean right,left,top,down;
	protected Position position;
	protected Frames frame;
	protected int width,height;
	protected double velocity;
	protected int life,maxLife;
	
	public Entity(int x,int y,int width,int height) {
		this.width=width;
		this.height=height;
		position = new Position();
		position.setX(x);
		position.setY(y);
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

	
	public boolean checkCollision(Entity e) {
		Rectangle rec = new Rectangle((int)position.getX(),(int)position.getY(),this.width,this.height);
		Rectangle rec1 = new Rectangle((int)e.position.getX(),(int)e.position.getY(),e.width,e.height);
		if(rec.intersects(rec1)) {
			return true;
		}
		return false;
	}
	
	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
}