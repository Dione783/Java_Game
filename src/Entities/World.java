package Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import Engine.SpriteReader;

public class World {
	private List<Tile> tiles;
	private SpriteReader image;
	private int WIDTH,HEIGHT;
	
	public World(double width,double height) {
		image = new SpriteReader("/Map.png");
		WIDTH = image.getImage().getWidth();
		HEIGHT = image.getImage().getHeight();
		int[] pixels = new int[WIDTH*HEIGHT];
		image.getImage().getRGB(0,0,WIDTH,HEIGHT,pixels,0,WIDTH);
		tiles = new ArrayList<Tile>();
			for(int xx=0;xx < WIDTH;xx++) {
				for(int yy=0;yy < HEIGHT;yy++) {
					int pixel = pixels[xx+(yy*WIDTH)];
					if(pixel == 0xff3f3f74) {
						tiles.add(new Ground(xx*16,yy*16,16,16));
					}else if(pixel == 0xff4b692f){
						tiles.add(new Wall(xx*16,yy*16,16,16));
					}else if(pixel == 0xff3600ff) {
						tiles.add(new Ground(xx*16,yy*16,16,16));
						GameObjects.getPlayer().position.setX(xx*16);
						GameObjects.getPlayer().position.setY(yy*16);
					}
				}
			}
	}

	public void changeWorld(String path) {
		image = new SpriteReader(path);
	}

	public void render(Graphics g) {
		for(Tile t:tiles) {
			t.render(g);
		}
	}

	public void update() {
		
	}
}