package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Engine.Frames;
import Engine.SpriteReader;
import Engine.SpritesheetCreator;

public class Player extends Entitie{
	private BufferedImage[] spritesDown,spritesLeft,spritesRight,spritesUp;
	private SpriteReader sprite;
	private SpritesheetCreator spriteCreatorPlayer;
	
	public Player() {
		super(400,400);
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
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(spritesUp[frame.getIndex()],position.getX(),position.getY(),16,32,null);
	}
	
}