package RestaurantBilling.flexCart

import scala.collection.mutable.ListBuffer

object FlexCart {
  case class Item(price: BigDecimal)
  val menu = Map(
    "item1" -> Item(.50),
    "item2" -> Item(99.99)
  )

  // https://alvinalexander.com/scala/how-to-create-mutable-list-in-scala-listbuffer-cookbook
  // http://allaboutscala.com/tutorials/chapter-7-beginner-tutorial-using-scala-mutable-collection/scala-tutorial-learn-use-mutable-listbuffer/
  var basket = new ListBuffer[String]()


  def addToBasket(item: String): Unit ={
    basket += item
  }

  def removeFromBasket(idOfItem: Int) : Unit ={
  }

  def returnBasket(): String ={
    basket.toList.mkString(",")
  }
}