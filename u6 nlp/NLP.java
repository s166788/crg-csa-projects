import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class NLP {
  private ArrayList<String> sentiments = new ArrayList<String>();
  private ArrayList<String> sentimentWords = new ArrayList<String>();
  private ArrayList<Double> sentimentValues = new ArrayList<Double>();
  
  private ArrayList<String> stopWords = new ArrayList<String>();
  private ArrayList<Passage> passages = new ArrayList<Passage>();

  /**
   *NLP Constructor, instantiates all arraylists
   *
   *@param p1 first passage filename
   *@param p2 second passage filename
   *@param p3 third passage filename
   */
  public NLP(String p1, String p2, String p3) throws IOException {
    initializeSentiments();
    fileToArrayList("stopwords.txt", stopWords);
    passages.add(new Passage("Removal of Kevin McCarthy as Speaker of the House - Wikipedia", fileToString(p1)));
    passages.add(new Passage("Covfefe - Wikipedia", fileToString(p2)));
    passages.add(new Passage("Star Wars: The Clone Wars - Wikipedia", fileToString(p3)));
  }

  /**
   *Takes a file name and returns a string with the text file's contents
   *
   *@param fileName the name of the file
   *@return content the full string containing the file's contents
   */
  public String fileToString(String fileName) throws IOException {
    String content = "";
    Scanner scanner = new Scanner(new File(fileName));
    while(scanner.hasNextLine()) {
      content += scanner.nextLine() + " ";
    }
    return content;
  }

  /**
   *Takes a file name and arraylist and adds each line of the file as a string inside the arraylist
   *
   *@param fileName the name of the file
   *@param resultAR the resulting arraylist, passed as a parameter and modified in the method
   */
  public void fileToArrayList(String fileName, ArrayList<String> resultAR) throws IOException {
    String content = "";
    Scanner scanner = new Scanner(new File(fileName));
    while(scanner.hasNextLine()) {
      resultAR.add(scanner.nextLine());
    }
  }

  /**
   *initializes the sentiments, sentimentWords, and sentimentValues arraylists
   */
  public void initializeSentiments() throws IOException {
    fileToArrayList("sentimentvalues.txt", sentiments);
    
    for(int i = 0; i < sentiments.size(); i++) {
      String line = sentiments.get(i);
      int comma = line.indexOf(",");
      if(comma != -1) {
        String word = line.substring(0,comma);
        Double value = Double.parseDouble(line.substring(comma+1));
        sentimentWords.add(word);
        sentimentValues.add(value);
      }
    }
  }

  // Returns a specific passage requested
  public Passage getPassage(int n) {
    return passages.get(n);
  }

  /**
   *Takes a string of text and adds each word to an arraylist. 
   *Then passes that arraylist to determine the overall sentiment value and superlatives
   *
   *@param inputText the string of text that is analyzed
   */
  public void translateWordValues(String inputText) {
    //Method learned from W3Schools https://www.w3schools.com/java/ref_string_split.asp
    String[] splitWords = inputText.split(" ");
    ArrayList<String> wordList = new ArrayList<String>();
    for(String word : splitWords) {
      wordList.add(word.toLowerCase());
    }
    translateWordValues(wordList);
  }

  /**
   *Overloaded translateWordValues method for when an integer is provided that represents the number of the requested passage
   *
   *@param passageNum the number of the requested passage
   */
  public void translateWordValues(int passageNum) {
    translateWordValues(passages.get(passageNum).getWords());
  }

  /**
   *The real meat and bones of translateWordValues, determines the overall sentiment score, most positive and negative words and values
   *
   *@param words an arraylist that the method analyzes, adding up each word's sentiment score and keeping track of superlatives
   */
  public void translateWordValues(ArrayList<String> words) {
    double totalSentimentValue = 0;
    String mostPositiveWord = "";
    double mostPosValue = 0;
    String mostNegativeWord = "";
    double mostNegValue = 0;

    for(String word : words) {
      double val = getSentimentValue(word);
      totalSentimentValue += val;
      if(val > mostPosValue) {
        mostPosValue = val;
        mostPositiveWord = word;
      }
      if(val < mostNegValue) {
        mostNegValue = val;
        mostNegativeWord = word;
      }
    }
    System.out.println("----Your Text----");
    System.out.println("Total sentiment score: " + totalSentimentValue);
    System.out.println("Most positive word: " + mostPositiveWord + " (" + mostPosValue + ")");
    System.out.println("Most negative word: " + mostNegativeWord + " (" + mostNegValue + ")");
  }

  /**
   *Takes a string as a parameter, checks it in sentimentWords, and returns its sentimentValue from sentimentValues
   *
   *@param word the word that is checked
   */
  public double getSentimentValue(String word) {
    String cleanWord = clean(word);
    for(int i = 0; i < sentimentWords.size(); i++) {
      if(sentimentWords.get(i).equals(cleanWord)) {
        return sentimentValues.get(i);
      }
    }
    return 0.0;
  }

  /**
   *Removes stop words from stopwords.txt
   */
  public void removeStopWords(ArrayList<String> words) {
    for(int i = words.size()-1; i >= 0; i--) {
      for(int j = stopWords.size()-1; j >= 0; j--) {
        if(words.get(i).equals(stopWords.get(j))) {
          words.remove(i);
          break;
        }
      }
    }
  }

  /**
   *Takes a word, sets it to lowercase, and removes all punctuation
   *
   *@param word the string that is cleaned (lowercase + punctuation)
   */
  public String clean(String word) {
    String result = "";
    word = word.toLowerCase();

    for(int i = 0; i < word.length(); i++) {
      // Grab one character as a String
      String letter = word.substring(i, i + 1);

      // Only keeps real letters and filters out all punctuation
      if (letter.compareTo("a") >= 0 && letter.compareTo("z") <= 0) {
        result += letter;
      }
    }
    return result;
  }

  /**
   *Takes a passage number to locate a passage, then finds the most common word in that passage
   *
   *@param passageNum the index of the passage in passages to analyze the most common word in
   */
  public void findCommonWords(int passageNum) {
    Passage p = passages.get(passageNum);
    ArrayList<String> cleanedWords = new ArrayList<String>();
    for(String w : p.getWords()) {
      String c = clean(w);
      if(!c.equals("")) {
        cleanedWords.add(c);
      }
    }
    removeStopWords(cleanedWords);
    
    ArrayList<WordCount> frequencies = new ArrayList<WordCount>();

    for(String word : cleanedWords) {
      // Calling clean method removes punctuation
      String cleanWord = clean(word);
      boolean found = false;
      for(WordCount wc : frequencies) {
        if(wc.getWord().equals(cleanWord)) {
          wc.increment();
          found = true;
          break;
        }
      }
      if(!found) {
        frequencies.add(new WordCount(cleanWord));
      }
    }
    WordCount mostCommon = frequencies.get(0);
    for(WordCount wc : frequencies) {
      if(wc.getCount() > mostCommon.getCount()) {
        mostCommon = wc;
      }
    }
    System.out.println("The most common word was: " + mostCommon.getWord());
    System.out.println("It appeared " + mostCommon.getCount() + " times.");
  }

}
