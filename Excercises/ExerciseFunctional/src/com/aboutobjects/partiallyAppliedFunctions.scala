package com.aboutobjects

/**
  * Created by About Objects on 10/6/17.
  */
object partiallyAppliedFunction extends App {

  def areaOfTriangle(a: Double, b: Double, c: Double) = {
    1D/4 * Math.sqrt((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c))
  }

  val sides10WithBase = areaOfTriangle(10,10,_:Double)

  //println(sides10WithBase(1))

  (0 to 20).foreach((x:Int) => println(s"${x}, ${sides10WithBase(x)}"))

}
