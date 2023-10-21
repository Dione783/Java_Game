package Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entities.GameObjects;

public class GameEngine implements Runnable,KeyListener{

	private Thread thread;
	private boolean isRunning;
	private Window window;
	
	public GameEngine() {
		window = new Window();
		start();
		window.addKeyListener(this);
	}
	
	private synchronized void start()
	{
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	private synchronized void stop()
	{
		isRunning=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames=0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
			long now = System.nanoTime();
			delta+=(now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				window.update();
				window.paint(null);
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000){
				frames=0;
				timer+=1000;
			}
		}
		stop();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_A) {
			GameObjects.getPlayer().setLeft(true);
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			GameObjects.getPlayer().setRight(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			GameObjects.getPlayer().setTop(true);
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			GameObjects.getPlayer().setDown(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_A) {
			GameObjects.getPlayer().setLeft(false);
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			GameObjects.getPlayer().setRight(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			GameObjects.getPlayer().setTop(false);
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			GameObjects.getPlayer().setDown(false);
		}
	}
}