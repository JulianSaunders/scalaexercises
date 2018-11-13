package Fiddle


import org.scalatest.{FunSuite, Matchers}


class CollectCaseTest extends FunSuite with Matchers {

  test("print result") {
    CollectCase.run()
  }
}
