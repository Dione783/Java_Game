package Entities;

public class Position {
	
	private double x;
	private double y;
	
	public Position() {
		
	}
	
	public double getX() {
		return x;
	}

	public void setX(double d) {
		this.x=d;
	}

	public double getY() {
		System.out.println("Camera X:"+Camera.getX());
		return y;
	}
	
	public double getXRender() {
		
		return x-Camera.getX();
	}
	
	public double getYRender() {
		return y-Camera.getY();
	}

	public void setY(double d) {
		this.y = d;
	}
	
	
}
