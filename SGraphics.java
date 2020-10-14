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
		current.evaluatePixelGrid();
		previous = current.copy();
		current.render(gr);
		current.print();
	}

	public void drawRect(Rect s, SColor c) {
		this.drawRect(s, new STexture(c));
	}

	public void drawRect(Rect s, STexture t) {
		current.addObject(new SObject(new SRect(s), t));
	}
}

// The java.awt.Graphics docs:
// https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
