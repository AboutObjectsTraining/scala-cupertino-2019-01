package com.aboutobjects

import org.scalatest.{FlatSpec, Matchers}

class RectangleTests extends FlatSpec with Matchers {

  val rect2by4 = new Rectangle(width = 2.0, height = 4.0)

  "A 2 x 4 rectangle" should "always have 4 sides" in {
    rect2by4.numberOfSides shouldEqual 4
  }

  it should "have an area of 8" in {
    rect2by4.area shouldEqual(8)
  }

  "Number of shapes" should "only be one for this test" in {
    Shape.numberOfShapes shouldEqual 1
  }

}
