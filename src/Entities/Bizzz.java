package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Engine.Frames;
import Engine.SpriteReader;
import Engine.SpritesheetCreator;

public class Bizzz extends Entity{
	protected SpriteReader image;
	protected SpritesheetCreator spriteCreator;
	protected BufferedImage[] sprites;
	
	public Bizzz(int x, int y,int width,int height) {
		super(x,y,width,height);
		frame = new Frames(12,12);
		sprites = new BufferedImage[12];
		image = new SpriteReader("/Inimigos.png");
		spriteCreator = new SpritesheetCreator(image,16,32);
		sprites = spriteCreator.createSprite(0,144,12,0);
	}

	@Override
	public void update() {
		frame.update();
		if(!checkCollision(GameObjects.getPlayer())) {
			if(position.getX() < GameObjects.getPlayer().position.getX()) {
				position.setX(position.getX()+0.5);
			}else{
				position.setX(position.getX()-0.5);
			}
			
			if(position.getY() < GameObjects.getPlayer().position.getY()){
				position.setY(position.getY()+0.5);
			}else {
				position.setY(position.getY()-0.5);
			}
		}else {
			GameObjects.getPlayer().life-=1;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprites[frame.getIndex()],(int)position.getXRender(),(int)position.getYRender(),null);
	}
}
