package Entities;

import java.awt.Graphics;

public class Ground extends Tile{

	public Ground(int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	
	
	public void render(Graphics g) {
		g.drawImage(ground[0][3],(int)position.getXRender(),(int)position.getYRender(),16,16,null);
	}
}