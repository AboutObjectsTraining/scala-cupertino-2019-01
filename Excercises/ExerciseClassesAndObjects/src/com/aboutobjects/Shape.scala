package com.aboutobjects

/**
  * Created by About Objects on 10/4/17.
  */
abstract class Shape(val color: String = "black", val numberOfSides: Int = 0) {
  def area = 0.0
  Shape shapeAdded  // call object Shape's method
  override def toString: String = s"Color: ${color}, Sides: ${numberOfSides}, Area: ${area}"
}

object Shape {
  var numberOfShapes: Int = 0
  def shapeAdded(): Unit = numberOfShapes += 1
}

// Test triangles and rectangles together
object testShapes extends App {
  val rect1 = new Rectangle(width = 10, height = 20)
  val rect2 = new Rectangle(width = 1, height = 1)
  val triangle1 = new Triangle(10, 20, 20)
  val triangle2 = new Triangle(6, 8, 10)
  val list = List(rect1, rect2, triangle1, triangle2)

  println(s"Number of shapes: ${Shape.numberOfShapes}")
  assert(Shape.numberOfShapes == 4)

  val areas = list.map((s: Shape) => s.area)
  println(s"Areas: ${areas}")

  val sides = list.map((s: Shape) => s.numberOfSides)
  println(s"Sides: ${sides}")
}
