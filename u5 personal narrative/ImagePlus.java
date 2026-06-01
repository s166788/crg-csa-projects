import org.code.theater.*;
import org.code.media.*;

public class ImagePlus extends Image {
  private Pixel[][] pixels;    // The 2D array of pixels
  
  public ImagePlus(String filename) {
    super(filename);
    pixels = initializePixels();
  }
  
  /**
   * Initializes the 2D pixel array from the image
   * Precondition: Image file exists
   * Postcondition: pixels array is filled
   */
  public Pixel[][] initializePixels() {
    int h = getHeight();
    int w = getWidth();
    Pixel[][] temp = new Pixel[h][w];
    
    for (int row = 0; row < h; row++) {
      for (int col = 0; col < w; col++) {
        temp[row][col] = super.getPixel(col, row);
      }
    }
    return temp;
  }
  
  public Pixel[][] getPixels() {
    return pixels;
  }
    
  /**
   * Adjusts image intensity/brightness
   * Precondition: intensity is greater than 0
   * Postcondition: adjusts image colors
   */
  public void adjustIntensity(double intensity) {
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        Pixel p = pixels[i][j];
        
        // Math.min caps intensity at 255
        int r = (int) Math.min(p.getRed() * intensity, 255);
        int g = (int) Math.min(p.getGreen() * intensity, 255);
        int b = (int) Math.min(p.getBlue() * intensity, 255);

        // Sets pixel's new values
        p.setRed(r);
        p.setGreen(g);
        p.setBlue(b);
      }
    }
  }
}
