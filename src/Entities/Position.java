package Entities;

public abstract class Position {
	private int x,y;
	
	public int getX() {
		return x-Camera.x;
	}

	public void setX(int x) {
		this.x=x-Camera.x;
	}

	public int getY() {
		return y-Camera.y;
	}

	public void setY(int y) {
		this.y = y-Camera.y;
	}
	
	
}
