import org.code.neighborhood.*;

public class PainterPlus extends Painter {

  // Turns the Painter object to the right
  public void turnRight() {
    turnLeft();
    turnLeft();
    turnLeft();
  }

  // Sets the painter's direction
  public void setDirection(String cardinalDirection) {
    while(getDirection() != cardinalDirection) {
      turnLeft();
    }
  }

  // Moves the painter until it can't
  public void moveMax() {
    while(canMove()) {
      move();
    }
  }

  // Sets the painter's coordinates. Painter ends up facing east.
  public void setCoordinates(int x, int y) {
    if(getX() > x) {
      setDirection("west");
    } else if(getX() < x) {
      setDirection("east");
    }
    while(getX() != x) {
      move();
    }
    
    if(getY() > y) {
      setDirection("north");
    } else if(getY() < y) {
      setDirection("south");
    }
    while(getY() != y) {
      move();
    }
    
    setDirection("east");
  }

  // Moves painter to a set of coordinates, then paints one square
  public void paintXY(int x, int y, String color) {
    setCoordinates(x, y);
    paint(color);
  }

  // Moves painter to a set of coordinates, then paints a line, facing east
  public void setCoordsAndPaintLine(int x, int y, String color, int blocks) {
    setCoordinates(x, y);
    paintLine(color, blocks);
  }

  // Moves painter to a set of coordinates, then paints a line, facing any direction
  public void setCoordsAndPaintLineDir(int x, int y, String color, int blocks, String direction) {
    setCoordinates(x, y);
    setDirection(direction);
    paintLine(color, blocks);
  }

  // Paints a line of "blocks" length. Includes the square the painter starts on
  public void paintLine(String color, int blocks) {
    //When blocks is -1, paints until border
    if(blocks == -1) {
      while(canMove()) {
        paint(color);
        move();
      }
      paint(color);
    } else {
      for(int i = 0; i < (blocks-1); i++) {
        paint(color);
        move();
      }
      paint(color);
    }
  }

  /*
  Repositions the painter to paint a new row
  Parameter represents which side the painter is on.
  If side is "right", the painter will end up facing left, and vice versa
  */
  
  public void reposition(String side) {

    if(side == "right") {
      turnRight();
      move();
      turnRight();
    } else if(side == "left") {
      turnLeft();
      move();
      turnLeft();
    }
  }

  /*
  Moves the painter to a certain side (represented by the parameter side)
  And repositions the painter to the next row so that it's ready to paint
  */
  
  public void farReposition(String side) {
    if(side == "left") {
      reposition("right");
      setDirection("west");
      moveMax();
      setDirection("east");
    } else if(side == "right") {
      reposition("left");
      setDirection("east");
      moveMax();
      setDirection("west");
    }
  }

  // Paints a rectangle
  // Coordinates (x,y) represent the rectangle's upper left corner
  public void paintRectangle(int x, int y, String color, int base, int height) {
    setCoordinates(x, y);
    for(int i = 0; i < height; i++) {
      paintLine(color, base);
      setCoordinates(x, getY());
      turnRight();
      move();
      turnLeft();
    }
  }

  // Sets the painter facing east at the bottom right of the map
  public void goToEnd() {
    setCoordinates(31,31);
  }
}
