import cats.implicits._

import scala.util.{Failure, Success, Try}

object CatsTryDemo extends App {

  override def main(args: Array[String]): Unit = {

    // We have a List[Try[String]] but we want a Try[List[String]].
    // we want it to be a Failure if any of the Try was a Failure.
    val listOfTries: List[Try[String]] = List(Failure(new   Exception), Success("b"), Success("c"))
    val tryOfList: Try[List[String]] = listOfTries.sequence
    println(tryOfList) //Failure(new Exception)
    val listOfTriesOther: List[Try[String]] = List(Success("a"), Success("b"), Success("c"))
    val tryOfListOther:Try[List[String]] = listOfTriesOther.sequence
    println(listOfTriesOther) //Success(List(a, b, c))
  }
}