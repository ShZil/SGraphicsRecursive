import java.awt.Graphics;

class SPixelGrid {
  // A grid is a 2d array. And yes, I stored the Width and Height seperately.
  SPixel[][] pixels;
  int width;
  int height;

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

  // Convert SObject o to pixels and add them to SPixel[][] pixels.
  public void drawObject(SObject o) {
    // Only go over the pixels in the bounding box, and not all pixels in the panel [Optimization]
    Rect boundingBox = o.getBoundingBox();
    for (int i = 0; i < boundingBox.getSize(); i++) {
      // Get the pixel point.
      Pt point = boundingBox.getPositionByIndex(i);
      if (point == null) {
        continue;
      }
      // Add the point to the SPixel[][] pixels, overriding any previous colors.
      if (o.getPixel(point) == null) {
        continue;
      } else {
        pixels[point.x][point.y].setColor(o.getPixel(point));
      }
      // Printing what happened because this code doesn't work :(
      System.out.println("Point was altered: X="+point.x+", Y="+point.y+", To="+o.getPixel(point).getBrightness());
    }
  }

  // Initiallize the SPixel[][] pixels with Const.BLACK (Default color) Background.
  public void construct() {
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[i].length; j++) {
        pixels[i][j] = new SPixel(i, j, Const.BLACK);
      }
    }
  }

  // Go over each pixel and render them. LAGGY OPERATION - Optimization required!
  public void render(Graphics gr) {
    // System.out.println("SPixelGrid.render(): "+gr);
    for (int i = 0; i < pixels.length; i++) {
      if (i % 20 == 0) { // Don't spam the console too much
      System.out.println("Hello, I just rendered column #"+i);
    }
    for (int j = 0; j < pixels[i].length; j++) {
      pixels[i][j].render(gr);
    }
  }
}

// Convert the SPixelGrid to printable String.
// Format:
// "SPixelGrid: (width, height)
// [0, 0, 0, 0, 0],
// [0, 0, 0, 0, 0],
// [0, 0, 0, 0, 0],
// [0, 0, 0, 0, 0],
// [0, 0, 0, 0, 0]"
public String toString(int jump) {
  String out = "SPixelGrid: ("+width+","+height+")\n";
  for (int i = 0; i < pixels.length - jump; i+=jump) {
    out += "[";
    for (int j = 0; j < pixels[j].length - jump; j+=jump) {
      out += pixels[i][j].getAvg();
      out += ", ";
    }
    out = out.substring(0, out.length() - 2) + "],\n[";
  }
  out = out.substring(0, out.length() - 3) + "]";
  return out;
}

  // Defining default int jump value.
  public String toString() {
    return this.toString(20);
  }
}
