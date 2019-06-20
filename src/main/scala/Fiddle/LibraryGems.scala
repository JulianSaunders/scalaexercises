package Fiddle

object LibraryGems {

  def run: Unit ={

    val xs = Seq(1,0, 4, 5, 2, -1, -3, 4, 1,-9)
    println("xs:"+xs)

    /*******/
    println("********************************************")
    val even = xs.filter(_ % 2 == 0)
    val odd = xs.filterNot(_ % 2 == 0)
    val (even2, odd2) = xs.partition(_ % 2 == 0)
    println("even:"+even2+"   odd:"+odd2)


    /*******/
    println("********************************************")


    val minByAbs = xs.sortBy(Math.abs).head

    val minByAbs2 = xs.minBy(Math.abs)
    println("minByAbs2:"+minByAbs2)


    val m = xs.sortBy(Math.abs)
    println("m:"+m)
    /*******/
    println("********************************************")

    val doublesOfPositive = xs.filter(_ > 0).map(2 * _)

    val doublesOfPositive2 = xs.collect {
      case x if x > 0 =>
        2 * x
    }

    println("doublesOfPositive2:"+doublesOfPositive2)

    /*******/
    println("********************************************")

    val xsNeg = Seq(-2,-1)

    val collectFirstNone = xsNeg.collectFirst {
      case x if x > 0 =>
        2 * x
    }

    println("collectFirstNone:"+collectFirstNone)

    /*******/
    println("********************************************")
    val leftHalf = xs.take(3)
    val rightHalf = xs.drop(3)

    val (leftHalf2, rightHalf2) = xs.splitAt(3)
    println("leftHalf2:"+leftHalf2+"   rightHalf2:"+rightHalf2)


    /*******/
    println("********************************************")
    val fmtstr = "42".splitAt(1)
    val sumint = fmtstr._1.toInt + fmtstr._2.toInt
    println("sumint:"+sumint)

    /*******/
    println("********************************************")

    val grped = xs.grouped(3).toList
    println("grped:"+grped)
    /*******/
    println("********************************************")

    val evenCount = xs.filter(_ % 2 == 0).size
    val evenCount2 = xs.count(_ % 2 == 0)

    println("evenCount2:"+evenCount2)


    /*******/
    println("********************************************")
    println("last:"+xs.last)

    /*******/
    println("********************************************")

      //.sliding and .groupBy
    /*******/
    println("********************************************")

    /*******/
    println("********************************************")

    /*******/
    println("********************************************")
  }


}
