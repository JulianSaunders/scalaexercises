package RestaurantBilling.v3

sealed trait ItemType
case object Drink extends ItemType
case object FoodCold extends ItemType
case object FoodHot extends ItemType
case object Premium extends ItemType

case class MenuItem(name: String, itemType: ItemType, price: BigDecimal)

object BillCalculatorV3 {
  val validMenuItems = Map(
    "Cola" -> MenuItem("Cola", Drink, 0.50),
    "Coffee" -> MenuItem("Coffee", Drink, 1.00),
    "Cheese Sandwich" -> MenuItem("Cheese Sandwich", FoodCold, 2.00),
    "Steak Sandwich" -> MenuItem("Steak Sandwich", FoodHot, 4.50),
    "Lobster" -> MenuItem("Lobster", Premium, 25.00)
  )

  def calculateTotalBill(itemsOrdered: Seq[String]): BigDecimal = {
    val validItemsOrdered = itemsOrdered.flatMap(validMenuItems.get)
    val itemTotalCost: BigDecimal = validItemsOrdered.foldLeft(BigDecimal(0.00))(_ + _.price)
    val serviceCharge =
      if (validItemsOrdered.exists(_.itemType == Premium)) itemTotalCost * BigDecimal(0.25) min 40
      else if (validItemsOrdered.exists(_.itemType == FoodHot)) itemTotalCost * BigDecimal(0.20) min 20
      else if (validItemsOrdered.exists(_.itemType == FoodCold)) itemTotalCost * BigDecimal(0.10)
      else BigDecimal(0.00)
    (itemTotalCost + serviceCharge).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }
}