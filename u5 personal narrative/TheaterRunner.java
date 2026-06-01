import org.code.theater.*;
import org.code.media.*;
import java.io.FileNotFoundException;

public class TheaterRunner {
  public static void main(String[] args) throws FileNotFoundException {
    Library library = new Library("books.txt", "reviews.txt", "thoughts.txt");
    library.formatThoughts(50);
    NarrationScene scene = new NarrationScene(library.getLibraryData());
    scene.showAll();
    Theater.playScenes(scene);
  }
}
