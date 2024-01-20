package Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameObjects {
	private static Player player;
	private static List<Entity> objects;
	
	public GameObjects() {
		objects = new ArrayList<Entity>();
		player = new Player(100,100,16,32);
		objects.add(new Bizzz(20,20,16,32));
		objects.add(player);
	}
	
	public static void update() {
		for(Entity e : objects) {
			e.update();
		}
	}
	
	public static void render(Graphics g) {
		for(Entity e : objects) {
			e.render(g);
		}
	}
	
	public static Player getPlayer() {
		return GameObjects.player;
	}
	
	public static void addEntity(Entity e) {
		objects.add(e);
	}
	
}