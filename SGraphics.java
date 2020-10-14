import java.awt.Graphics;

class SGraphics {
	Graphics g; // The normal java.awt.Graphics. I think this is not really useful
	//, since you can't put Graphics on hold like that.
	SFrame previous = null; // The previous frame. Currently doesn't do anything,
	//it might in the future (Optimization ideas and such)
	SFrame current; // The current frame. Does that need explaining?
	// Size of the canvas
	int sizeX;// int X
	int sizeY;// int Y

	public SGraphics(Graphics g, int sizeX, int sizeY) {
		this.g = g;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		current = new SFrame(sizeX, sizeY);
	}

	public void finishFrame(Graphics gr) {
		// System.out.println("SGraphics.finishFrame(): "+gr);
		current.evaluatePixelGrid(); // Converts all the SObjects to pixels and stores them
		previous = current.copy(); // Refreah the previous frame.
		current.render(gr); // Renders
		current.print(); // Prints data about the operation
	}

	// draw a Rectangle
	public void drawRect(Rect s, SColor c) {
		this.drawRect(s, new STexture(c));
	}

	public void drawRect(Rect s, STexture t) {
		current.addObject(new SObject(new SRect(s), t));
	}
}

// The java.awt.Graphics docs:
// https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
