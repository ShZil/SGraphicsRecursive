// Everything that can be drawn. A rectangle, circle, oval, triangle, line,
// image, will all extend this class. - waste of memory
// No it's not. It's actually quite easy on the memory, since java is highly optimized for class polymorphism (super/sub classes)

class SObject {
	SShape s;
	STexture t;

	public SObject(SShape s, STexture t) {
		this.s = s;
		this.t = t;
	}

	// An Object's bounding box is the bound box of it's shape.
	public Rect getBoundingBox() {
		return s.getBoundingBox();
	}

	public SColor getPixel(int x, int y) {
		return getPixel(new Pt(x, y));
	}

	// get a pixel color - if it collides with the shape, then get the texture for this point.
	public SColor getPixel(Pt a) {
		if (s.collides(a)) {
			return t.getColorByPosition(a);
		} else {
			return null;
		}
	}

	public SObject copy() {
		return new SObject(s, t);
	}

	// Format:
	// "SObject#shape#texture"
	public String toString() {
		return "SObject#" + s.toString() + "#" + t.toString();
	}
}
