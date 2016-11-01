import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	
	int width;
	int height;

	ArrayList<Particle> p = new ArrayList<Particle>();

	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
	}
		
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
			
		for(int i = 0; i < p.size(); i++) {
			
			g.setColor(p.get(i).getColor());
			g2d.fillOval(p.get(i).getX(), p.get(i).getY(), p.get(i).getR(), p.get(i).getR());
		}
	}
	
	public void setP(ArrayList<Particle> p) {
		this.p = p;
	}

}
