class STexture {
  // Textures can currently be:
  private static final int NONE = 0;
  private static final int COLOR = 1;

  private int mode;

  SColor color;

  public STexture() {
    mode = STexture.NONE;
    color = Const.BLACK;
  }

  public STexture(SColor c) {
    mode = STexture.COLOR;
    color = c;
  }

  // The important method here. Returns a color based on the location.
  public SColor getColorByPosition(Pt pos) {
    SColor toReturn = Const.BLACK;
    switch (mode) {
      case STexture.NONE:
         toReturn = Const.BLACK;
        break;
      case STexture.COLOR:
         toReturn = color;
        break;
    }
    return toReturn;
  }

  public SColor getColorByPosition(int x, int y) {
    return getColorByPosition(new Pt(x, y));
  }

  public SColor getColorByPosition(int[] pos) {
    return getColorByPosition(new Pt(pos[0], pos[1]));
  }

  public STexture copy() {
    return new STexture(this.color);
  }

  // Format:
  // "NONE" or "COLOR=color"
  public String toString() {
    String toReturn = "STexture"; // A placeholder in case the mode doesn't fit NONE or COLOR, and we forgot to add a string-ify-er for the new mode.
    switch (mode) {
      case STexture.NONE:
         toReturn = "NONE";
        break;
      case STexture.COLOR:
         toReturn = "COLOR="+color.toString();
        break;
    }
    return toReturn;
  }
}
