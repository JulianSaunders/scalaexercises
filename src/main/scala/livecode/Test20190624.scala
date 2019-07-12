package livecode

// live code interview
// implement a List take function

object Test20190624 extends App {

  val p1 = List("Kim")
  val p2 = "Julia" :: p1

  println("\n----------\n")

  val testList = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val resultList = afunc(testList, 4)
  println("resultList=" + resultList)

  val testListS = List("1", "2", "3", "4", "5", "6", "7", "8", "9")
  val resultListS = afunc(testList, 4)
  println("resultListS=" + resultListS)

  def afunc[A](aList: List[A], n: Int): List[A] = {
    def recFunc(aList: List[A], n: Int, newList: List[A], idx: Int): List[A] = {

      println(s"recf n=$n idx=$idx head=${aList.head}")

      if (idx == n) {
        newList
      } else {
        val nnlist = aList.head :: newList
        recFunc(aList.tail, n, aList.head :: newList, idx + 1)
      }
    }

    if (n >= aList.size) {
      aList
    }
    else {
      recFunc(aList, n, List(), 0)
    }
  }


  println("\n----------\n")
}
