package com.aboutobjects

/**
  * Created by About Objects on 10/4/17.
  */
object MatchStatements extends App {

  val parseMessage = (string: String) =>  {
     string match {
       case string if string isEmpty  => "Empty string"
       case string if string.toUpperCase == string => "All caps string"
       case string if string.toLowerCase == string => "All lower case string"
       case _ => "no match"
    }
  }

  println(parseMessage(""))
  println(parseMessage("Hello World"))
  println(parseMessage("BOBBY"))
  println(parseMessage("bobby"))
}
