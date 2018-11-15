package Fiddle

object ListFindGet {

  case class MenuItem(itemName : String, value: BigDecimal, warmingCategory: String, menuItemCategory: String)
  object Menu {
    lazy val menuItems: List[MenuItem] =
      List(MenuItem("Cola", 0.5, "cold", "drink"),
        MenuItem("Coffee", 1, "hot", "drink"),
        MenuItem("Cheese Sandwich", 2, "cold", "food"),
        MenuItem("Steak Sandwich", 4.5, "hot", "food"))
  }

  def run = {

    val menuItems: List[String] = List("Cola", "Coffee")
    println(menuItems.map(mi => Menu.menuItems.find(_.itemName == mi)))

    println(menuItems.map(mi => Menu.menuItems.find(_.itemName == mi).get))

  }
}
