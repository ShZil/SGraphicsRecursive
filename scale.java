// The Abstract Idea in ShZil's mind of having a class to make Pt.mult logical.
// cool and all but why tho
// "to make Pt.mult logical."

class Scale {
  float x;
  float y;

  public Scale(float x, float y) {
		this.x = x;
		this.y = y;
	}

  public Scale(float s) {
		this.x = s;
		this.y = s;
	}

	public Scale(float[] loc) {
		this.x = loc[0];
		this.y = loc[1];
	}

  public Scale(int x, int y) {
		this.x = (float)x;
		this.y = (float)y;
	}

  public Scale(int s) {
		this.x = (float)s;
		this.y = (float)s;
	}

	public Scale(int[] loc) {
		this.x = (float)loc[0];
		this.y = (float)loc[1];
	}

	public Scale(Scale other) {
		this.x = other.x;
		this.y = other.y;
	}


	public Scale copy() {
		return new Scale(x, y);
	}
}
