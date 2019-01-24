
package com.aboutobjects

/**
  * Created by About Objects on 10/4/17.
  */


class Triangle(val a: Double, val b: Double, val c: Double, color: String = "black") extends
  Shape(color = color, numberOfSides = 3) {
  // area using Heron's formula
  override def area: Double = 1D/4 * Math.sqrt((a + b + c)*(-a + b + c)*(a - b + c)*(a + b - c))

  override def toString: String = s"a: ${a}, b: ${b}, c: ${c}, " + super.toString
}

//object Triangle {
//  def apply(a: Double, b
//
//  : Double, c: Double, color: String = "black"): Option[Triangle] = {
//    if ((a + b) > c) Some(new Triangle(a,b,c,color))
//    else None
//  }
//}

object testTriangle extends App {
  val triangle1 = new Triangle(3,4,5)
  println(triangle1)

  // 3 points are colinear case - area should be 0
  val triangle2 = new Triangle(1,1,2)
  println(triangle2)
  assert(triangle2.area == 0.0)

  // sum of two sides is less than third side ... not a triangle
  val triangle3 = new Triangle(1,1,10)
  println(triangle3)


//  val possibleTriangle = Triangle(1,1,10)
//  possibleTriangle.foreach(t => println(t.area))
//  possibleTriangle match {
//    case None => println("Invalid Triangle")
//    case Some(t) => t.asInstanceOf[Triangle].area
//  }

}

