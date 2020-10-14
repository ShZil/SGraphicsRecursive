public class PixelArray{
  public Pixel[] array = new Pixel[0];


  public void append(Pixel pixel){
    Pixel[] newArray = new Pixel[this.array.length + 1];
    for (int i = 0; i < this.array.length; i++){
      newArray[i] = this.array[i];
    }
  }

  public void concat(Pixel[] array){
    for (Pixel pixel : array){
      this.append(pixel);
    }
  }
}
