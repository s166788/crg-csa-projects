import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) throws Exception {
    DataReader a = new DataReader();

    DataScene myScene = new DataScene(a.getHsArray(), a.getBachArray(), a.getWageGapArray());

    Theater.playScenes(myScene);
    
    
  }
}
