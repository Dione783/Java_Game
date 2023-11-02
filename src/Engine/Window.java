package Engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Canvas;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import Entities.GameObjects;
import Entities.UI;
import Entities.World;

public class Window extends Canvas{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	public static int WIDTH,HEIGHT,SCALE;
	private BufferedImage canvas;
	private Dimension dimension;
	private GameObjects objects;
	private World world;
	
	public Window() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		dimension = tk.getScreenSize();
		frame = new JFrame("Window Game #1");
		frame.setPreferredSize(dimension);
		frame.setResizable(true);
		frame.add(this);
		frame.setUndecorated(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		SCALE = 2;
		WIDTH = frame.getWidth();
		HEIGHT = frame.getHeight();
		canvas = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		objects = new GameObjects();
		world = new World(dimension.getWidth(),dimension.getHeight());
	}
	
	public void update() {
		world.update();
		GameObjects.update();
		UI.update();
	}
	
	public void paint(Graphics g) {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		g = canvas.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		if(world == null) {
			return;
		}
		
		world.render(g);
		GameObjects.render(g);
		UI.render(g);
		
		g = bs.getDrawGraphics();
		g.drawImage(canvas,0,0,WIDTH*SCALE,HEIGHT*SCALE,null);
		bs.show();
	}
}
