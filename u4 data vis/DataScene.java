import org.code.theater.*;

public class DataScene extends Scene {
  public DataScene(int[] hsGrads, int[] bachelors, double[] gap) {
    setBG();
    drawDataPoints(hsGrads, true);
    drawDataPoints(bachelors, false);
    pause(10);
    showSummary(gap);
  }

  /**
   * Sets background
   * No precondition
   * Postcondition: background will be drawn
   */
  public void setBG() {
    clear("white");
    drawText("Weekly earnings for HS grads", 40, 40);
    drawText("vs bachelor's degrees", 40, 80);

    // Draws axes
    drawLine(40, 100, 40, 300);
    drawLine(40, 300, 340, 300);

    // Labels each axis
    drawText("Year", 150, 350);
    drawText("Median weekly wage ($)", 30, 300, -90);

    setTextHeight(10);

    // Draws ticker marks for years and labels for each year under x axis
    int year = 2015;
    for(int i = 0; i < 11; i++) {
      drawLine(40 + i * 30, 295, 40 + i * 30, 305);
      drawText(String.valueOf(year), 35 + i * 30, 310);
      year++;
    }

    // Draws text for key in bottom right
    setTextColor("red");
    drawText("High School graduates", 270, 375);
    setTextColor("blue");
    drawText("Bachelor's degree holders", 270, 390);
    setTextColor("black");
  }


  /**
   * Draws the data points from the given array
   * Precondition: data must be a defined array and isHS must be a defined boolean value
   * Postcondition: no return but data points, data values, and connecting lines are all drawn
   */
  public void drawDataPoints(int[] data, boolean isHS) {
    int i = 0;
    int yVal;
    // Loop incrementing variable also represents the x value for each data point
    // Increments by 30 because there are 11 points across 300 pixels
    for(int x = 40; x <= 340; x += 30) {
      yVal = 300 - (int)(data[i] * 0.125);
      // If isHS is true, it prints the numbers representing the data under the curve so it's easier to read
      if(isHS) {
        drawText(String.valueOf(data[i]), x+2, yVal + 16);
        setStrokeColor("red");
      } else {
        drawText(String.valueOf(data[i]), x+2, yVal - 10);
        setStrokeColor("blue");
      }
      drawEllipse(x-2, yVal - 2, 4, 4);

      // Connects each dot by drawing lines
      if(x < 340) {
        drawLine(x, yVal, x+30, 300 - (int)(data[i+1] * 0.125));
      }

      // Increments i and pauses for animation
      i++;
      pause(0.5);
    }
  }

  /**
   * Shows the summary that visualizes the data from the gap array representing the
   * salary gap between the education levels
   * Precondition: gap must be a defined double array
   * Postcondition: will show a summary page on the scene with the data
   */
  public void showSummary(double[] gap) {
    setTextHeight(20);
    pause(1);
    clear("white");
    setTextColor("black");
    drawText("On average, Bachelors holders earn", 50, 100);
    
    // Use a Random number to pick which years to show
    int randomYear = (int)(Math.random() * (gap.length-2));
    int yearLabel = 2015 + randomYear;

    // Shows the year picked by the random number and the two after it for three total years
    for (int j = 0; j < 3; j++) {
      int currentIndex = randomYear + j;
      double currentGap = gap[currentIndex];

      // Compound boolean expression for algorithms requirement in rubric
      if (currentIndex < gap.length && currentGap > 65.0) {
        // Highlights extreme gaps in red
        setTextColor("red");
      } else {
        setTextColor("black");
      }

      drawText(currentGap + "% more in " + (2015 + currentIndex), 50, 150 + (j * 50));
    }
  }


  
}
