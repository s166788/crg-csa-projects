public class WordCount {
  private String word;
  private int count;

  public WordCount(String word) {
    this.word = word;
    this.count = 1;
  }

  public String getWord() {return word;}
  public int getCount() {return count;}
  public void increment() {count++;}
}
