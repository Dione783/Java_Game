package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Engine.SpriteReader;
import Engine.SpritesheetCreator;

public class Tile extends Entity{
	private static SpriteReader sprite = new SpriteReader("/Tileset_1.png");
	private static SpriteReader spriteGround = new SpriteReader("/Tileset_2.png");
	private static SpritesheetCreator spriteCreator = new SpritesheetCreator(sprite,16,16);
	private static SpritesheetCreator spriteCreatorGround = new SpritesheetCreator(spriteGround,16,16);
	protected static BufferedImage[][] tile = spriteCreator.getAll(4);
	protected static BufferedImage[][] ground = spriteCreatorGround.getAll(4);
	
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