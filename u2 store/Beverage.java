public class Beverage extends CoffeeItem {
  private String size;
  private String flavor;

  public Beverage() {
    super("Water", 0.0);
    this.size = "Medium";
    this.flavor = "n/a";
  }

  public Beverage(String name, double price, String size, String flavor) {
    super(name, price);
    this.size = size;
    this.flavor = flavor;
  }

  public String getSize() {
    return size;
  }

  public String getFlavor() {
    return flavor;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setFlavor(String flavor) {
    this.flavor = flavor;
  }
  
  public String toString() {
    return super.toString() + "\nSize: " + size + " | Flavor: " + flavor;
  }
}
