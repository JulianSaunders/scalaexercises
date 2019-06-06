package RestaurantBilling.flexCart

import org.scalatest._

class FlexCartTest extends FunSuite with Matchers {

  test("Add 2 items to basket and print it") {
    FlexCart.addToBasket("Cola")
    FlexCart.addToBasket("Water")
    FlexCart.returnBasket() should be("Cola,Water")
  }



}