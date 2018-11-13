package RestaurantBilling.v1_bad_enum

import DrinkOrFood.DrinkOrFood
import HotOrCold.HotOrCold
import Premium.Premium

case class MenuItem(name: String, drinkOrFood: DrinkOrFood, hotOrCold: HotOrCold, premium: Premium, Price: BigDecimal)

object DrinkOrFood extends Enumeration{
  type DrinkOrFood = Value

  val DRINK = Value("DRINK")
  val FOOD = Value("FOOD")
}

object HotOrCold extends Enumeration{
  type HotOrCold = Value

  val HOT = Value("HOT")
  val COLD = Value("COLD")
}

object Premium extends Enumeration{
  type Premium = Value

  val PREMIUM = Value("PREMIUM")
  val STANDARD = Value("STANDARD")
}

case class BillCalculator() {

  def calculateTotalBill(items: Seq[MenuItem]): BigDecimal = {
    val itemTotalCost = items.map(mi => mi.Price).sum
    val serviceChargePercentage = calculateServiceCharge(items, itemTotalCost)
    (itemTotalCost + serviceChargePercentage).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }

  def calculateServiceCharge(items: Seq[MenuItem], itemTotalCost: BigDecimal): BigDecimal = {
    val percentage = items.map(i => (i.hotOrCold, i.drinkOrFood, i.premium) match {
      case (_, _, Premium.PREMIUM) => 0.25
      case (HotOrCold.HOT, DrinkOrFood.FOOD, Premium.STANDARD) => 0.20
      case (HotOrCold.COLD, DrinkOrFood.FOOD, Premium.STANDARD) => 0.10
      case _ => 0
    }).max

    percentage match {
      case 0.25 => (itemTotalCost * percentage).min(40)
      case 0.20 => (itemTotalCost * percentage).min(20)
      case 0.10 => (itemTotalCost * percentage)
      case _ => 0
    }
  }
}
