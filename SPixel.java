import java.awt.Graphics;

class SPixel {
	// A pixel has a location and a color.
	SColor color;
	int x;
	int y;

	public SPixel(int x, int y) {
		this.x = x;
		this.y = y;
		this.color = Const.BLACK; // Default color is black
	}

	public SPixel(int x, int y, SColor color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public SPixel(Pt loc) {
		this.x = loc.x;
		this.y = loc.y;
		this.color = Const.BLACK; // Default color is black
	}

	public SPixel(Pt loc, SColor color) {
		this.x = loc.x;
		this.y = loc.y;
		this.color = color;
	}

	// Change the color of the pixel.
	public void setColor(SColor to) {
		// System.out.println("SPixel.setColor: color:"+color.toString());
		to = to == null ? Const.BLACK : to;
		// System.out.println("SPixel.setColor: to:"+to.toString());
		this.color = to;
	}

	public SPixel copy() {
		return new SPixel(this.x, this.y, this.color);
	}

	public void render(Graphics g) {
		// System.out.println("SPixel.render: Graphics g: "+g);
		// System.out.println("SPixel.render(): this.color: "+this.color);
    g.setColor(this.color.getColor());
    g.drawLine(this.x, this.y, this.x, this.y); // MASSIVELY NEEDS OPTIMIZATION
	}

	public int getAvg() {
		return color.getBrightness();
	}
}
