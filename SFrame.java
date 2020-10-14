import java.awt.Graphics;

class SFrame {
	SPixelGrid pg;

	public SFrame(int w, int h) {
		pg = new SPixelGrid(w, h);
	}

	public void render(Graphics gr) {
		System.out.println(pg.toString());
		pg.render(gr);
	}

	public SFrame copy() {
		int w = this.pg.width;
		int h = this.pg.height;
		SFrame frame = new SFrame(w, h);
		return frame;
	}

	// As the frame finished rendering:
	public void print() {
		System.out.println("Click on the Frame to Repaint!");
	}
}
