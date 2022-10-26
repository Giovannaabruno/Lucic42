package View;

public class Pixel {
  public int red;
  public int green;
  public int blue;


  public Pixel( int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  // will return which either is larger
  //Value: the maximum value of the three components for each pixel
  public int getValue() {
    return Math.max( red,Math.max(green,blue));
  }
  //Intensity: the average of the three components for each pixel
  public int getIntensity() {
    return(int)((red + green + blue) / 3.0);

  }
  // Luma: the weighted sum (0.2126r + 0.7152g + 0.0722b
  // red green and blue will be around a range of 0-1
  public int getLuma() {
    return (int)(0.2126*red + 0.7152*green + 0.0722*blue);


  }




}
