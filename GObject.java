public class GObject{
  public PixelArray pixelArray = new PixelArray();

  public GObject(int x, int y, int[] color){
    // const for a a single dot
    this.pixelArray.append(new Pixel(x, y, color));
  }

  public GObject(int x, int y, int w, int h, int[] color){
    // const for a rect
    // this loop may not work properly bc so if you get a wrong rect, check here
    for (int i = 0; i < w; i++){
      for (int j = 0; j < h; i++){
        this.pixelArray.append(new Pixel(x + i * w, y + j * h, color));
      }
    }
  }
}
