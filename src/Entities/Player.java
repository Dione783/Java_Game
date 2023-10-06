package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Engine.SpriteReader;

public class Player extends Entitie{
	private BufferedImage[] spritesDown,spritesLeft,spritesRight,spritesUp;
	private static SpriteReader sprite;
	public Player() {
		super(400,400);
		spritesDown = new BufferedImage[9];
		spritesUp = new BufferedImage[9];
		spritesLeft = new BufferedImage[9];
		spritesRight = new BufferedImage[9];
		sprite = new SpriteReader("/Personagem_Isometrico.png");
		for(int i=0;i < spritesDown.length-1;i++) {
			spritesDown[i] = sprite.getSprite(0,0+((i+1)*32),16,32);
		}
		for(int i=0;i < spritesUp.length-1;i++) {
			spritesUp[i] = sprite.getSprite(16,0+((i+1)*32),16,32);
		}
		for(int i=0;i < spritesRight.length-1;i++) {
			spritesRight[i] = sprite.getSprite(32,0+((i+1)*32),16,32);
		}
		for(int i=0;i < spritesLeft.length-1;i++) {
			spritesLeft[i] = sprite.getSprite(48,0+((i+1)*32),16,32);
		}
		this.setMaxFrames(9);
		this.setMaxIndex(8);
	}

	@Override
	public void update() {
		setFrames(getFrames()+1);
		if(getFrames() >= getMaxFrames()) {
			setFrames(0);
			setIndex(getIndex()+1);
			if(getIndex() >= getMaxIndex()) {
				setIndex(0);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(spritesRight[getIndex()],getX(),getY(),128,128,null);
	}
	
}