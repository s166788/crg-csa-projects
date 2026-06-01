import org.code.theater.*;
import org.code.media.*;
import java.io.IOException;

public class QuizScene extends Scene {
  private int numQuestions;
  
  private Questions a;
  private Answer[] questionBank;
  
  public QuizScene(int numQuestions) throws IOException {
    this.numQuestions = numQuestions;
    a = new Questions("presidents.txt");
    questionBank = a.generateQuestions();
  }
  
  /*
   *Called from main, initializes whole quiz scene
   */
  public void beginQuiz() {
    for(int i = 0; i < numQuestions; i++) {
      askQuestion(i);
    }
    completedScreen();
  }

  /*
   *Asks one question
   *@param n represents what number question the quiz is currently on
   */
  private void askQuestion(int n) {
    Answer ans = questionBank[n];
    int[] options = ans.getOptions();
    int correctIndex = ans.getCAIndex();
    clear("blue");
    setTextHeight(20);
    drawText("Who was president number " + (ans.getCorrectAnswer()+1) + "?",20,40);

    for(int i = 0; i < options.length; i++) {
      drawText(a.getName(options[i]), 20, 100 + i*30);
    }
    runTimer();
    drawImage("checkmark.jpg", 200, 80 + correctIndex*30, 25);
    pause(3);
  }
  
  /*
   *Shows timer animation, approximately 5 seconds
   */
  private void runTimer() {
    setFillColor("white");
    for(int i = 5; i > 0; i--) {
      drawRectangle(175, 300, 50, 50);
      drawText(Integer.toString(i), 195, 333);
      pause(1.15);
    }
  }

  // Shows completed screen
  private void completedScreen() {
    clear("green");
    drawText("Congratulations!", 100, 100);
    drawText("You completed the quiz!", 80, 180);
    
  }

}
