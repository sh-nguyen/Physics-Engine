import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JPanel{	
	
	// Declare Arrays for objects
	ArrayList<Particle> particles = new ArrayList<Particle>();
	ArrayList<Particle> fireworks = new ArrayList<Particle>();
	ArrayList<Particle> painter = new ArrayList<Particle>();
	ArrayList<Float> alpha = new ArrayList<Float>();
	
	//---//
	public int width = 1280;
	public int height = 800;
	public int fps = 45;
	//---//
	
	public Main() throws InterruptedException {
		//Create window canvas
		JFrame window = new JFrame("Fireworks");	
		Canvas c = new Canvas(width, height);
		window.add(c);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Simulation Loop
		while(true) {	
			
			// 1 in 5 chance to create a particle
			if(Math.random() < 0.2) {
				Particle p = new Particle(width, height);
				particles.add(p);
			}
			
			// Updates state of each particle
			for(int i = particles.size()-1; i >= 0; i--) {
				if(particles.get(i).getExploded() == false) {
					particles.get(i).moveParticle();
					if(particles.get(i).getVy() > 0) {
						particles.get(i).setExploded(true);
						exploded(particles.get(i).getX(), particles.get(i).getY(), particles.get(i).getColor());
						particles.remove(i);
						
					}
				} 
				
				
			}
			
			// Updates state of each firework
			for(int i = fireworks.size()-1; i >= 0; i--) {
				fireworks.get(i).moveParticle();
				fireworks.get(i).setLifespan();
				fireworks.get(i).setFireworksColor();
				if(fireworks.get(i).getY() > 800 || fireworks.get(i).getLifespan() <= 0) {
					fireworks.remove(i);
				}
				
			}
			
			// Creates ArrayList of particles and fireworks
			painter = new ArrayList<Particle>();
			painter.addAll(particles);
			painter.addAll(fireworks);
			c.setP(painter);
			
			// Repaints the canvas
			c.repaint();
			
			// Wait for 20ms
			Thread.sleep((int)1000/fps);					
		}
	}
	
	// Create 25 firework particles when velocity < 0
	public void exploded(int x, int y, Color color) {
		for(int i = 0; i < 25; i++) {
			Particle f = new Particle(x , y, color, width, height);
			fireworks.add(f);
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		Main mainLoop = new Main();		
	}
}
