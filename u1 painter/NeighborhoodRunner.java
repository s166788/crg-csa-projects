import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {

    WavePainter darkBlue = new WavePainter();
    darkBlue.paintDarkBlue();
    darkBlue.goToEnd();

    WavePainter white = new WavePainter();
    white.paintWhite();
    white.goToEnd();

    WavePainter blue = new WavePainter();
    blue.paintBlue();
    blue.goToEnd();

    WavePainter lightBlue = new WavePainter();
    lightBlue.paintLightBlue();
    lightBlue.goToEnd();

    
  }
}
