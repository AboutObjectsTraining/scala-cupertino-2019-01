package com.aboutobjects

/**
  * Created by About Objects on 10/4/17.
  */
object ForComprehension extends App {

  val oddsIn = (range: Range) => {
    for(x <- range
      if x % 2 == 0)
      yield(x)
  }

  println(oddsIn(1 to 10))
}
