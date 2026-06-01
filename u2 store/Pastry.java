public class Pastry extends CoffeeItem {
  private String type;
  private int calories;

  public Pastry() {
    super("Bagel", 3.0);
    this.type = "Bread";
    this.calories = 250;
  }
  
  public Pastry(String name, double price, String type, int calories) {
    super(name, price);
    this.type = type;
    this.calories = calories;
  }

  public String getType() {
    return type;
  }

  public int getCalories() {
    return calories;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setCalories(int calories) {
    this.calories = calories;
  }

  public String toString() {
    return super.toString() + "\nType: " + type + " | Calories: " + calories;
  }

  
}
