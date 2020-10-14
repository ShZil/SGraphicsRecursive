import java.awt.Graphics;

class SPixel {
	SColor color;
	int x;
	int y;

	public SPixel(int x, int y) {
		this.x = x;
		this.y = y;
		this.color = Const.BLACK;
	}

	public SPixel(int x, int y, SColor color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public SPixel(Pt loc) {
		this.x = loc.x;
		this.y = loc.y;
		this.color = Const.BLACK;
	}

	public SPixel(Pt loc, SColor color) {
		this.x = loc.x;
		this.y = loc.y;
		this.color = color;
	}

	public void setColor(SColor to) {
		to = to == null ? Const.BLACK : to;
		// System.out.println("SPixel.setColor: color:"+color.toString());
		// System.out.println("SPixel.setColor: to:"+to.toString());
		this.color = to;
	}

	public SPixel copy() {
		return new SPixel(this.x, this.y, this.color);
	}

	public void render(Graphics g) {
		g.setColor(this.color.getColor());
		g.drawLine(this.x, this.y, this.x, this.y);
		// System.out.println("SPixel render(Graphics, 1): @("+this.x+","+this.y+")");
	}

	public void render(Graphics g, int rectSize) {
		if (rectSize < 2) {
			render(g);
		} else {
			g.setColor(this.color.getColor());
			g.fillRect(this.x, this.y, rectSize, rectSize);
			// System.out.println("SPixel render(Graphics, int): @("+this.x+","+this.y+") - " + rectSize);
		}
	}

	public int getAvg() {
		return color.getBrightness();
	}
}
