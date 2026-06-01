import java.util.Scanner;

public class DataRunner {
  public static void main(String[] args) {

    //Loop control variable for the while loop
    //Changes to false and the loop ends when the user chooses to exit the program
    boolean continueLoop = true;

    //Instantiates the FoodActivist object with the data
    FoodActivist a = new FoodActivist("countries.txt", "incomes.txt", "populations.txt", "unemployment.txt");
    Scanner input = new Scanner(System.in);

    System.out.println("Welcome, food activist! What's your name?");
    String name = input.nextLine();

    while(continueLoop) {
      int choice = mainMenu(input, name);

      if(choice == 1) { //-------------------------- Superlatives from Main Menu --------------------------
        int superlativesChoice = superlativesMenu(input);
        if(superlativesChoice == 1) {                        //---------- Population Superlative ----------
          int popChoice = superlativesMinMax(input, "population");
          if(popChoice == 1) {                                       //---------- Max Population ----------
            System.out.println(a.findSuperlative("Population", "Max"));
          } else if(popChoice == 2) {                                //---------- Min Population ----------
            System.out.println(a.findSuperlative("Population", "Min"));
          } else {
            System.out.println("Please enter one of the options");
          }
        } else if(superlativesChoice == 2) {               //---------- Unemployment Superlative ----------
          int unempChoice = superlativesMinMax(input, "unemployment");
          if(unempChoice == 1) {                               //---------- Highest unemployment ----------
            System.out.println(a.findSuperlative("Unemployment", "Max"));
          } else if(unempChoice == 2) {                         //---------- Lowest unemployment ----------
            System.out.println(a.findSuperlative("Unemployment", "Min"));
          } else {
            System.out.println("Please enter one of the options");
          }
        } else {
          System.out.println("Please enter one of the options");
        }
      } else if(choice == 2) { //-------------------------- Filters from Main Menu --------------------------
        int filterChoice = filterMenu(input);
        
        if(filterChoice == 1) {                                      //---------- Filter by income ----------
          String filteredIncome = incomeFilter(input);
          a.filterIncome(filteredIncome);
          System.out.println("All " + filteredIncome + " countries have been saved.");
        } else if(filterChoice == 2) {                           //---------- Filter by population ----------
          int[] limits = populationFilter(input);
          a.filterPopulation(limits);
          System.out.println("All countries with populations in between " + limits[0] + " and " + limits[1] + " have been saved.");
        } else if(filterChoice == 3) {                         //---------- Filter by unemployment ----------
          double[] limits = unemploymentFilter(input);
          a.filterUnemployment(limits);
          System.out.println("All countries with unemployment rates in between " + limits[0] + "% and " + limits[1] + "% have been saved.");
        } else if(filterChoice == 4) {                              //---------- See filtered list ----------
          System.out.println(a);
        } else if(filterChoice == 5) {                                  //---------- Reset filters ----------
          a.resetFilters();
          System.out.println("Filters have been reset");
        } else {
          System.out.println("Please enter one of the options");
        }
      } else if(choice == 3) {  //-------------------------- Investigate countries --------------------------
        String countrySearched = investigateCountry(input);
        a.printCountryInfo(countrySearched);
      } else if(choice == 4) {           //--------------- Aspects that make communities high risk ----------
        explainFactorsToFoodRisk();
      } else if(choice == 5) {           //-------------------------- Exit Program --------------------------
        System.out.print("Program exited.");
        input.close();
        continueLoop = false;
      } else {
        System.out.println("Please enter one of the options");
      }
    }


    
    
  }
  /**
   *Prints main menu
   *Takes scanner object, returns user's choice
   *Precondition: scanner object is defined
   *Postcondition: int is returned
   */
  public static int mainMenu(Scanner input, String name) {
    System.out.println("----Hi, " + name + "!----");
    System.out.println("1: See country superlatives");
    System.out.println("2: Filter countries");
    System.out.println("3: Investigate countries");
    System.out.println("4: Aspects that make a community high risk");
    System.out.println("5: Exit");
    return input.nextInt();
  }

  /**
   *Prints superlatives menu (1 from main menu)
   *Takes scanner and returns user's choice
   *Precondition: scanner object is defined
   *Postcondition: int is returned
   */
  public static int superlativesMenu(Scanner input) {
    System.out.println("1: Population");
    System.out.println("2: Unemployment");
    return input.nextInt();
  }

  /**
   *Allows the user to choose the highest or lowest as the superlative
   *Appears after superlativesMenu method is called
   *Takes scanner and category (population or unemployment) and returns user's choice
   *Precondition: scanner object is defined
   *Postcondition: int is returned
   */
  public static int superlativesMinMax(Scanner input, String category) {
    System.out.println("1: Highest " + category);
    System.out.println("2: Lowest " + category);
    return input.nextInt();
  }

  /**
   *Prints the filtering menu
   *Comes from entering 2 in the main menu
   *Takes scanner and returns user's choice
   *Precondition: scanner object is defined
   *Postcondition: int is returned
   */
  public static int filterMenu(Scanner input) {
    System.out.println("----Filter countries----");
    System.out.println("1: Filter by income");
    System.out.println("2: Filter by population");
    System.out.println("3: Filter by unemployment rate");
    System.out.println("4: See filtered list");
    System.out.println("5: Reset filters");
    return input.nextInt();
  }

  /**
   *Is called when the user chooses to filter by income from filterMenu
   *Takes scanner and returns the term to filter by
   *The string returned is plugged into the filterIncome method in the FoodActivist class after,
   *which filters out countries without the specified income level
   *Precondition: scanner object is defined
   *Postcondition: String is returned
   */
  public static String incomeFilter(Scanner input) {
    System.out.println("Which income category would you like to filter by?");
    System.out.println("1: High Income");
    System.out.println("2: Upper Middle Income");
    System.out.println("3: Lower Middle Income");
    System.out.println("4: Low Income");
    int answer = input.nextInt();
    //1 line if statements learned from google, used to improve readability
    if(answer == 1) return "High Income";
    if(answer == 2) return "Upper Middle Income";
    if(answer == 3) return "Lower Middle Income";
    if(answer == 4) return "Low Income"; else return "";
  }

  /**
   *Is called when the user chooses to filter population from filterMenu
   *Takes scanner and returns an int array with the first index as
   *the minimum and the second index as the maximum limit
   *Precondition: scanner object is defined
   *Postcondition: int array is returned with 2 values
   */
  public static int[] populationFilter(Scanner input) {
    System.out.println("Enter the min population");
    int min = input.nextInt();
    System.out.println("Enter the max population");
    int max = input.nextInt();
    int[] limits = {min, max};
    return limits;
  }

  /**
   *Is called when the user chooses to filter unempoyment from filterMenu
   *Takes scanner and returns a double array with 2 values that represent
   *the upper and lower limits of the unemployment range to search for
   *Similar to the populationFilter method above
   *Precondition: scanner object is defined
   *Postcondition: double array is returned with 2 values
   */
  public static double[] unemploymentFilter(Scanner input) {
    System.out.println("Enter the min unemployment rate");
    double min = input.nextDouble();
    System.out.println("Enter the max unemployment rate");
    double max = input.nextDouble();
    double[] limits = {min, max};
    return limits;
  }

  /**
   *Asks the user which country and returns it
   *Value is then plugged into printCountryInfo from FoodActivist class
   *Precondition: scanner object is defined
   *Postcondition: String is returned
   */
  public static String investigateCountry(Scanner input) {
    input.nextLine();
    System.out.println("Which country would you like to search for?");
    return input.nextLine();
  }

  /**
   *Prints a short blurb explaining how to determine which countries
   *have higher food risks
   *Precondition: n/a
   *Postcondition: prints messages to console
   */
  public static void explainFactorsToFoodRisk() {
    System.out.print("Countries with higher populations can have higher chances for food shortages because more people leads to a greater strain on their resources. ");
    System.out.print("Additionally, lower income countries are more likely to have food shortages because poorer countries often struggle to grow their own food because of geography or to import it because importing food is expensive. ");
    System.out.println("Lastly, countries with higher unemployment rates are also more likely to struggle with food shortages because people without income sources have little money to buy food. ");
    System.out.println();
    System.out.println("Make sure to keep these factors in mind when using the program!");
    System.out.println();
  }

}
