package com.aboutobjects

import org.scalatest.{FlatSpec, Matchers}

class TriangleTests extends FlatSpec with Matchers {

  // 3 points are colinear case - area should be 0
  val colinearPointsTriangle = new Triangle(1,1,2)

  "A colinear points triangle" should "have 3 sides" in {
    colinearPointsTriangle.numberOfSides shouldEqual 3
  }

  it should "have an area of 0" in {
    colinearPointsTriangle.area shouldEqual(0)
  }

  "Number of shapes" should "only be one for this test" in {
    Shape.numberOfShapes shouldEqual 1
  }

}
