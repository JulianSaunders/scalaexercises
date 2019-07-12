package Fiddle


case class myCaseClass1(name: String)

//case class myCaseClass2() extends myCaseClass1("jbs")  <<< does not work


object CaseClass2 extends App {

  val c1 = myCaseClass1("john")
//  val c2 = myCaseClass2

  println("c1 name = " + c1.name)
//  println("c2  = " + c2)

}
