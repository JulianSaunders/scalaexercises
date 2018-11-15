package Fiddle

object ReduceExample {

  def runReduce = {

    val nums = List(10, 20, 30, 15)

    val total = nums.reduce((a, b) => {
      println("a=" + a + "  b=" + b);
      a + b
    })

    println("total="+total)
  }

  def runReduceLeft = {

    val nums = List(10, 20, 30, 15)

    val total = nums.reduceLeft((a, b) => {
      println("a=" + a + "  b=" + b);
      a + b
    })

    println("total="+total)
  }

  def runReduceRight = {

    val nums = List(10, 20, 30, 15)

    val total = nums.reduceRight((a, b) => {
      println("a=" + a + "  b=" + b);
      a + b
    })

    println("total="+total)
  }
}
