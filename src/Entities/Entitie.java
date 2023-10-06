package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entitie extends Position{
	private int frames,maxFrames,index,maxIndex;
	
	public Entitie(int x,int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	protected void setMaxFrames(int maxFrames) {
		this.maxFrames=maxFrames;
	}
	
	protected void setMaxIndex(int maxIndex) {
		this.maxIndex=maxIndex;
	}
	
	protected void setIndex(int index) {
		this.index=index;
	}
	
	protected void setFrames(int frames) {
		this.frames=frames;
	}
	
	protected int getFrames() {
		return frames;
	}
	
	protected int getIndex() {
		return index;
	}
	
	protected int getMaxFrames() {
		return maxFrames;
	}
	
	protected int getMaxIndex() {
		return maxIndex;
	}
	
	public boolean checkCollision(Entitie e) {
		Rectangle rec = new Rectangle();
		Rectangle rec1 = new Rectangle();
		if(rec.intersects(rec1)) {
			return true;
		}
		return false;
	}

}