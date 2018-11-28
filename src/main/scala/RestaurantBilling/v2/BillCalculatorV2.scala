package RestaurantBilling.v2

sealed trait ItemType
case object Drink extends ItemType
case object FoodCold extends ItemType
case object FoodHot extends ItemType
case object Premium extends ItemType
case class MenuItem(name: String, itemType: ItemType, price: BigDecimal)
object BillCalculatorV2 {
  val validMenuItems = Map(
    "Cola" -> MenuItem("Cola", Drink, 0.50),
    "Coffee" -> MenuItem("Coffee", Drink, 1.00),
    "Cheese Sandwich" -> MenuItem("Cheese Sandwich", FoodCold, 2.00),
    "Steak Sandwich" -> MenuItem("Steak Sandwich", FoodHot, 4.50),
    "Lobster" -> MenuItem("Lobster", Premium, 25.00)
  )

  def calculateTotalWithoutServiceCharge(itemsOrdered: Seq[String]): BigDecimal = {
    itemsOrdered.flatMap(validMenuItems.get).map(_.price).sum
  }

  def calculateTotalBill(itemsOrdered: Seq[String]): BigDecimal = {
    val itemTotalCost = calculateTotalWithoutServiceCharge(itemsOrdered)
    val serviceCharge = calculateServiceCharge(itemsOrdered, itemTotalCost)
    (itemTotalCost + serviceCharge).setScale(2, BigDecimal.RoundingMode.HALF_UP)
  }

  def calculateServiceCharge(itemsOrdered: Seq[String], itemTotalCost: BigDecimal): BigDecimal = {
    val percentage = itemsOrdered.flatMap(validMenuItems.get).map(_.itemType match {
      case FoodCold => 0.10
      case FoodHot => 0.20
      case Premium => 0.25
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