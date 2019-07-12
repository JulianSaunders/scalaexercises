package livecode

import org.scalatest.{FunSuite, Matchers}

class Test20190621Spec extends FunSuite with Matchers {

  val bag1 = Vector(1, 1, 1, 1, 1, 1) //u=1,bro=3,ans=1
  val bag2 = Vector(1, 1, 1, 2, 2, 2) //u=2,bro=3,ans=2
  val bag3 = Vector(1, 1, 2, 2, 3, 3) //u=3,bro=3,ans=3
  val bag4a = Vector(1, 1, 2, 2, 3, 4) //u=4,bro=3,ans=3     1,2,3  1,2,4
  val bag4b = Vector(1, 1, 2, 2, 3, 3, 4, 4) //u=4,bro=4,ans=4     1,2,3,4  1,2,3,4
  val bag5a = Vector(1, 1, 2, 2, 3, 4, 5, 5) //u=5,bro=4,ans=4     1,2,3,5  1,2,4,5
  val bag9 =  Vector(1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 8, 8, 9,10) //u=10,bro=7, ans=7    3,4,8,8,1,2,5  3,4,6,7,8,9,10

  test("1 unique ") {
    Test20190621.calcBroSweets(bag1) should be(1)
  }

  test("2 unique ") {
    Test20190621.calcBroSweets(bag2) should be(2)
  }

  test("3 unique ") {
    Test20190621.calcBroSweets(bag3) should be(3)
  }

  test("4 unique A") {
    Test20190621.calcBroSweets(bag4a) should be(3)
  }

  test("4 unique B") {
    Test20190621.calcBroSweets(bag4b) should be(4)
  }

  test("5 unique A") {
    Test20190621.calcBroSweets(bag5a) should be(4)
  }

  test("9 unique ") {
    Test20190621.calcBroSweets(bag9) should be(7)
  }
}