import java.util.Scanner;

public class FoodActivist {
  private Country[] countries;
  private Country[] countriesBackup;

  /**
   *Constructor of the FoodActivist class
   *Precondition: parameters passed must be valid file names
   */
  public FoodActivist(String countriesFile, String incomesFile, String populationsFile, String unemploymentFile) {
    this.countries = initializeCountries(countriesFile, incomesFile, populationsFile, unemploymentFile);
    this.countriesBackup = initializeCountries(countriesFile, incomesFile, populationsFile, unemploymentFile);
  }

  /**
   *Creates arrays for each file, then creates a list of Country objects and returns the list
   *initializeCountries is called in this class's constructor, initializing the instance variable countries
   *Precondition: parameters are passed with valid file names
   *Postcondition: array of Country objects is returned
   */
  public Country[] initializeCountries(String countriesFile, String incomesFile, String populationsFile, String unemploymentFile) {
    String[] countriesData = FileReader.toStringArray(countriesFile);
    String[] incomesData = FileReader.toStringArray(incomesFile);
    int[] populationsData = FileReader.toIntArray(populationsFile);
    double[] unemploymentData = FileReader.toDoubleArray(unemploymentFile);

    Country[] tempCountries = new Country[countriesData.length];
    
    for(int i = 0; i < tempCountries.length; i++) {
      tempCountries[i] = new Country(countriesData[i], incomesData[i], populationsData[i], unemploymentData[i]);
    }

    return tempCountries;
  }

  /**
   *Re-constructs the countries array by using the same process when it is initialized for the first time
   */
  public void resetFilters() {
    countries = initializeCountries("countries.txt", "incomes.txt", "populations.txt", "unemployment.txt");
  }

  /**
   *Resets all countries whose income brackets match the parameter
   *Precondition: String parameter must be a valid income bracket
   */
  public void filterIncome(String income) {
    for(int i = 0; i < countries.length; i++) {
      if(!countries[i].getIncome().equals(income)) {
        countries[i].resetCountry();
      }
    }
  }
  /**
   *Resets all countries with populations within the limits
   *Precondition: limits[0] has to be smaller than limits[1]
   */
  public void filterPopulation(int[] limits) {
    for(int i = 0; i < countries.length; i++) {
      if(countries[i].getPopulation() < limits[0] || countries[i].getPopulation() > limits[1]) {
        countries[i].resetCountry();
      }
    }
  }

  /**
   *Resets all countries whose unemployment rates within the limits
   *Precondition: limits[0] has to be smaller than limits[1]
   */
  public void filterUnemployment(double[] limits) {
    for(int i = 0; i < countries.length; i++) {
      if(countries[i].getUnemployment() < limits[0] || countries[i].getUnemployment() > limits[1]) {
        countries[i].resetCountry();
      }
    }
  }

  /**
   *Precondition: String income parameter has to be real income bracket
   *Postcondition: returns an int that represents how many countries left are in that income bracket
   */
  public int findIncome(String income) {
    int n = 0;
    for(Country c : countries) {
      if(c.getIncome().equals(income)) {
        n++;
      }
    }
    return n;
  }

  /**
   *Returns the number of countries that haven't been filtered/reset yet
   *Postcondition: returns an int
   */
  public int remainingCountries() {
    int n = 0;
    for(Country c : countries) {
      if(!c.getName().equals("")) {
        n++;
      }
    }
    return n;
  }

  /**
   *Searches for a specific country and then calls its toString method
   *Precondition: String parameter name must be a real country name in the list
   */
  public void printCountryInfo(String name) {
    boolean found = false;
    for(Country c : countriesBackup) {
      if(c.getName().equals(name)) {
        System.out.println(c);
        found = true;
      }
    }
  }

  /**
   *Finds the superlative to be printed
   *Precondition: Parameter metric must be "Population" or "Unemployment", and minMax must be "Max" or "Min"
   *Postcondition: returns a country object
   */
  public Country findSuperlative(String metric, String minMax) {
    Country returnedCountry = countriesBackup[0];
    if(metric.equals("Population")) {
      if(minMax.equals("Max")) {
        for(Country c : countries) {
          if(c.getPopulation() > returnedCountry.getPopulation()) {
            returnedCountry = c;
          }
        }
      } else if(minMax.equals("Min")) {
        for(Country c : countries) {
          if(c.getPopulation() < returnedCountry.getPopulation()) {
            returnedCountry = c;
          }
        }
      }
    } else if(metric.equals("Unemployment")) {
      if(minMax.equals("Max")) {
        for(Country c : countries) {
          if(c.getUnemployment() > returnedCountry.getUnemployment()) {
            returnedCountry = c;
          }
        }
      } else if(minMax.equals("Min")) {
        for(Country c : countries) {
          if(c.getUnemployment() < returnedCountry.getUnemployment()) {
            returnedCountry = c;
          }
        }
      }
    }
    return returnedCountry;
  }

  /**
   *Prints the number of countries in each income bracket
   *Also prints all the remaining countries in the countries array
   *Postcondition: string is returned
   */
  public String toString() {
    String printedString = "----Results----\n";
    
    printedString += "\n----Income Stats----\n";
    printedString += "High income countries: " + findIncome("High Income") + "\n";
    printedString += "Upper Middle Income countries: " + findIncome("Upper Middle Income") + "\n";
    printedString += "Lower Middle Income countries: " + findIncome("Lower Middle Income") + "\n";
    printedString += "Lower Income countries: " + findIncome("Low Income") + "\n";

    printedString += "\n----Countries----\n";
    
    int index = 0;
    for(int i = 0; i < countries.length; i++) {
      if(!countries[i].getName().equals("")) {
        if(index > 0) {
          printedString += ", ";
        }
        printedString += countries[i].getName();
        index++;
      }
    }
    return printedString;
  }
  
}
