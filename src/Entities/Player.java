package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Engine.Frames;
import Engine.SpriteReader;
import Engine.SpritesheetCreator;
import Engine.Window;

public class Player extends Entity{
	private BufferedImage[] spritesDown,spritesLeft,spritesRight,spritesUp;
	private SpriteReader sprite;
	private SpritesheetCreator spriteCreatorPlayer;
	
	public Player(int x,int y,int width,int height) {
		super(x,y,width,height);
		position = new Position();
		position.setX(x);
		position.setY(y);
		velocity=1;
		life=8;
		maxLife=8;
		spritesDown = new BufferedImage[9];
		spritesUp = new BufferedImage[9];
		spritesLeft = new BufferedImage[9];
		spritesRight = new BufferedImage[9];
		sprite = new SpriteReader("/Personagem_Isometrico.png");
		spriteCreatorPlayer = new SpritesheetCreator(sprite,16,32);
		frame = new Frames(9,9);
		spritesDown = spriteCreatorPlayer.createSprite(0,0,0,9);
		spritesUp = spriteCreatorPlayer.createSprite(16,0,0,9);
		spritesRight = spriteCreatorPlayer.createSprite(32,0,0,9);
		spritesLeft = spriteCreatorPlayer.createSprite(48,0,0,9);
	}

	@Override
	public void update() {
		frame.update();
		if(right) {
			position.setX(position.getX()+velocity);
		}else if(left) {
			position.setX(position.getX()-velocity);
		}
		if(top) {
			position.setY(position.getY()-velocity);
		}else if(down) {
			position.setY(position.getY()+velocity);
		}
		if(life <= 0) {
			life=0;
		}
		Camera.setX((int)((position.getX())-(Window.WIDTH/4)));
		Camera.setY((int)((position.getY())-(Window.HEIGHT/4)));
	}

	@Override
	public void render(Graphics g) {
		if(top) {
			g.drawImage(spritesUp[frame.getIndex()],(int)position.getXRender(),(int)position.getYRender(),16,32,null);
		}else if(down){
			g.drawImage(spritesDown[frame.getIndex()],(int)position.getXRender(),(int)position.getYRender(),16,32,null);
		}else if(right) {
			g.drawImage(spritesRight[frame.getIndex()],(int)position.getXRender(),(int)position.getYRender(),16,32,null);
		}else if(left) {
			g.drawImage(spritesLeft[frame.getIndex()],(int)position.getXRender(),(int)position.getYRender(),16,32,null);
		}else {
			g.drawImage(spritesDown[0],(int)position.getXRender(),(int)position.getYRender(),16,32,null);
		}
	}
}