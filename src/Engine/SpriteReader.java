package Engine;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteReader {
		private BufferedImage image;
		
		public SpriteReader(String path){
			try {
				image = ImageIO.read(getClass().getResource(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public BufferedImage getSprite(int x,int y,int width,int height) {
			if(image != null) {
				try {
					return image.getSubimage(x,y,width,height);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
}
