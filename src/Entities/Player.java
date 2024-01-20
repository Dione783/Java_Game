package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import Engine.Frames;
import Engine.SpriteReader;
import Engine.SpritesheetCreator;
import Engine.Window;

public class Player extends Entity{
	private BufferedImage[] spritesDown,spritesLeft,spritesRight,spritesUp;
	private SpriteReader sprite;
	private double xnext,ynext;
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
			if(right && isFreeRight) {
				position.setX(position.getX()+velocity);
			}else if(left && isFreeLeft) {
				position.setX(position.getX()-velocity);
			}
			if(top && isFreeTop) {
				position.setY(position.getY()-velocity);
			}else if(down && (isFreeDown)) {
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
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int)position.getXRender(),(int)position.getYRender()-32,2,32);
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
	
	public void collisionTile(List<Tile> tile,int width,int height) {
		if(right) {
			xnext=velocity;
		}else if(left) {
			xnext=-velocity;
		}
		if(top) {
			ynext=-velocity;
		}else if(down) {
			ynext=velocity;
		}
		int x1 = (int) (xnext / 16);
		int y1 = (int) (ynext / 16);
		
		int x2 = (int) ((xnext+16-1) / 16);
		int y2 = (int) (ynext / 16);
		
		int x3 = (int) (xnext / 16);
		int y3 = (int) ((ynext+16-1) / 16);
		
		int x4 = (int) ((xnext+16-1) / 16);
		int y4 = (int) ((ynext+16-1) / 16);
		
		if(tile.get(x1 + (y1*width)) instanceof Wall) { 
			
		}
		if(tile.get(x2 + (y2*width)) instanceof Wall) {
			
		}
		if(tile.get(x3 + (y3*width)) instanceof Wall) {
			
		}
		if((tile.get(x4 + (y4*width)) instanceof Ground)) {
			isFreeDown=true;
		}
	}
	
	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
}