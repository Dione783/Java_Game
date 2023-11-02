package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Engine.SpriteReader;
import Engine.SpritesheetCreator;

public class UI {
	private static SpriteReader sprite = new SpriteReader("/Lifes.png");
	private static SpritesheetCreator spriteCreator = new SpritesheetCreator(sprite,16,16);
	private static BufferedImage[] sprites = spriteCreator.createSprite(0,0,4,0);
	
	public static void update() {
		
	}
	
	public static void render(Graphics g) {
		for(int i=0;i < sprites.length;i++) {
			g.drawImage(sprites[3],10+(i*16),10,null);
		}

		for(int j=0;j < GameObjects.getPlayer().life/2;j++) {
			g.drawImage(sprites[0],10+(j*16),10,null);
		}

		if(GameObjects.getPlayer().life % 2!=0) {
			g.drawImage(sprites[1],10+((GameObjects.getPlayer().life/2)*16),10,null);
		}

	}

}