package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Engine.SpriteReader;
import Engine.SpritesheetCreator;
import Enums.Block;

public class Tile extends Entity{
	private static SpriteReader sprite = new SpriteReader("/Tile.png");
	private static SpritesheetCreator spriteCreator = new SpritesheetCreator(sprite,16,16);
	protected static BufferedImage[] tile = spriteCreator.createSprite(0,0,2,0);
	
	public Tile(int x, int y,int width,int height) {
		super(x,y,width,height);
		position = new Position();
		position.setX(x);
		position.setY(y);
	}

	public void update() {
		
	}

	public void render(Graphics g) {
		
	}
}