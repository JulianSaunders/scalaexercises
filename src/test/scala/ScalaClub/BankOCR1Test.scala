package ScalaClub

import org.scalatest.{FunSuite, Matchers}

class BankOCR1Test extends FunSuite with Matchers {
  val numAll0 = " _  _  _  _  _  _  _  _  _ \n| || || || || || || || || |\n|_||_||_||_||_||_||_||_||_|\n"
  val num1to9= "    _  _     _  _  _  _  _ \n  | _| _||_||_ |_   ||_||_|\n  ||_  _|  | _||_|  ||_| _|"


  test("Convert entry string into number string 000000000") {
    BankOCR1.convertEntryToNumber(numAll0) should be("000000000")
  }

  test("Convert entry string into number string 123456789") {
    BankOCR1.convertEntryToNumber(num1to9) should be("123456789")
  }

  test("encoded digit 0 converts") {
    BankOCR1.convertEncToDigit(" _ | ||_|") should be("0")
  }
  test("encoded digit 1 converts") {
    BankOCR1.convertEncToDigit("     |  |") should be("1")
  }
  test("encoded digit 2 converts") {
    BankOCR1.convertEncToDigit(" _  _||_ ") should be("2")
  }
  test("encoded digit 3 converts") {
    BankOCR1.convertEncToDigit(" _  _| _|") should be("3")
  }
  test("encoded digit 4 converts") {
    BankOCR1.convertEncToDigit("   |_|  |") should be("4")
  }
  test("encoded digit 5 converts") {
    BankOCR1.convertEncToDigit(" _ |_  _|") should be("5")
  }
  test("encoded digit 6 converts") {
    BankOCR1.convertEncToDigit(" _ |_ |_|") should be("6")
  }
  test("encoded digit 7 converts") {
    BankOCR1.convertEncToDigit(" _   |  |") should be("7")
  }
  test("encoded digit 8 converts") {
    BankOCR1.convertEncToDigit(" _ |_||_|") should be("8")
  }
  test("encoded digit 9 converts") {
    BankOCR1.convertEncToDigit(" _ |_| _|") should be("9")
  }

}
