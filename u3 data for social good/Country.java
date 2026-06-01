public class Country {
  private String name;
  private String income;
  private int population;
  private double unemployment;

  public Country() {
    name = "";
    income = "";
    population = 0;
    unemployment = 0.0;
  }

  public Country(String name) {
    this.name = name;
  }

  public Country(String name, String income, int population, double unemployment) {
    this.name = name;
    this.income = income;
    this.population = population;
    this.unemployment = unemployment;
  }
  
  public String getName() {
    return name;
  }

  public String getIncome() {
    return income;
  }

  public int getPopulation() {
    return population;
  }

  public double getUnemployment() {
    return unemployment;
  }

  /**
   *Changes the instance variables for country objects for when they are filtered out in FoodActivist.java
   */
  public void resetCountry() {
    name = "";
    income = "";
    population = 0;
    unemployment = 0;
  }

  public String toString() {
    String printedString = "";
    
    printedString += "----" + name + "----\n";
    printedString += "Income: " + income + "\n";
    printedString += "Population: " + population + "\n";
    printedString += "Unemployment rate: " + unemployment + "%\n";
    printedString += "Unemployed population: " + (int) (population * unemployment * 0.01) + "\n";
    
    return printedString;
  }
}
