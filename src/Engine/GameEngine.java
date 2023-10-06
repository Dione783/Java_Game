package Engine;


public class GameEngine implements Runnable{

	private Thread thread;
	private boolean isRunning;
	private static Window window;
	
	public GameEngine() {
		window = new Window();
		start();
	}
	
	private synchronized void start()
	{
		thread = new Thread(this);
		isRunning=true;
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
				Window.update();
				window.paint(null);
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000){
				System.out.println(frames);
				frames=0;
				timer+=1000;
			}
		}
		stop();
	}
}
