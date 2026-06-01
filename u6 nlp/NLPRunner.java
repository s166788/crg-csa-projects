import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class NLPRunner {
  public static void main(String[] args) throws IOException {
    boolean continueLoop = true;

    Scanner input = new Scanner(System.in);
    NLP a = new NLP("passage1.txt", "passage2.txt", "passage3.txt");

    while(continueLoop) {
      int menuChoice = mainMenu(input);
      if(menuChoice == 1) { // Analyze sentiment values of your words
        a.translateWordValues(mmOp1(input));
      } else if(menuChoice == 2) { // See the most common words in texts
        int passageChoice = mmOp2(input);
        if(passageChoice == 1) {
          a.findCommonWords(0);
        } else if(passageChoice == 2) {
          a.findCommonWords(1);
        } else if(passageChoice == 3) {
          a.findCommonWords(2);
        } else {
          System.out.println("Please choose one of the options");
        }
      } else if(menuChoice == 3) { // Read the texts
        int readPassageChoice = mmOp2(input);
        if(readPassageChoice == 1) {
          System.out.println(a.getPassage(0));
        } else if(readPassageChoice == 2) {
          System.out.println(a.getPassage(1));
        } else if(readPassageChoice == 3) {
          System.out.println(a.getPassage(2));
        } else {
          System.out.println("Please choose one of the options");
        }
      } else {
        System.out.println("Please choose one of the options");
      }
    }
  }

  /**
   *Prints main menu
   *Takes scanner object, returns user's choice
   *Precondition: Scanner object is defined
   *Postcondition: int is returned
   * @param input The scanner object
   */
  public static int mainMenu(Scanner input) {
    System.out.println("Hi! Choose one of the following:");
    System.out.println("1: Analyze sentiment values of your words");
    System.out.println("2: See most common words in texts");
    System.out.println("3: Read the texts");
    return input.nextInt();
  }

  /**
   *Prints the first option from after the main menu
   *Takes scanner object, returns user's choice
   *Precondition: Scanner object is defined
   *Postcondition: int is returned
   * @param input The scanner object
   */
  public static String mmOp1 (Scanner input) {
    System.out.println("Please type in your words to analyze and press enter when done.");
    input.nextLine();
    return input.nextLine();
  }

  /**
   *Prints the second option after the main menu
   *Takes scanner object, returns user's choice
   *Precondition: Scanner object is defined
   *Postcondition: int is returned
   * @param input The scanner object
   */
  public static int mmOp2 (Scanner input) {
    System.out.println("Please choose one of the following passages:");
    System.out.println("1: Removal of Kevin McCarthy as Speaker of the House - Wikipedia");
    System.out.println("2: Covfefe - Wikipedia");
    System.out.println("3: Star Wars: The Clone Wars - Wikipedia");
    return input.nextInt();
  }
}
