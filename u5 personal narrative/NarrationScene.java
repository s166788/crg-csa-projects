import org.code.theater.*;
import org.code.media.*;

public class NarrationScene extends Scene {
  
  private String[][] libraryData;
  
  public NarrationScene(String[][] libraryData) {
    this.libraryData = libraryData;
  }
  
  /**
   * Displays a book review
   * Precondition: bookIndex is valid
   * Postcondition: Book is drawn on screen
   */
  public void displayBook(int bookIndex) {
    String name = libraryData[bookIndex][0];
    String review = libraryData[bookIndex][1];
    String thoughts = libraryData[bookIndex][2];
    
    // Set background color based on rating
    if (review.contains("5")) {
      clear("purple");
    } else if (review.contains("4.9")) {
      clear("blue");
    } else {
      clear("teal");
    }
    
    // Shows title
    setTextHeight(25);
    setTextColor("white");
    drawText(name, 20, 40);
    
    // Shows rating
    setTextHeight(20);
    drawText(review, 20, 80);
    
    // Shows thoughts
    setTextHeight(16);
    String[] lines = thoughts.split("\n");
    int y = 120;
    for (int i = 0; i < lines.length; i++) {
      drawText(lines[i], 20, y);
      y += 22;
    }
    
    pause(5);
    
    clear("black");
    
    ImagePlus cover = new ImagePlus("book" + (bookIndex + 1) + ".jpg");
    
    drawImage(cover, 100, 50, 200);
    pause(1);

    // Uses image filter to adjust intensity of the book based on how much I liked it
    if (bookIndex == 0) {
      cover.adjustIntensity(1.3); // Book 1 - brighter
    } else if (bookIndex == 1) {
      cover.adjustIntensity(1.5); // Book 2 - very bright
    } else {
      cover.adjustIntensity(1.99); // Book 3 - slightly bright
    }
    
    drawImage(cover, 100, 50, 200);

    
    pause(2);
  }
  
  /**
   * Shows all books
   */
  public void showAll() {
    for (int i = 0; i < libraryData.length; i++) {
      displayBook(i);
    }
  }
}
