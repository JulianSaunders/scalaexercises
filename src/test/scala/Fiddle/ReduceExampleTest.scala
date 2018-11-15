package Fiddle

import org.scalatest.{FunSuite, Matchers}


class ReduceExampleTest extends FunSuite with Matchers {

  test("print result for reduce") {
    ReduceExample.runReduce
  }

  test("print result for reduceLeft") {
    ReduceExample.runReduceLeft
  }

  test("print result for reduceRight") {
    ReduceExample.runReduceRight
  }
}
