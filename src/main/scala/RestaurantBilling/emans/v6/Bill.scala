package RestaurantBilling.emans.v6

import scala.math.BigDecimal.RoundingMode

object Bill {
  def calcBill(order: List[String]): BigDecimal = {
    val menu = Map(
      "Cola" -> Item(Drinks, .50),
      "Coffee" -> Item(Drinks, 1),
      "Cheese Sandwich" -> Item(Coldfood, 2),
      "Steak Sandwich" -> Item(Hotfood, 4.50),
      "Lobster" -> Item(Premium, 25)
    )

    val items = order map menu
    val amount = items.foldLeft(BigDecimal(0))(_ + _.price)
    val tips = items.map(item => item.typ match { // < item => item.typ could be _.typ
      case Premium => (amount * 0.25).min(40)
      case Hotfood => (amount * 0.2).min(20)
      case Coldfood => amount * 0.1
      case _ => 0: BigDecimal
    }).max // << will go through entire list twice, but its very readable which is more important. exists could be faster if list contains 1 million items and premium, hot,cold is near the start

    (amount + tips).setScale(2, RoundingMode.HALF_EVEN)
  }


  sealed trait Type
  case class Item(typ: Type, price: BigDecimal)
  case object Coldfood extends Type
  case object Hotfood extends Type
  case object Drinks extends Type
  case object Premium extends Type
}