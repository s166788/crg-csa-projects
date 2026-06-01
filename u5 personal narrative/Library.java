import org.code.theater.*;
import org.code.media.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Library {
  // 2D array to store all book data
  // Each row represents one book
  // columns have [name, review, thoughts]
  private String[][] libraryData;
  private static final int MAX_BOOKS = 3;
  private int bookCount = 0;
  
  public Library(String booksFilename, String reviewsFilename, String thoughtsFilename) throws FileNotFoundException {
    libraryData = new String[MAX_BOOKS][3];

    // Creates file and scanner objects to parse text files
    File booksFile = new File(booksFilename);
    File reviewsFile = new File(reviewsFilename);
    File thoughtsFile = new File(thoughtsFilename);
    
    Scanner scanner1 = new Scanner(booksFile);
    Scanner scanner2 = new Scanner(reviewsFile);
    Scanner scanner3 = new Scanner(thoughtsFile);
    
    int row = 0;
    while(scanner1.hasNextLine() && row < MAX_BOOKS) {
      String book = scanner1.nextLine();
      String review = scanner2.nextLine();
      String thoughts = scanner3.nextLine();
      
      // Store in the current row and move to next
      libraryData[row][0] = book;
      libraryData[row][1] = review;
      libraryData[row][2] = thoughts;
      
      row++;
      bookCount++;
    }

    formatThoughts(200);
    
    scanner1.close();
    scanner2.close();
    scanner3.close();
  }
  
  public String[][] getLibraryData() {
    return libraryData;
  }
  
  public int getBookCount() {
    return bookCount;
  }

  /**
   * Formats thoughts by adding new lines every n characters
   * Precondition: n > 0 and libraryData has been initialized
   * Postcondition: thoughts in third column of libraryData have newline characters
   */
  public void formatThoughts(int n) {
    // Traverse each book in the 2D array
    for (int row = 0; row < bookCount; row++) {
      String thoughts = libraryData[row][2];
      String formatted = "";
      String remaining = thoughts;
      
      while (remaining.length() > 0) {
        if (remaining.length() <= n) {
          formatted += remaining;
          break;
        }
        
        // Find the last space within n characters
        int splitIndex = remaining.lastIndexOf(" ", n);
        
        if (splitIndex == -1) {
          // Split with hyphen
          formatted += remaining.substring(0, n) + "-\n";
          remaining = remaining.substring(n);
        } else {
          // Split at space and add newline
          formatted += remaining.substring(0, splitIndex) + "\n";
          remaining = remaining.substring(splitIndex + 1); // Skip the space
        }
      }
      
      // Update the thoughts in the 2D array
      libraryData[row][2] = formatted;
    }
  }

}
