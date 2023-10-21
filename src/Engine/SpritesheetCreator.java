package Engine;

import java.awt.image.BufferedImage;

public class SpritesheetCreator {
	private SpriteReader image;
	BufferedImage[] sprite;
	private int width,height;
	
	public SpritesheetCreator(SpriteReader image,int width,int height) {
		this.image=image;
		this.width=width;
		this.height=height;
	}
	
	public BufferedImage[] createSprite(int x,int y,int numberOfFramesX,int numberOfFramesY) {
		 sprite = new BufferedImage[numberOfFramesX+numberOfFramesY];
		if(numberOfFramesX > 0) {
			for(int i=0;i < sprite.length;i++) {
				sprite[i] = image.getSprite(x+(i*width),y, width, height);
			}
		}
		if(numberOfFramesY > 0){
			for(int i=0;i < sprite.length;i++) {
				sprite[i] = image.getSprite(x,y+(i*height), width, height);
			}
		}
		return sprite;
	}
	
	public void modifySprite(int numberOfSprite,int numberOfSpriteX,int numberOfSpriteY) {
		int x=0,y=0;
		sprite[numberOfSprite] = image.getSprite(x+(numberOfSpriteX*width),y+(numberOfSpriteY*height),width,height);
	}
}