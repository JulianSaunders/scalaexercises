package livecode

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

// live code interview
// lazy, and futures in a for

object Test20190624_b2 extends App {

  println("\n----------\n")

  val f1 = Future{Thread.sleep(1000); 1}
  val f2 = Future{Thread.sleep(1000); 2}

  println("START:B")

  val futureFor2 = for {
    r1 <- f1
    r2 <- f2
  } yield (r1 + r2)

  futureFor2.onComplete {
    case Success(value) => println(s"END2:value is $value :")
    case Failure(exception) => println("FAILURE2")
  }

  println("\n----------\n")


  Thread.sleep(3000)
  println("THE END:")
}
