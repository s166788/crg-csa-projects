import java.util.Scanner;

public class StoreRunner {
  public static void main(String[] args) {
    String item; //Variables related to actions/user input
    int action1;
    int action2;
    int action3;
    String shopName;
    
    String name; //Variables to be used to instantiate new items' instance variables
    double price;
    String size;
    String flavor;
    String type;
    int calories;

    double newPrice;
    double pricePercChange;

    String newFlavor;
    
    Beverage item1 = null; //Make sure that the objects have main method scope, instead of being defined in if-else block
    Pastry item2 = null;
    
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to your coffee shop! What would you like to name it?");
    shopName = input.nextLine();

    //Infinite loop
    while(true) {
      System.out.println("\n----" + shopName + "----");
      System.out.println("What would you like to do?\n1: Create a new product\n2: See products\n3: Modify products\n4: Exit");
      action1 = input.nextInt();
      input.nextLine();
      
      if(action1 == 1) {
        //User chose to create a new product
        System.out.println("What kind of product would you like to create? 'Beverage' or 'Pastry'");
        item = input.nextLine();
        if(!item.equalsIgnoreCase("Beverage") && !item.equalsIgnoreCase("Pastry")) {
          System.out.println("Please choose one of the options");
        } else if(item.equalsIgnoreCase("Beverage")) {
          
          System.out.println("What is the name of this item?");
          name = input.nextLine();
          System.out.println("How much does this item cost?");
          price = input.nextDouble();
          input.nextLine();
          
          System.out.println("What size is the drink?");
          size = input.nextLine();
          System.out.println("What flavor is the drink?");
          flavor = input.nextLine();
          
          item1 = new Beverage(name, price, size, flavor); //Instantiate object with user input as attributes
          System.out.println("New beverage " + item1.getName() + " created");
          
        } else if(item.equalsIgnoreCase("Pastry")) {
          
          System.out.println("What is the name of this item?");
          name = input.nextLine();
          System.out.println("How much does this item cost?");
          price = input.nextDouble();
          input.nextLine();
          
          System.out.println("What type of pastry is it?");
          type = input.nextLine();
          System.out.println("How many calories does it have?");
          calories = input.nextInt();
          input.nextLine();
          
          item2 = new Pastry(name, price, type, calories); //Instantiate object with user input as attributes
          System.out.println("New pastry " + item2.getName() + " created");
          
        } else {
          System.out.println("Please choose one of the options"); //If the input wasn't "Beverage" or "Pastry"
        }
        
      } else if(action1 == 2) {
        System.out.println("----" + shopName + "'s  Products----");
        
          
        if(item1 != null && item2 != null) {
          System.out.println(item1.toString() + "\n" + item2.toString());
        } else if(item1 == null && item2 == null) {
          System.out.println("No items have been created yet");
        } else if(item1 != null) {
          System.out.println(item1.toString());
        } else if(item2 != null) {
          System.out.println(item2.toString());
        }
      } else if(action1 == 3) {
        System.out.println("Which product would you like to modify?\n1: Beverage item\n2: Pastry item");
        action2 = input.nextInt();
        input.nextLine();
        if(item1 == null && action2 == 1) {
          System.out.println("Please create an item before modifying it");
        } else if(item2 == null && action2 == 2) {
          System.out.println("Please create an item before modifying it");
        } else if(action2 == 1) {
          System.out.println("What about it would you like to modify?\nName (1): " + item1.getName() + "\nPrice (2): " + item1.getPrice() + "\nSize (3): " + item1.getSize() + "\nFlavor (4): " + item1.getFlavor());
          action3 = input.nextInt();
          input.nextLine();
          if(action3 == 1) {
            System.out.println("What would you like the new name to be?");
            item1.setName(input.nextLine());
            System.out.println("The item has been renamed to \"" + item1.getName() + "\"");
          } else if(action3 == 2) {
            System.out.println("How much would you like the item to cost?");
            newPrice = input.nextDouble();
            input.nextLine();
            pricePercChange = Math.round((newPrice/item2.getPrice()) * 100);
            item1.setPrice(newPrice);
            System.out.println("The item's cost has been changed to " + item1.getPrice() + ". This is a " + pricePercChange + "% change.");
          } else if(action3 == 3) {
            System.out.println("What will the new size be?");
            item1.setSize(input.nextLine());
            System.out.println("The item's size has been changed to " + item1.getSize());
          } else if(action3 == 4) {
            System.out.println("What would you like to change the flavor to?");
            newFlavor = input.nextLine();
            item1.setFlavor(newFlavor);
            System.out.println("The item's flavor has been changed to " + item1.getFlavor());
          }
        } else if(action2 == 2) {
          System.out.println("What about it would you like to modify?\nName (1): " + item2.getName() + "\nPrice (2): " + item2.getPrice() + "\nType (3): " + item2.getType() + "\nCalories (4): " + item2.getCalories());
          action3 = input.nextInt();
          input.nextLine();
          if(action3 == 1) {
            System.out.println("What would you like the new name to be?");
            item2.setName(input.nextLine());
            System.out.println("The item has been renamed to \"" + item2.getName() + "\"");
          } else if(action3 == 2) {
            System.out.println("How much would you like the item to cost?");
            newPrice = input.nextDouble();
            input.nextLine();
            pricePercChange = Math.round((newPrice/item2.getPrice()) * 100);
            item2.setPrice(newPrice);
            System.out.println("The item's cost has been changed to " + item2.getPrice() + ". This is a " + pricePercChange + "% change.");
          } else if(action3 == 3) {
            System.out.println("What will the new type be?");
            item2.setType(input.nextLine());
            System.out.println("The item's type has been changed to " + item2.getType());
          } else if(action3 == 4) {
            System.out.println("How many calories will the item have?");
            item2.setCalories(input.nextInt());
            System.out.println("The item now has " + item2.getCalories() + " calories");
          } else {
            System.out.println("Please choose one of the options");
          }
        } else {
          System.out.println("Please choose one of the options");
        }
      } else if(action1 == 4) {
        System.out.println("Program exited");
        break;
      } else {
        System.out.println("Please choose one of the options");
      }
    }
    input.close();
  }
}
