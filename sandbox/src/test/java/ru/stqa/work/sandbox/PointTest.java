package ru.stqa.work.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testPoint(){

    Point p1 = new Point(5,3);
    Point p2 = new Point(1,0);

    Assert.assertEquals(p1.distance(p2), 5.0);
  }
}
