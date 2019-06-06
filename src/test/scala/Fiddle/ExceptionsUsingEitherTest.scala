package Fiddle

import org.scalatest.{FunSuite, Matchers}


class ExceptionsUsingEitherTest extends FunSuite with Matchers {

  test("print result") {
    ExceptionsUsingEither.run
  }
}
