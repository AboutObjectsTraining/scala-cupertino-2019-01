package com.aboutobjects

/**
  * Created by About Objects on 10/4/17.
  */
object IfConditional {

  def main(args: Array[String]): Unit = {

    var max10 = (x: Int) => if(x < 10) x else 10

    println(max10(-1))
    println(max10(10))
    println(max10(11))

  }
}
