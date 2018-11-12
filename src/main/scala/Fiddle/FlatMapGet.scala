package Fiddle

object FlatMapGet {
  def run() = {
    val items = List("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich", "Tree")

    val menu = Map(
      "Cola" -> (BigDecimal(0.50), false, false),
      "Coffee" -> (BigDecimal(1.00), false, true),
      "Cheese Sandwich" -> (BigDecimal(2.00), true, false),
      "Steak Sandwich" -> (BigDecimal(4.50), true, true)
    )


    val itemsInMenu = items.flatMap(menu.get)


    println("\n1:"+items.flatMap(i => i))
    println("\n2:"+items.flatMap(menu.get))
    println("\n3:"+items.map(menu.get))

    println("\n4:")
    println(menu.get(_))
    println("\n5:"+menu.get("Cola"))
  }
}