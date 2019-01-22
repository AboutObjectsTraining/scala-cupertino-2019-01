package com.aboutobjects

/**
  * Created by About Objects on 10/4/17.
  */
object ForExpression extends App {

  val printNTimes = (string: String, times: Int) => {
    for(i <- 0 until times)
      println(string)
  }

  printNTimes("Betty", 5)
}
