package Fiddle.apptest

case class myCaseClass(name: String)

class myClass(name: String){
  val myName = name
}

class myParametricClass(val name: String)

class Cat {
  val dangerous = false
}
class Tiger(override val dangerous: Boolean, val age: Int) extends Cat

class Lion(val age: Int) extends Cat {
  override val dangerous: Boolean = true
}


object CaseClassVClass extends App {

  val c1 = myCaseClass("John")
  val c2 = new myClass("Dave")
  val c3 = new myParametricClass("Barry")

  println("c1 name = " + c1.name)
  println("c2 myName  = " + c2.myName)
  println("c3 name = " + c1.name)


  val cat = new Cat
  val tiger = new Tiger(true,10)
  val lion = new Lion(11)

  println("cat "+ cat.dangerous)
  println("tiger " + tiger.dangerous + " : " + tiger.age)
  println("lion " + lion.dangerous + " : " + lion.age)
  println("")
}
