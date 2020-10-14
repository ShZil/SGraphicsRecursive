// The Abstract Idea of a Rectangle

class Rect {
  int w;
  int h;
  Pt origin;

  public Rect(int w, int h) {
    this.w = w;
    this.h = h;
    this.origin = new Pt(0, 0);
  }

  public Rect(int w, int h, Pt origin) {
    this.w = w;
    this.h = h;
    this.origin = origin;
  }

  public Rect(Pt origin, int w, int h) {
    this.w = w;
    this.h = h;
    this.origin = origin;
  }

  public int getSize() {
    return w * h;
  }

  public Pt getPositionByIndex(int i) {
    return this.getPositionByCoordinates(i % w, i / w);
  }

  public Pt getPositionByCoordinates(int x, int y) {
    return origin.copy().add(x, y);
  }

  public boolean collides(Pt point) {
    if (origin.x < point.x){
      if (origin.y < point.y){
        if (origin.x + w > point.x){
          if (origin.y + h > point.y){
            return true;
          }
        }
      }
    }
    return false;
  }

  public Rect copy() {
    return new Rect(this.w, this.h);
  }

  // Format:
  // "Rect:x/y/w/h"
  public String toString() {
    return "Rect:"+origin.x+"/"+origin.y+"/"+w+"/"+h;
  }
}
