import org.code.theater.*;
import org.code.media.*;
import java.io.IOException;

public class TheaterRunner {
  public static void main(String[] args) throws IOException {
    QuizScene scene = new QuizScene(3);
    scene.beginQuiz();
    Theater.playScenes(scene);
  }
}
