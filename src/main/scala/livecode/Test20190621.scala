package livecode
import scala.collection.immutable.ListMap


// live code interview
// mary has bag of sweets List(1,2,3,3,4,4) she gives exactly half to her brother
// always even number, infinite type of sweets, 2 to 100,000 sweets in bag
// calculate the maximum number of unique sweets she has remaining

object Test20190621{
  def calcBroSweets(bagOfSweets: Vector[Int]): Int = {
    println("\n----------\n")

    val grpby1 = bagOfSweets.groupBy(identity)
    println("grpby1=" + grpby1)

    val grpvals = grpby1.mapValues(_.size)
    println("grpvals=" + grpvals)

    val lmap = ListMap(grpvals.toSeq.sortBy(_._1):_*)
    println(("lmap="+lmap))

    val totalInBag = bagOfSweets.size
    val totalToGiveBrother = totalInBag / 2
    val totalUniqueSweets = grpvals.size

    val result = if (totalUniqueSweets <= totalToGiveBrother) {
      totalUniqueSweets
    } else {
      totalToGiveBrother
    }


    println("RESULT=" + result)
    println("\n----------\n")
    result
  }
}
