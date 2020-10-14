import java.awt.Graphics;

class SGraphics {
	Graphics g;
	SFrame previous = null;
	SFrame current;
	int sizeX;
	int sizeY;

	public SGraphics(Graphics g, int sizeX, int sizeY) {
		this.g = g;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		current = new SFrame(sizeX, sizeY);
	}

	public void finishFrame(Graphics gr) {
		previous = current.copy();
		current.render(gr);
		current.print();
	}
}

// The java.awt.Graphics docs:
// @see https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
