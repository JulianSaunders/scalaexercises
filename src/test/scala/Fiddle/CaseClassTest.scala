package Fiddle

import org.scalatest.{FunSuite, Matchers}


class CaseClassTest extends FunSuite with Matchers {

  test("print result") {
    CaseClass.run
  }
}
