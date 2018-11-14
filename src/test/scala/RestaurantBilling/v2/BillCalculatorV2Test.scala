package RestaurantBilling.v2

import org.scalatest.{FunSpec, _}

class BillCalculatorV2Test extends FunSpec with Matchers {

  val cola ="Cola"
  val coffee = "Coffee"
  val cheeseSandwich = "Cheese Sandwich"
  val steakSandwich = "Steak Sandwich"
  val lobster = "Lobster"
  val invalid = "invalid"


  describe("The BillCalculatorV2 object") {
    it("should return the bill without service charge for 1 item") {
      BillCalculatorV2.calculateTotalWithoutServiceCharge(Seq(cola)) shouldEqual 0.50
    }

    it("should return the bill without service charge for 2 items that are the same") {
      BillCalculatorV2.calculateTotalWithoutServiceCharge(Seq(cola, cola)) shouldEqual 1.00
    }

    it("should return the bill without service charge for 3 items") {
      BillCalculatorV2.calculateTotalWithoutServiceCharge(Seq(cola, coffee, cheeseSandwich)) shouldEqual 3.50
    }

    it("should return the bill without service charge for 4 items") {
      BillCalculatorV2.calculateTotalWithoutServiceCharge(Seq(cola, coffee, cheeseSandwich, steakSandwich)) shouldEqual 8.00
    }

    it("should return the bill without service charge for 4 valid items and 4 invalid items") {
      BillCalculatorV2.calculateTotalWithoutServiceCharge(Seq(cola, coffee, cheeseSandwich, steakSandwich, invalid, invalid, invalid, invalid)) shouldEqual 8.00
    }

    it("should return the total bill for 3 items") {
      BillCalculatorV2.calculateTotalBill(Seq(cola, coffee, cheeseSandwich)) shouldEqual 3.85
    }

    it("should return the total bill for 4 items") {
      BillCalculatorV2.calculateTotalBill(Seq(cola, coffee, cheeseSandwich, steakSandwich)) shouldEqual 9.6
    }

    it("should return the total bill for 1 COLD FOOD item which has a service charge of 10%") {
      BillCalculatorV2.calculateTotalBill(Seq(cheeseSandwich)) shouldEqual 2.20
    }

    it("should return the total bill for 1 HOT FOOD item which has a service charge of 20%") {
      BillCalculatorV2.calculateTotalBill(Seq(steakSandwich)) shouldEqual 5.40
    }

    it("should return the total bill for 100 HOT FOOD item which has a service charge of 20%") {
      BillCalculatorV2.calculateTotalBill(Seq.fill(100)(steakSandwich)) shouldEqual 470.00
    }

    it("should return the total bill for 100 PREMIUM item which has a service charge of 25%") {
      BillCalculatorV2.calculateTotalBill(Seq.fill(100)(lobster)) shouldEqual 2540.00
    }
  }
}
