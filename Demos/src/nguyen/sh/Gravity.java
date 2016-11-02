package nguyen.sh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gravity extends JPanel{
	
	ArrayList<Ball> balls = new ArrayList<Ball>(); 
	Boolean isRunning = true;
	
	
	public Gravity() throws InterruptedException {
		JFrame window = new JFrame("Gravity");
		
		setPreferredSize(new Dimension(400,400));
		setBackground(Color.LIGHT_GRAY);
		
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.pack();
		
		gameLoop();
	}
	
	public void gameLoop() throws InterruptedException {
		
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		
		long lastFpsTime = 0;
		int fps = 0;
		
		balls.add(new Ball());
		
		while(isRunning) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / (double) OPTIMAL_TIME;
			
			
			lastFpsTime += updateLength;
			fps++;
			
			if (lastFpsTime >= 1000000000) {
		         System.out.println("(FPS: "+fps+")");
		         lastFpsTime = 0;
		         fps = 0;
		    }
			
			update();
			
			repaint();
			
			Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
		}
	}
	
	public void update() {
		
	}
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		
		for(int i = 0; i < balls.size(); i++) {
			balls.get(0).render(g2d);
		}
		
	}
	
	
	
	public static void main(String Args[]) throws InterruptedException {
		
		new Gravity();
		
	}
	
}