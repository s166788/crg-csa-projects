import org.code.theater.*;
import org.code.media.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Questions {
  private ArrayList<String> answerKey = new ArrayList<String>();

  /*
   *@param keyFileName - the name of the text file for all the possible answers
   */
  public Questions(String keyFileName) throws IOException {
    Scanner scanner = new Scanner(new File(keyFileName));
    while(scanner.hasNextLine()) {
      answerKey.add(scanner.nextLine());
    }
  }

  /*
   *@param n - what index to return in the answer key
   */
  public String getName(int n) {
    return answerKey.get(n);
  }

  public Answer[] generateQuestions() {
    Answer[] questions = new Answer[3];
    for(int i = 0; i < 3; i++) {
      questions[i] = generateQuestion();
    }
    return questions;
  }

  /*
   *@return returns an answer object
   */
  private Answer generateQuestion() {
    int[] possibleAnswers = generatePossibleAnswers();
    boolean[] correctAnswer = generateCorrectAnswer();
    return new Answer(possibleAnswers, correctAnswer);
  }

  /*
   *Creates an int list of length 3 of unique numbers from 0 to answerKey.size() (exclusive)
   */
  private int[] generatePossibleAnswers() {
    int[] possibleAnswers = new int[3];
    ArrayList<String> usedNames = new ArrayList<String>();

    // First option
    int n = (int) (Math.random() * answerKey.size());
    possibleAnswers[0] = n;
    usedNames.add(answerKey.get(n));

    // Second option
    while(usedNames.contains(answerKey.get(n))) {
      n = (int) (Math.random() * answerKey.size());
    }
    possibleAnswers[1] = n;
    usedNames.add(answerKey.get(n));

    // Third option
    while(usedNames.contains(answerKey.get(n))) {
      n = (int) (Math.random() * answerKey.size());
    }
    possibleAnswers[2] = n;
      
    return possibleAnswers;
  }

  /*
   *Creates a boolean list of length 3 and randomly selects one of them to be true
   */
  private boolean[] generateCorrectAnswer() {
    boolean[] list = new boolean[3];
    list[(int) (Math.random()*3)] = true;
    return list;
  }
}
