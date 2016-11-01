import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class Particle {
	private int x;
	private int y;
	private int vx;
	private int vy;
	private boolean exploded = false;
	private int lifespan = 255;
	private int r;
	private int g;
	private int b;
	private Color col;
	private int width;
	private int height;
	
	
	private int gravity;
	private int radius;
	
	public Particle(int width, int height) {
		this.width = width;
		this.height = height;
		
		x = ThreadLocalRandom.current().nextInt(20, width - 20);
		y = 799;
		vx = 0;
		vy = ThreadLocalRandom.current().nextInt(-55, -40);
		gravity = 2;
		radius = ThreadLocalRandom.current().nextInt(4, 6);
		
		r = ThreadLocalRandom.current().nextInt(0, 255);
		g = ThreadLocalRandom.current().nextInt(0, 255);
		b = ThreadLocalRandom.current().nextInt(0, 255);
		
		col = new Color(r,g,b);
	}
	
	public Particle(int x, int y, Color color, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		vx = ThreadLocalRandom.current().nextInt(-10, 10);
		vy = ThreadLocalRandom.current().nextInt(-10, 10);
		gravity = 1;
		col = color;
		radius = 3;
	}
	
	public void moveParticle() {
		vy = vy + gravity;
		y = y + vy;
		x = x + vx;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getVy(){
		return vy;
	}
	
	public int getR(){
		return radius;
	}
	
	public boolean getExploded() {
		return exploded;
	}
	
	public void setExploded(boolean exploded) {
		this.exploded = exploded;
		lifespan = 0;
	}
	
	public float getLifespan() {
		return lifespan;
	}
	
	public void setLifespan() {
		if(lifespan - 10 < 0){ 
			lifespan = 0;
		} else {
			lifespan -= 15;
		}
	}
	
	public Color getColor() {
		return col;
	}
		
	public void setFireworksColor() {
		col = new Color(col.getRed(), col.getGreen(), col.getBlue(), lifespan);
	}
}
