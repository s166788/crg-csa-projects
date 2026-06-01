import java.util.ArrayList;
import java.io.FileReader;

public class Passage {
  private String title;
  private String passage;
  private ArrayList<String> words = new ArrayList<String>();

  public Passage(String title, String passage) {
    this.title = title;
    this.passage = passage;
    initializeWords();
  }

  //Accessor methods
  public String getTitle() {return title;}
  public String toString() {return passage;}
  public ArrayList<String> getWords() {return words;}

  /**
   *Takes a chunk of text (passage) and separates it into words in an arraylist
   */
  public void initializeWords() {
    String text = passage;
    int space = text.indexOf(" ");

    while (space != -1) {
      String currentWord = text.substring(0, space);
      words.add(currentWord.toLowerCase());
      text = text.substring(space + 1);
      space = text.indexOf(" ");
    }
    words.add(text.toLowerCase());
  }
}
