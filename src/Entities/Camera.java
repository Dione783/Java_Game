package Entities;

public class Camera {
	private static double x,y;
	
	public static void setX(int updatedX) {
		x=updatedX;
	}
	
	public static void setY(int updatedY) {
		y=updatedY;
	}
	
	public static double getX() {
		return x;
	}
	
	public static double getY() {
		return y;
	}
}