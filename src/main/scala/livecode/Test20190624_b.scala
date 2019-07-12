package livecode

import java.util.Calendar

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

// live code interview
// lazy, and futures in a for

object Test20190624_b extends App {

  println("\n----------\n")


  lazy val lazyV = println("hello from lazyV")
  val notLazyV = println("hello from notLazyV")

  val a = (lazyV, lazyV)
  val b = (notLazyV, notLazyV)
  println("a=" + a)
  println("b=" + b)


  println("\n----------\n")

  val nowStart = Calendar.getInstance()
  println("START:")
  val futureFor1 = for {
    r1 <- Future{Thread.sleep(1000);1}
    r2 <- Future{Thread.sleep(1000);2}
  } yield {
    r1 + r2
  }

  futureFor1.onComplete {
    case Success(value) =>
      val nowEnd = Calendar.getInstance()
      println(s"END1:$value :${nowEnd.getTimeInMillis - nowStart.getTimeInMillis}")
    case Failure(exception) => println("FAILURE")
  }
  println("\n------------------------------------------------------------------------------------------\n")

  val f1 = Future{Thread.sleep(1000); 1}
  val f2 = Future{Thread.sleep(1000); 2}

  val nowStartB = Calendar.getInstance()
  println("START_B:")

  val futureFor2 = for {
    r1 <- f1
    r2 <- f2
  } yield {
    r1 + r2
  }

  futureFor2.onComplete {
    case Success(value) =>
      val nowEnd = Calendar.getInstance()
      println(s"END_B2:$value :${nowEnd.getTimeInMillis - nowStart.getTimeInMillis}")
    case Failure(exception) => println("FAILURE2")
  }

  println("\n----------\n")


  Thread.sleep(3000)
  println("THE END:")
}
