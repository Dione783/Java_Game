package Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Inputs implements KeyListener,MouseListener{
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A) {
			System.out.println();
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			System.out.println();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
