import java.awt.Graphics;

class SPixelGrid {
  SPixel[][] pixels;
  int width;
  int height;
  final int defaultJump = 16;
  final int delayBetweenResulotionChanges = 500;

  public SPixelGrid(int w, int h) {
    width = w;
    height = h;
    pixels = new SPixel[width][height];
    construct();
  }

  public SPixelGrid(Rect d) {
    width = d.w;
    height = d.h;
    pixels = new SPixel[width][height];
    construct();
  }

  public void drawObject(SObject o) {
    Rect boundingBox = o.getBoundingBox();
    for (int i = 0; i < boundingBox.getSize(); i++) {
      Pt point = boundingBox.getPositionByIndex(i);
      if (point == null) {
        continue;
      }
      if (o.getPixel(point) == null) {
        continue;
      } else {
        pixels[point.x][point.y].setColor(o.getPixel(point));
      }
      if (point.x % defaultJump == 0 && point.y % defaultJump == 0) {
        System.out.println("Point was altered: X="+point.x+", Y="+point.y+", To="+o.getPixel(point).getBrightness());
      }
    }
  }

  public void construct() {
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[i].length; j++) {
        // pixels[i][j] = new SPixel(i, j, Const.BLACK);
        pixels[i][j] = new SPixel(i, j, SUtil.getRandomColor());
      }
    }
  }

  public void render(Graphics gr) {
    for (int i = SUtil.min(width, height); i >= 1; i /= 2) {
      System.out.println("Frame Resulotion Change: "+i);
      // int i = SUtil.min(width, height) / 8;
      for (int x = 0; x < width; x+=i) {
        // if (x % defaultJump == 0) {
        //   System.out.println("Hello, I just rendered column #" + SUtil.formatNumber(x, 3, SUtil.CONSTANT_LENGTH));
        // }
        for (int y = 0; y < height; y+=i) {
          pixels[x][y].render(gr, i);
        }
      }
      try {
        Thread.sleep(delayBetweenResulotionChanges);
      } catch (InterruptedException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  // Format:
  // "SPixelGrid: (width, height)
  // [000, 000, 000, 000, 000],
  // [000, 000, 000, 000, 000],
  // [000, 000, 000, 000, 000],
  // [000, 000, 000, 000, 000],
  // [000, 000, 000, 000, 000],"
  public String toString(int jump) {
    String out = "SPixelGrid: ("+width+","+height+")\n";
    for (int i = 0; i < pixels.length - jump; i+=jump) {
      out += "[";
      for (int j = 0; j < pixels[j].length - jump; j+=jump) {
        out += SUtil.formatNumber(pixels[i][j].getAvg(), 3, SUtil.CONSTANT_LENGTH);
        out += ", ";
      }
      out = out.substring(0, out.length() - 2) + "],\n[";
    }
    out = out.substring(0, out.length() - 3) + "]";
    return out;
  }

  public String toString() {
    return this.toString(defaultJump);
  }
}
