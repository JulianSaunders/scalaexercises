package Fiddle

object ExistsOnList {

  def run={
    val ss = "00000000010000000000"

    val z = ss.zipWithIndex.toSet

    println(z)

    // val res = z match {
    //   case (1,9) => true
    //   case _ => false
    // }


//    response.controlListInformation.zipWithIndex.toSet.contains((CONTROL_LIST_TRUE,CONTROL_LIST_GROUP_ENTITY_POSITION))

    val res = z.contains('1',9)

     println(res)

//    val res2 = z.contains{case (a:Char, b: Int)=>(a=='1' && b==9)}
//    println("res2=" + res2)

    val x = List(("1","A"),("2","B"))
    val c = x.exists(_._2 == "C")
    val d = x.exists(a => a == "B")

    println(c)
    println(d)


    val g = List(("1"),("2"))
    val h = g.exists(a => a=="1")
    println(h)

    val i = g.exists(a => {println("a="+a);a=="2"})
  }

}
