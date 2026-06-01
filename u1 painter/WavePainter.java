import org.code.neighborhood.*;

public class WavePainter extends PainterPlus {
  public void paintDarkBlue() {
    paintLine("#0b3162", -1);
    reposition("right");
    paintLine("#0b3162", -1);
    reposition("left");
    paintLine("#0b3162", -1);
    reposition("right");
    
    for(int i = 0; i < 3; i++) {
      paintLine("#0b3162", 17);
      reposition("left");
      paintLine("#0b3162", 17);
      reposition("right");
    }

    setCoordinates(8,3);
    setDirection("west");
    paintLine("#0b3162", -1);
    reposition("left");
    paintLine("#0b3162", 7);
    setCoordinates(4,5);
    setDirection("west");
    paintLine("#0b3162", -1);
    reposition("left");
    paintLine("#0b3162", 5);
    paintRectangle(0,7,"#0b3162",3,3);
    

    setCoordinates(31,9);
    setDirection("west");
    paintLine("#0b3162", 18);
    setCoordinates(12,10);
    paintLine("#0b3162", -1);
    reposition("right");
    paintLine("#0b3162", 20);
    reposition("left");
    paintLine("#0b3162", -1);
    reposition("right");
    paintLine("#0b3162", 21);
    reposition("left");
    paintLine("#0b3162", 19);
    reposition("right");
    paintLine("#0b3162", 18);
    reposition("left");

    paintRectangle(12,16,"#0b3162",14,6);
  }

  public void paintWhite() {
    setCoordsAndPaintLine(9,3,"#faf8f9",6); // Line 4
    setCoordsAndPaintLine(7,4,"#faf8f9",9); // Line 5
    setCoordsAndPaintLine(5,5,"#faf8f9",12); // Line 6
    paintXY(18,5,"#faf8f9");
    setCoordsAndPaintLine(5,6,"#faf8f9",6); // Line 7
    setCoordsAndPaintLine(12,6,"#faf8f9",4);
    paintXY(17,6,"#faf8f9");
    paintXY(19,6,"#faf8f9");
    setCoordsAndPaintLine(3,7,"#faf8f9",5); // Line 8
    setCoordsAndPaintLine(13,7,"#faf8f9",4);
    setCoordsAndPaintLine(3,8,"#faf8f9",5); // Line 9
    setCoordsAndPaintLine(14,8,"#faf8f9",2);
    setCoordsAndPaintLine(17,8,"#faf8f9",2);
    setCoordsAndPaintLine(2,9,"#faf8f9",7); // Line 10
    paintXY(16,9,"#faf8f9");
    setCoordsAndPaintLine(18,9,"#faf8f9",2);
    setCoordsAndPaintLine(0,10,"#faf8f9",7); // Line 11
    setCoordsAndPaintLine(8,10,"#faf8f9",2);
    paintXY(18,10,"#faf8f9");
    setCoordsAndPaintLine(0,11,"#faf8f9",3); // Line 12
    setCoordsAndPaintLine(5,11,"#faf8f9",2);
    setCoordsAndPaintLine(0,12,"#faf8f9",3); // Line 13
    setCoordsAndPaintLine(6,12,"#faf8f9",2);
    paintXY(19,12,"#faf8f9");
    setCoordsAndPaintLine(0,13,"#faf8f9",4); // Line 14
    paintXY(6,13,"#faf8f9");
    paintXY(8,13,"#faf8f9");
    paintXY(0,14,"#faf8f9"); // Line 15
    paintXY(3,14,"#faf8f9");
    paintXY(0,15,"#faf8f9"); // Line 16
    paintXY(0,16,"#faf8f9"); // Line 17
    paintXY(8,16,"#faf8f9");
    setCoordsAndPaintLine(0,17,"#faf8f9",2); // Line 18
    setCoordsAndPaintLine(7,17,"#faf8f9",4);
    paintXY(0,18,"#faf8f9"); // Line 19
    paintXY(2,18,"#faf8f9");
    setCoordsAndPaintLine(6,18,"#faf8f9",6);
    setCoordsAndPaintLine(0,19,"#faf8f9",2); // Line 20
    setCoordsAndPaintLine(6,19,"#faf8f9",6);
    setCoordsAndPaintLine(0,20,"#faf8f9",3); // Line 21
    setCoordsAndPaintLine(4,20,"#faf8f9",9);
    setCoordsAndPaintLine(0,21,"#faf8f9",10); // Line 22
    setCoordsAndPaintLine(11,21,"#faf8f9",5);
    setCoordsAndPaintLine(18,21,"#faf8f9",4);

    // Lines 15-21, right side
    setCoordsAndPaintLine(21,20,"#faf8f9",3); // Line 21
    setCoordsAndPaintLine(23,19,"#faf8f9",3); // Line 20
    setCoordsAndPaintLine(25,18,"#faf8f9",2); // Line 19
    setCoordsAndPaintLine(25,17,"#faf8f9",4); // Line 18
    setCoordsAndPaintLine(26,16,"#faf8f9",5); // Line 17
    setCoordsAndPaintLine(28,15,"#faf8f9",-1); // Line 16
    setCoordsAndPaintLine(30,14,"#faf8f9",-1); // Line 15

    // Return to left side
    setCoordsAndPaintLine(0,22,"#faf8f9",9); // Line 23
    paintXY(10,22,"#faf8f9");
    setCoordsAndPaintLine(13,22,"#faf8f9",6);
    setCoordsAndPaintLine(0,23,"#faf8f9",5); // Line 24
    paintXY(7,23,"#faf8f9");
    setCoordsAndPaintLine(0,24,"#faf8f9",2); // Line 25
    paintXY(3,24,"#faf8f9");
    paintXY(6,24,"#faf8f9");
    paintXY(8,24,"#faf8f9");
    paintXY(0,25,"#faf8f9"); // Line 26

    // Diagonal lines
    paintXY(10,25,"#faf8f9");
    paintXY(10,26,"#faf8f9");

    paintXY(11,23,"#faf8f9");
    paintXY(11,24,"#faf8f9");
    paintXY(12,25,"#faf8f9");
    paintXY(13,26,"#faf8f9");
    setCoordsAndPaintLine(14,27,"#faf8f9",2);
    setCoordsAndPaintLine(16,28,"#faf8f9",2);
    setCoordsAndPaintLine(18,29,"#faf8f9",3);
    setCoordsAndPaintLine(21,30,"#faf8f9",2);
    paintXY(23,31,"#faf8f9");

    paintXY(15,23,"#faf8f9");
    paintXY(16,24,"#faf8f9");
    setCoordsAndPaintLine(17,25,"#faf8f9",2);
    setCoordsAndPaintLine(19,26,"#faf8f9",3);
    setCoordsAndPaintLine(22,27,"#faf8f9",2);
    paintXY(24,28,"#faf8f9");
    setCoordsAndPaintLine(25,29,"#faf8f9",2);
    paintXY(27,30,"#faf8f9");
    setCoordsAndPaintLine(28,31,"#faf8f9",3);

    // Upper-rightmost white part
    setCoordsAndPaintLine(18,23,"#faf8f9",2);
    setCoordsAndPaintLine(20,24,"#faf8f9",3);
    setCoordsAndPaintLine(23,23,"#faf8f9",4);
    setCoordsAndPaintLine(27,22,"#faf8f9",2);
    setCoordsAndPaintLine(29,21,"#faf8f9",-1);
    setCoordsAndPaintLine(27,24,"#faf8f9",2);
    setCoordsAndPaintLine(29,25,"#faf8f9",-1);
}

  public void paintBlue() {
    paintXY(11,6,"#225bce"); // Line 7
    setCoordsAndPaintLine(9,7,"#225bce",2); // Line 8
    setCoordsAndPaintLine(8,8,"#225bce",2); // Line 9
    setCoordsAndPaintLine(11,8,"#225bce",3);
    setCoordsAndPaintLine(10,9,"#225bce",3); // Line 10
    paintXY(7,10,"#225bce"); // Line 11
    setCoordsAndPaintLine(10,10,"#225bce",2);
    paintXY(3,11,"#225bce"); // Line 12
    setCoordsAndPaintLine(7,11,"#225bce",2);
    paintXY(10,11,"#225bce");
    setCoordsAndPaintLine(4,12,"#225bce",2); // Line 13
    setCoordsAndPaintLine(9,12,"#225bce",2);
    paintXY(4,13,"#225bce"); // Line 14
    paintXY(7,13,"#225bce");
    paintXY(9,13,"#225bce");
    paintXY(1,14,"#225bce"); // Line 15
    paintXY(4,14,"#225bce");
    setCoordsAndPaintLine(6,14,"#225bce",2);
    paintXY(9,14,"#225bce");
    paintXY(1,15,"#225bce"); // Line 16
    setCoordsAndPaintLine(3,15,"#225bce",2);
    setCoordsAndPaintLine(6,15,"#225bce",2);
    setCoordsAndPaintLine(9,15,"#225bce",2);
    paintXY(1,16,"#225bce"); // Line 17
    setCoordsAndPaintLine(3,16,"#225bce",2);
    setCoordsAndPaintLine(6,16,"#225bce",2);
    setCoordsAndPaintLine(9,16,"#225bce",2);
    setCoordsAndPaintLine(3,17,"#225bce",3); // Line 18
    paintXY(1,18,"#225bce"); // Line 19
    paintXY(5,18,"#225bce");
    setCoordsAndPaintLine(2,19,"#225bce",3); // Line 20
    paintXY(3,20,"#225bce"); // Line 21
    paintXY(10,21,"#225bce"); // Line 22
    paintXY(11,22,"#225bce"); // Line 23
    paintXY(5,23,"#225bce"); // Line 24
    setCoordsAndPaintLine(8,23,"#225bce",2);

    /*
    Paints the 5 blue 2x2 "boxes"
    First two boxes are near the center of the map
    Boxes 3-5 all have top left corners on y=26
    */
    
    paintRectangle(12,23,"#225bce",2,2); // First box
    paintXY(13,25,"#225bce");

    paintRectangle(14,25,"#225bce",2,2); //Second box
    paintXY(16,26,"#225bce");
    setCoordsAndPaintLine(16,27,"#225bce",4);
    setCoordsAndPaintLine(18,28,"#225bce",6);
    setCoordsAndPaintLine(21,29,"#225bce",4);
    setCoordsAndPaintLine(23,30,"#225bce",4);
    setCoordsAndPaintLine(24,31,"#225bce",4);

    paintXY(1,25,"#225bce");
    paintRectangle(1,26,"#225bce",2,2); // Third box
    setCoordsAndPaintLineDir(0,28,"#225bce",3,"south");
    paintXY(1,31,"#225bce");
    setCoordsAndPaintLine(2,28,"#225bce",2);

    paintXY(4,24,"#225bce");
    setCoordsAndPaintLine(3,25,"#225bce",2);
    paintRectangle(4,26,"#225bce",2,2); // Fourth box
    setCoordsAndPaintLine(5,28,"#225bce",2);

    paintXY(7,24,"#225bce");
    setCoordsAndPaintLine(6,25,"#225bce",2);
    paintRectangle(7,26,"#225bce",2,2); // Fifth box
    setCoordsAndPaintLine(8,28,"#225bce",2);

    // Lines 30-32
    setCoordsAndPaintLine(2,29,"#225bce",2);
    setCoordsAndPaintLine(2,30,"#225bce",2);
    setCoordsAndPaintLine(3,31,"#225bce",2);

    setCoordsAndPaintLine(5,29,"#225bce",2);
    setCoordsAndPaintLine(5,30,"#225bce",2);
    setCoordsAndPaintLine(6,31,"#225bce",2);
    
    setCoordsAndPaintLine(8,29,"#225bce",2);
    setCoordsAndPaintLine(8,30,"#225bce",2);
    setCoordsAndPaintLine(9,31,"#225bce",2);

    setCoordsAndPaintLineDir(11,28,"#225bce",3,"south");
    setCoordsAndPaintLineDir(12,29,"#225bce",3,"south");
    setCoordsAndPaintLineDir(13,30,"#225bce",2,"south");
    paintXY(14,31,"#225bce");
    

    setCoordsAndPaintLine(9,24,"#225bce",2);
    paintXY(9,25,"#225bce");
    paintXY(11,25,"#225bce");
    paintXY(10,27,"#225bce");
    paintXY(12,26,"#225bce");
    setCoordsAndPaintLine(12,27,"#225bce",2);
    setCoordsAndPaintLine(13,28,"#225bce",3);
    setCoordsAndPaintLine(14,29,"#225bce",4);
    setCoordsAndPaintLine(15,30,"#225bce",6);
    setCoordsAndPaintLine(16,31,"#225bce",7);

    setCoordsAndPaintLine(16,23,"#225bce",2);
    setCoordsAndPaintLine(17,24,"#225bce",3);
    setCoordsAndPaintLine(19,25,"#225bce",3);
    setCoordsAndPaintLine(22,26,"#225bce",2);
    paintXY(24,27,"#225bce");
    setCoordsAndPaintLine(25,28,"#225bce",2);
    setCoordsAndPaintLine(28,30,"#225bce",4);
    paintXY(31,31,"#225bce");

    setCoordsAndPaintLine(19,22,"#225bce",2);
    setCoordsAndPaintLine(20,23,"#225bce",2);
    paintRectangle(23,24,"#225bce",2,2);
    paintRectangle(25,25,"#225bce",2,2);
    paintRectangle(27,26,"#225bce",5,4);

    paintXY(22,21,"#225bce");
    setCoordsAndPaintLine(22,22,"#225bce",2);
    paintXY(24,20,"#225bce");
    setCoordsAndPaintLine(24,21,"#225bce",3);
    paintXY(26,22,"#225bce");
    setCoordsAndPaintLine(27,23,"#225bce",2);
    paintRectangle(29,22,"#225bce",3,3);
    paintRectangle(29,17,"#225bce",3,4);
    paintXY(31,16,"#225bce");

    setCoordsAndPaintLine(26,19,"#225bce",2);
    paintXY(28,18,"#225bce");
    setCoordsAndPaintLine(27,20,"#225bce",2);
  }

  public void paintLightBlue() {
    paintXY(8,7,"#85cbfe"); // Line 8
    setCoordsAndPaintLine(11,7,"#85cbfe",2);
    paintXY(10,8,"#85cbfe"); // Line 9
    paintXY(9,9,"#85cbfe"); // Line 10
    paintXY(13,9,"#85cbfe");
    paintXY(12,10,"#85cbfe"); // Line 11
    paintXY(4,11,"#85cbfe"); // Line 12
    paintXY(9,11,"#85cbfe");
    setCoordsAndPaintLineDir(11,11,"#85cbfe",2,"south");
    paintXY(3,12,"#85cbfe"); // Line 13
    paintXY(8,12,"#85cbfe");
    setCoordsAndPaintLineDir(10,13,"#85cbfe",2,"south");
    
    setCoordsAndPaintLineDir(2,14,"#85cbfe",4,"south"); // 4-long downward line on 2,14

    setCoordsAndPaintLineDir(5,13,"#85cbfe",4,"south"); // 4-long downward line on 5,13

    paintXY(6,17,"#85cbfe");

    setCoordsAndPaintLineDir(8,14,"#85cbfe",2,"south");

    setCoordsAndPaintLineDir(11,15,"#85cbfe",3,"south");

    setCoordsAndPaintLine(3,18,"#85cbfe",2);
    paintXY(5,19,"#85cbfe");
    setCoordsAndPaintLineDir(12,18,"#85cbfe",2,"south");
    paintXY(13,20,"#85cbfe");

    paintXY(9,22,"#85cbfe"); // Line 23
    paintXY(12,22,"#85cbfe");
    paintXY(6,23,"#85cbfe"); // Line 24
    paintXY(10,23,"#85cbfe");
    paintXY(14,23,"#85cbfe");

    setCoordsAndPaintLineDir(2,24,"#85cbfe",2,"south");
    setCoordsAndPaintLineDir(0,26,"#85cbfe",2,"south");
    paintXY(0,31,"#85cbfe");
    setCoordsAndPaintLineDir(1,28,"#85cbfe",3,"south");
    paintXY(2,31,"#85cbfe");
    
    setCoordsAndPaintLineDir(3,26,"#85cbfe",2,"south");
    setCoordsAndPaintLineDir(4,28,"#85cbfe",3,"south");
    paintXY(5,31,"#85cbfe");
    
    setCoordsAndPaintLineDir(5,24,"#85cbfe",2,"south");
    setCoordsAndPaintLineDir(6,26,"#85cbfe",2,"south");
    setCoordsAndPaintLineDir(7,28,"#85cbfe",3,"south");
    paintXY(8,31,"#85cbfe");

    paintXY(8,25,"#85cbfe");
    setCoordsAndPaintLineDir(9,26,"#85cbfe",2,"south");
    setCoordsAndPaintLineDir(10,28,"#85cbfe",3,"south");
    paintXY(11,31,"#85cbfe");

    setCoordsAndPaintLineDir(11,26,"#85cbfe",2,"south");
    paintXY(12,28,"#85cbfe");
    paintXY(13,29,"#85cbfe");
    paintXY(14,30,"#85cbfe");
    paintXY(15,31,"#85cbfe");
    setCoordsAndPaintLine(14,24,"#85cbfe",2);
    paintXY(16,25,"#85cbfe");
    setCoordsAndPaintLine(17,26,"#85cbfe",2);
    setCoordsAndPaintLine(20,27,"#85cbfe",2);

    paintXY(21,22,"#85cbfe");
    paintXY(22,23,"#85cbfe");
    paintXY(22,25,"#85cbfe");
    paintXY(24,26,"#85cbfe");
    setCoordsAndPaintLine(25,27,"#85cbfe",2);
    setCoordsAndPaintLine(27,28,"#85cbfe",3);
    setCoordsAndPaintLine(30,29,"#85cbfe",2);
    setCoordsAndPaintLine(25,24,"#85cbfe",2);
    setCoordsAndPaintLine(29,26,"#85cbfe",3);
    setCoordsAndPaintLine(27,25,"#85cbfe",2);
    paintXY(23,21,"#85cbfe");
    setCoordsAndPaintLine(24,22,"#85cbfe",2);
    setCoordsAndPaintLine(25,20,"#85cbfe",2);
    setCoordsAndPaintLine(27,21,"#85cbfe",2);
    paintXY(29,22,"#85cbfe");
    setCoordsAndPaintLine(30,23,"#85cbfe",2);
    paintXY(27,18,"#85cbfe");
    setCoordsAndPaintLine(28,19,"#85cbfe",2);
    setCoordsAndPaintLine(30,20,"#85cbfe",2);
    paintXY(30,17,"#85cbfe");
    paintXY(31,18,"#85cbfe");
  }
}
