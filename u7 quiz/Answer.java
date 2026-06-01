import org.code.theater.*;
import org.code.media.*;

public class Answer {
  private int[] possibleAnswers;
  private boolean[] correctAnswer;
  int caIndex;

  //@param possibleAnswers list of indices to be shown
  public Answer(int[] possibleAnswers, boolean[] correctAnswer) {
    this.possibleAnswers = possibleAnswers;
    this.correctAnswer = correctAnswer;

    for(int i = 0; i < correctAnswer.length; i++) {
      if(correctAnswer[i]) {
        caIndex = i;
      }
    }
  }

  public int[] getOptions() {
    return possibleAnswers;
  }

  public int getCAIndex() {
    return caIndex;
  }

  // Precondition: possibleAnswers and correctAnswer are the same length
  public int getCorrectAnswer() {
    for(int i = 0; i < correctAnswer.length; i++) {
      if(correctAnswer[i]) {
        return possibleAnswers[i];
      }
    }
    return -1;
  }
  
}
