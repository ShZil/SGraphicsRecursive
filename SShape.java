abstract class SShape {
  public abstract Pt getPixelByIndex(int index); // Get a 1d array of the points in the shape
  public abstract Rect getBoundingBox(); // Get a rectangluar bounding box of the shape
  public abstract boolean collides(Pt point); // Answers the question: Is the point inside the shape?
  public abstract String toString();
}
