package com.aboutobjects
import scala.annotation.tailrec

/**
  * Created by About Objects on 10/7/17.
  */

// example - sumAccumulator with pattern matching on List cons
object TailRecursion extends App {
  def sum(list: List[Int]): Int = {
    @tailrec
    def sumAccumulator(list: List[Int], accumulator: Int): Int = {
      list match {
        case Nil => accumulator
        // x :: xs is the cons method. Here it deconstructs list into head and tail
        case x :: xs => sumAccumulator(xs, accumulator + x)
      }
    }
    sumAccumulator(list, 0)
  }
}

// example - product of ints
object productOfInts extends App {

  // first attempt at recursion
  def productOfInts(ints: List[Int]): Int = ints match {
    case Nil => 1
    case head :: tail => head * productOfInts(tail)    // not tail recursive here
  }

  // with tail-recursion
  def product(ints: List[Int]): Double = {
    @tailrec
    def productAccumulator(ints: List[Int], accum: Double): Double = {
      ints match {
        case Nil => accum
        case head :: tail => productAccumulator(tail, accum * head)
      }
    }

    productAccumulator(ints, 1)
  }

  val giantList = (1 to 10).toList
  println(s"product: ${productOfInts(giantList)}")
  //println(s"product: ${product(giantList)}")

}

// Class exercise - sum of squares
object sumOfSquares extends App {
  def sumOfSquares(ints: List[Int]): Double = {
    @tailrec
    def nestedAccumulator(ints: List[Int], accum: Double): Double = {
      ints match {
        case Nil => accum
        case head :: tail => nestedAccumulator(tail, accum + (head * head))
      }
    }
    nestedAccumulator(ints, 0.0)
  }
  println("Empty list: " + sumOfSquares(List()))
  println("List of 1 and 2: " + sumOfSquares(List(1,2)))
  println("Giant List: " + sumOfSquares((1 to 1000000).toList))
}
