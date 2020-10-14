public class Draw{
  public GObject Dot(int x, int y, int[] color){
    return GObject(x, y, color);
  }

  public GObject Rect(int x, int y, int w, int h, int[] color){
    return GObject(x, y, w, h, color);
  }
}
