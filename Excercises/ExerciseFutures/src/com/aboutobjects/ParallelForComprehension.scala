package com.aboutobjects

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object ParallelForComprehension extends App {

  val f1 = Future { Thread.sleep(500); 1}
  val f2 = Future { Thread.sleep(1000); 2}
  val f3 = Future { Thread.sleep(1500); 3}

  val startTime = System.currentTimeMillis


  // see https://docs.scala-lang.org/style/control-structures.html
  // for comprehensions can take () or {}

  // don't do this ... bad style
  //  val results = for (
  //    r1 <- f1;
  //    r2 <- f2;
  //    r3 <- f3
  //  ) yield (r1 + r2 + r3)

  // do this ... good style "for comprehensions with multiple generators"
  // runs in parallel time should be close to 1500 ms
//    val results = for {
//      r1 <- f1
//      r2 <- f2
//      r3 <- f3
//    } yield (r1 + r2 + r3)

  // runs sequentially not in parallel ... should be close to 4000 ms
  val results = for {
    r1 <- Future { Thread.sleep(1000); 1}
    r2 <- Future { Thread.sleep(1000); 2}
    r3 <- Future { Thread.sleep(2000); 3}
  } yield (r1 + r2 + r3)

  results.onComplete {
    case Success(x) => {
      val runTime = System.currentTimeMillis - startTime
      println(s"result = $x")
      println(s"Processing time: $runTime")
    }
    case Failure(error) => println(s"error: $error")
  }

  Thread.sleep(5000) // for demo keep jvm alive
}
