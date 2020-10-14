// The Abstract Idea of a Line

class Ln {
    // Which has two points, start and end.
    // yeah but how would you render it? You wouldn't,  This line is not render-able - It doesn't extend SObject
    Pt a;
    Pt b;

    public Ln(Pt a, Pt b) {
      this.a = a;
      this.b = b;
    }

    public Ln(Pt a, int x, int y) {
      this.a = a;
      this.b = new Pt(x, y);
    }

    public Ln(int x1, int y1, int x2, int y2) {
      this.a = new Pt(x1, y1);
      this.b = new Pt(x2, y2);
    }

  	public Ln copy() {
  		Pt a = this.a.copy();
      Pt b = this.b.copy();
      return new Ln(a, b);
  	}
}
