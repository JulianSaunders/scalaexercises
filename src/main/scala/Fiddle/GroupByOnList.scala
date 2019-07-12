package Fiddle

object GroupByOnList extends App {
  val items = List("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich", "Tree", "Cola", "Tree")

  println("------")

  val grpBy = items.groupBy(identity)

  println("grpBy=" + grpBy)

  val gValues = grpBy.mapValues(a=>a.size)

  println("gValues=" + gValues)


  val gValues2 = grpBy.mapValues(a=>a.collect{case b if b.contains("Sandwich")=>b}.size)

  println("gValues2=" + gValues2)

  println("------")


}