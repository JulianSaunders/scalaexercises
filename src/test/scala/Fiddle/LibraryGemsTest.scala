package Fiddle

import org.scalatest.{FunSuite, Matchers}


class LibraryGemsTest extends FunSuite with Matchers {

  test("print result") {
    LibraryGems.run
  }
}
