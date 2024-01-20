package Entities;

import java.awt.Graphics;

public class Wall extends Tile{

	public Wall(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	
	public void render(Graphics g) {
		g.drawImage(tile[3][0],(int)position.getXRender(),(int)position.getYRender(),16,16,null);
	}
	
}