package Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameObjects {
	private static Player player;
	private static List<Entitie> objects;

	public GameObjects() {
		
	}
	
	public static void update() {
		for(Entitie e : objects) {
			e.update();
		}
	}
	
	public static void render(Graphics g) {
		for(Entitie e : objects) {
			e.render(g);
		}
	}
	
	public static void init() {
		objects = new ArrayList<Entitie>();
		player = new Player();
		objects.add(getPlayer());
	}

	public static Player getPlayer() {
		return player;
	}
	
	public static void addEntity() {
		
	}
	
}