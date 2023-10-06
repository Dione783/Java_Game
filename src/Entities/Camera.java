package Entities;

public class Camera {
	public static int x,y;
	public static void clamp(int x,int y,int maxX,int maxY) {
		if(x >= maxX) {
			x=maxX;
		}else if(x <= 0) {
			x=0;
		}
		
		if(y >= maxY) {
			y=maxY;
		}else if(y <= 0) {
			y=0;
		}
	}
}
