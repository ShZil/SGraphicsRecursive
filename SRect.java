// A Draw-able Rectangle

class SRect extends SShape {
  Rect rect;
  // Automatically contains shape and texture. I hope.

  public SRect(int w, int h){
    this.rect = new Rect(w, h);
  }

  public SRect(int[] values){
    int h = values[2];
    int w = values[3];
    this.rect = new Rect(h, w);
  }

  public SRect(Rect rect){
    this.rect = rect;
  }
  // Why is there no Texture in the constructors? Magic.

  public Pt getPixelByIndex(int index) {
    return rect.getPositionByIndex(index);
  }

  public Rect getBoundingBox() {
    return rect;
  }

  public boolean collides(Pt point) {
    return rect.collides(point);
  }

  public SRect copy() {
    return new SRect(this.rect.copy());
  }

  // Format:
  // "Rectangle:rect"
  public String toString() {
    return "Rectangle:"+rect.toString();
  }
}
