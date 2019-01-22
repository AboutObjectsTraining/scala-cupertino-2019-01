package com.aboutobjects

/**
  * Created by About Objects on 10/4/17.
  */
class Rectangle(val width: Double, val height: Double, color: String = "black")
  extends Shape(color = color, numberOfSides = 4) {
  override def area = width * height

  override def toString: String = s"Width: ${width}, Height: ${height}, " + super.toString
}

object testRectangle extends App {
  val rect1 = new Rectangle(width = 2.0, height = 4.0)
  println(s"Numer of shapes created so far: ${Shape numberOfShapes}")
  assert(assertion = rect1.numberOfSides == 4)
  assert(assertion = rect1.area == 8)
  assert(assertion = Shape.numberOfShapes == 1)

  val rect2 = new Rectangle(width = 4.0, height = 10.0, color = "red")
  println(s"Numer of shapes created so far: ${Shape numberOfShapes}")
  assert(assertion = rect2.numberOfSides == 4)
  assert(assertion = rect2.area == 40)
  assert(assertion = Shape.numberOfShapes == 2)

  for (rect <- List(rect1, rect2)) {println(rect)}
}
