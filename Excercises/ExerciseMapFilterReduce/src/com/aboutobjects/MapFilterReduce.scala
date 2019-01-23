package com.aboutobjects

/**
  * Created by About Objects on 10/6/17.
  */
object MapFilterReduce extends App {

  // 1.) Sum of the even numbers between 1 and 20 inclusive
  val sumOfEvens = (1 to 20) filter{_ % 2 == 0} reduce(_ + _)
  println(sumOfEvens)


  // 2.) Create a Person class with name, age, and gender.
  // Create a list of people multiple males and females.
  case class Person(name: String, age: Int, gender: String)
  val peeps = List(Person("Bob", 21, "M"),
    Person("Cindy", 16, "F"),
    Person("Bill", 30, "M"),
    Person("Betty", 21, "F"),
    Person("Greg", 60, "M"),
    Person("Bonnie", 50, "F")
  )

  // 3.) Print a list of Men over 20 yrs. old sorted by age oldest first
  println(peeps.filter(_.gender == "M").filter(_.age > 20).sortBy(_.age).reverse)


  // 4. Create a copy of the original peeps list but replace the men’s name with Mr. <Name>.
  val people = peeps.map{(x: Person) =>
    x match {
      case _ if(x.gender == "M") => x.copy(name = s"Mr. ${x.name}")
      case _ => x.copy()
    }
  }
  println(people)
}
