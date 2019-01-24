package com.aboutobjects

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
  * Created by About Objects on 10/9/17.
  */

object Futures extends App {
  val url = "https://www.apple.com"
  // capture time to call and html from the url in a tuple
  val f: Future[(Long, String)] = Future {
    val start = System.currentTimeMillis()
    val html = scala.io.Source.fromURL(url).mkString
    val stop = System.currentTimeMillis()
    val millis = stop - start
    (millis, html)
  }

  // Using callbacks to collect the results
  f onComplete {
    case Success((millis, text)) => {
      println(millis + " milliseconds to run")
      println(text)
    }
    case Failure(t) => println("an error occurred: " + t.getMessage)
  }

  Thread sleep 3000
  println("Program Done")
}
