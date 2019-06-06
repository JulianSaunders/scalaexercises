package Fiddle

import org.scalatest.{FunSuite, Matchers}


class RecoverDemoTest extends FunSuite with Matchers {

  test("print result") {
    RecoverDemo.run
  }
}