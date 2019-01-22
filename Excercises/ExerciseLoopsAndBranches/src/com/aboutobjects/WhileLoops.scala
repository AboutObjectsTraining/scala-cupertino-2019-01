package com.aboutobjects

/**
  * Created by About Objects on 10/4/17.
  */
object WhileLoops extends App {

  val printNTimes = (string: String, times: Int) => {
    var counter = times
    while(counter > 0) {
      println(string)
      counter -= 1
    }
  }

  printNTimes("Betty", 5)
}
