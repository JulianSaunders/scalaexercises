package RestaurantBilling.v1_bad_enum

import org.scalatest.{FunSpec, _}

class BillCalculatorTest extends FunSpec with Matchers {

  val cola = MenuItem("Cola", DrinkOrFood.DRINK, HotOrCold.COLD, Premium.STANDARD, 0.50)
  val coffee = MenuItem("Coffee", DrinkOrFood.DRINK, HotOrCold.HOT, Premium.STANDARD, 1.00)
  val cheeseSandwich = MenuItem("Cheese Sandwich", DrinkOrFood.FOOD, HotOrCold.COLD, Premium.STANDARD, 2.00)
  val steakSandwich = MenuItem("Steak Sandwich", DrinkOrFood.FOOD, HotOrCold.HOT, Premium.STANDARD, 4.50)
  val lobster = MenuItem("Lobster", DrinkOrFood.FOOD, HotOrCold.HOT, Premium.PREMIUM, 25)

  describe("The BillCalculator object") {
    it("should return the total bill for 1 item") {
      val billcalc = new BillCalculator
      billcalc.calculateTotalBill(Seq(cola)) shouldEqual 0.50
    }

    it("should return the total bill for 2 items that are the same") {
      val billcalc = new BillCalculator
      billcalc.calculateTotalBill(Seq(cola, cola)) shouldEqual 1.00
    }

    it("should return the total bill for 3 items") {
      val billcalc = new BillCalculator
      billcalc.calculateTotalBill(Seq(cola, coffee, cheeseSandwich)) shouldEqual 3.85
    }

    it("should return the total bill for 4 items") {
      val billcalc = new BillCalculator
      billcalc.calculateTotalBill(Seq(cola, coffee, cheeseSandwich, steakSandwich)) shouldEqual 9.6
    }

    it("should return the total bill for 1 COLD FOOD item which has a service charge of 10%") {
      val billcalc = new BillCalculator
      billcalc.calculateTotalBill(Seq(cheeseSandwich)) shouldEqual 2.20
    }

    it("should return the total bill for 1 HOT FOOD item which has a service charge of 20%") {
      val billcalc = new BillCalculator
      billcalc.calculateTotalBill(Seq(steakSandwich)) shouldEqual 5.40
    }

    it("should return the total bill for 100 HOT FOOD item which has a service charge of 20%") {
      val billcalc = new BillCalculator
      billcalc.calculateTotalBill(Seq.fill(100)(steakSandwich)) shouldEqual 470.00
    }

    it("should return the total bill for 100 PREMIUM item which has a service charge of 25%") {
      val billcalc = new BillCalculator
      billcalc.calculateTotalBill(Seq.fill(100)(lobster)) shouldEqual 2540.00
    }
  }
}
