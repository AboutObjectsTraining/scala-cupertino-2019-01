package com.aboutobjects

/**
  * Created by About Objects on 10/4/17.
  */
object ForExpressionFiltered extends App {

   val printOddsIn = (range: Range) => {
     for(x <- range
       if x % 2 == 0) println(x)
   }

  printOddsIn(1 to 10)
}
