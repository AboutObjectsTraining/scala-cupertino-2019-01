package com.aboutobjects.shapes

/**
  * Created by About Objects on 10/5/17.
  */

case class Rectangle(width:Double, height:Double, color:String = "black") () {
  val numberOfSides: Int = 4
  def area() = width * height
  override def toString: String = s"Width: ${width}, Height: ${height}, Color: ${color}, Sides: ${numberOfSides}, Area: ${area}"
}

case class Triangle(a:Double, b:Double, c:Double, color:String = "black") {
  val numberOfSides:Int = 3
  def area() = 1D/4 * Math.sqrt((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c))
  override def toString: String = s"a: ${a}, b: ${b}, c: ${c}, Color: ${color}, Sides: ${numberOfSides}, Area: ${area}"
}

object testShapes extends App {
  val rect1 = Rectangle(width = 10, height = 20, "red")
  val rect2 = Rectangle(width = 1, height = 1)
  val triangle1 = Triangle(10, 20, 20, "blue")
  val triangle2 = Triangle(1, 1, 10)
  println(rect1)
  println(rect2)
  println(triangle1)
  println(triangle2)
}




