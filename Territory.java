public class Territory extends Country {
  public Territory(String name, String income, int population, double unemployment) {
    super(name, income, population, unemployment);
  }

  public String toString() {
    return "----Territory----\n\n" + super.toString();
  }
}
