import org.code.theater.*;
import org.code.media.*;
import java.util.Scanner;
import java.io.File;

public class DataReader {
  int[] hsGrads = new int[11];
  int[] bachelors = new int[11];
    
  Scanner hsReader = new Scanner(new File("hsGrad.txt"));
  Scanner bachReader = new Scanner(new File("bachelors.txt"));  
  
  public DataReader() throws Exception {
    for(int i = 0; i < 11; i++) {
        // Reads int values from hsGrad.txt and copies them onto the hsGrads array
        if(hsReader.hasNextInt()) {
          hsGrads[i] = hsReader.nextInt();
        }
        // Reads int values from bachelors.txt and copies them onto the bachelors array
        if(bachReader.hasNextInt()) {
          bachelors[i] = bachReader.nextInt();
        }
      }
  }


  /**
   * Calculates the gap between wages for each year
   * Precondition: hsGrads must be defined
   * Postcondition: Will return a double array with hsGrads.length length
   */
  public double[] getWageGapArray() {
    double[] gap = new double[hsGrads.length];
    for (int i = 0; i < hsGrads.length; i++) {
      // Use Math.abs to make sure the difference is positive
      int difference = Math.abs(bachelors[i] - hsGrads[i]);
      // Calculate percentage and round it using Math.round
      gap[i] = Math.round((double) difference / hsGrads[i] * 100.0);
    }
    return gap;
  }
    
  

  /**
   * Accessor methods
   */
  
  public int[] getHsArray() {
    return hsGrads;
  }

  public int[] getBachArray() {
    return bachelors;
  }


}
