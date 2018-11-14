package Fiddle

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureFlatMap {

  def run ={
    def addTwo(n:Int):Future[Int] = Future { n + 2 }

    def addTwoAndDouble(n:Int):Future[Int] = addTwo(n).map { x:Int => x*2 }

    def addTwoAddTwo(n:Int):Future[Int] = addTwo(n).flatMap { n2 => addTwo(n2) }

    addTwoAndDouble(4).onComplete(x => println(x))
    addTwoAddTwo(2).onComplete(x => println(x))
  }

}
