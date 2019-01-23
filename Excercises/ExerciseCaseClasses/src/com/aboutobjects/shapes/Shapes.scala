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

//___________________________Pattern Matching including variable definition for a pattern - @ sign Exercise _____________
object testMatchWithPattern extends App
{
  def matchThis(thing:Any):String = {
    thing match {
      case string : String => s"You gave me a String ${string}"
      case rectangle @ Rectangle(width, height, color) => s"You gave me a Rectange Object with ${rectangle.width} ${rectangle.height} ${rectangle.color}"
      case triangle @ Triangle(a, b, c, color) => s"You gave me a Triangle Object with ${triangle.a} ${triangle.b} ${triangle.c} ${triangle.color}"
      case matchingList @ List(Rectangle(10,20,"red"), _*) => s"You gave me a List: $matchingList"
      case default => "You gave me something I didn't recognize"
    }
  }

  val rect1 = Rectangle(10, 20, "red")
  val rect2 = Rectangle(width = 1, height = 1)
  val triangle1 = Triangle(10, 20, 20, "blue")
  val triangle2 = Triangle(1, 1, 10)

  val shapes = List(rect1, rect2, triangle1, triangle2)
  for(item <- shapes) println(matchThis(item))

  // test using the @ sign - notice the contents of the matchingList
  println()
  println(matchThis(List(1, 2, rect1, "Joe")))
  println(matchThis(List(rect1, "Joe", 1, 2)))
}



//___________________________ Option Exercise _____________
object Triangle {
  def hebronsArea(a:Double, b: Double, c:Double): Double = 1D/4 * Math.sqrt((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c))
  def create(a: Double, b: Double, c: Double, color: String = "black", numberOfSides: Int = 3): Option[Triangle] = {
    val area = hebronsArea(a,b,c)
    if(area == 0.0 || area.isNaN()) None
    else Some(Triangle(a, b, c, color))
  }
}

object Rectangle {
  def create(width:Double, height:Double, color:String = "black") = {
    if(width == 0.0 || height == 0.0) None
    else Some(Rectangle(width, height, color))
  }
}

object testShapesWithOptionalTriangles extends App {
  val rect1 = Rectangle(width = 10, height = 20, "red")
  val list = List(
    Rectangle.create(width = 1, height = 1),
    Rectangle.create(width = 0, height = 1),
    Triangle.create(1, 1, Math.sqrt(2)),
    Triangle.create(1,1,0),
    Triangle.create(1,1,1000),
    Triangle.create(10,10,10)
  )
  for (i <- list) {
    i match {
      case None => println("None")
      case Some(i) => {
        Some(i).get match  {
          case _:Triangle => println(s"Triangle: ${i}")
          case _:Rectangle => println(s"Rectangle: ${i}")
          case _ => println("Some unknown")
        }
      }
    }
  }
}


