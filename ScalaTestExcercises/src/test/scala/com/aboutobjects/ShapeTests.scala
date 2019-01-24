package com.aboutobjects

import org.scalatest.{FlatSpec, Matchers}

// Shape is an abstract class and gets tested by its subclass unit tests
// Check coverage for completeness
class ShapeTests extends FlatSpec with Matchers {

  "Shape is an abstract class" should "and gets tested by its subclass unit tests" in {
    true
  }

}
