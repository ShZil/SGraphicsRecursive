// The Abstract Idea of a Point.

class Pt {
	int x;
	int y;

	public Pt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pt(int[] loc) {
		this.x = loc[0];
		this.y = loc[1];
	}

	public Pt(Pt other) {
		this.x = other.x;
		this.y = other.y;
	}

	public Pt copy() {
		return new Pt(this.x, this.y);
	}

	public Pt add(Pt other) {
		this.x += other.x;
		this.y += other.y;
		return this;
	}

	public Pt add(int x, int y) {
		return this.add(new Pt(x, y));
	}

	public Pt add(int[] loc) {
		return this.add(new Pt(loc));
	}

	public Pt sub(Pt other) {
		this.x -= other.x;
		this.y -= other.y;
		return this;
	}

	public Pt sub(int x, int y) {
		return this.sub(new Pt(x, y));
	}

	public Pt sub(int[] loc) {
		return this.sub(new Pt(loc));
	}

	public Pt mult(Scale scale) {
		this.x *= scale.x;
		this.y *= scale.y;
		return this;
	}

	public Pt div(Scale scale) {
		this.x /= scale.x;
		this.y /= scale.y;
		return this;
	}
}
