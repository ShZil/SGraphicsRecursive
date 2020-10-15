import java.awt.Graphics;

class SPixelGrid {
  SPixel[][] pixels;
  int width;
  int height;
  double r_z;
  double g_z;
  double b_z;
  double s_z;
  final int defaultJump = 512;
  final int delayBetweenResolutionChanges = 500;
  final double perlinMultiplier = 1/100.0;
  final int threshold = 0; // 0-254
  final boolean doSigmoid = true; // Answers the question "Do the sigmoid function on the pixels' color?"
  final int mode = Const.RGB; // Const.RGB or Const.GRAYSCALE

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

  public void construct() {
    r_z = Math.random() * 128;
    g_z = Math.random() * 128;
    b_z = Math.random() * 128;
    s_z = Math.random() * 128;
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[i].length; j++) {
        // pixels[i][j] = new SPixel(i, j, Const.BLACK);
        switch (mode) {
          case Const.GRAYSCALE:
          pixels[i][j] = new SPixel(i, j, new SColor(
          SUtil.constrainColor((int)(
          ImprovedNoise.noise(i*perlinMultiplier, j*perlinMultiplier, s_z)*255
          ), threshold, 255, doSigmoid
          )
          ));
          break;
          case Const.RGB:
          pixels[i][j] = new SPixel(i, j, new SColor(
          SUtil.constrainColor((int)(
          ImprovedNoise.noise(i*perlinMultiplier, j*perlinMultiplier, r_z)*255
          ), threshold, 255, doSigmoid
          ),
          SUtil.constrainColor((int)(
          ImprovedNoise.noise(i*perlinMultiplier, j*perlinMultiplier, g_z)*255
          ), threshold, 255, doSigmoid
          ),
          SUtil.constrainColor((int)(
          ImprovedNoise.noise(i*perlinMultiplier, j*perlinMultiplier, b_z)*255
          ), threshold, 255, doSigmoid
          )
          ));
          break;
          default:
          pixels[i][j] = new SPixel(i, j, new SColor());
        }
      }
    }
  }

  public void render(Graphics gr) {
    for (int i = SUtil.min(width, height); i >= 1; i /= 2) {
      System.out.println("Frame Resolution Change: "+i);
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
        Thread.sleep(delayBetweenResolutionChanges);
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
    int decimalDigits = 5;
    String out = "SPixelGrid: ("+width+","+height+")\nRGBS Z values: ("+
    SUtil.formatNumber(r_z, decimalDigits, SUtil.AFTER_DOT_LIMIT)+","+
    SUtil.formatNumber(g_z, decimalDigits, SUtil.AFTER_DOT_LIMIT)+","+
    SUtil.formatNumber(b_z, decimalDigits, SUtil.AFTER_DOT_LIMIT)+"), "+
    SUtil.formatNumber(s_z, decimalDigits, SUtil.AFTER_DOT_LIMIT)+"\n";
    if (jump < pixels.length) {
      for (int i = 0; i < pixels.length - jump; i+=jump) {
        out += "[";
        for (int j = 0; j < pixels[j].length - jump; j+=jump) {
          out += SUtil.formatNumber(pixels[i][j].getAvg(), 3, SUtil.CONSTANT_LENGTH);
          out += ", ";
        }
        out = out.substring(0, out.length() - 2) + "],\n[";
      }
      out = out.substring(0, out.length() - 3) + "]";
    }
    return out;
  }

  public String toString() {
    return this.toString(defaultJump);
  }
}
