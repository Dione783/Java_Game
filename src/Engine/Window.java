package Engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Canvas;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Entities.GameObjects;
import Entities.Player;

public class Window extends Canvas{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private int WIDTH,HEIGHT;
	private BufferedImage canvas;
	private Dimension dimension;

	public Window() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		frame = new JFrame("Window Game #1");
		dimension = tk.getScreenSize();
		frame.setPreferredSize(dimension);
		frame.setResizable(true);
		frame.add(this);
		frame.setUndecorated(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		WIDTH = frame.getWidth();
		HEIGHT = frame.getHeight();
		canvas = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		GameObjects.init();
	}
	
	
	public void update() {
		GameObjects.update();
	}
	

	public void paint(Graphics g) {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		g = canvas.getGraphics();
		g.setColor(Color.green);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		GameObjects.render(g);
		
		g = bs.getDrawGraphics();
		g.drawImage(canvas,0,0,WIDTH,HEIGHT,null);
		bs.show();
	}
}
