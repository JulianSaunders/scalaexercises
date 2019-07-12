package adt

abstract class Item(val name: String, val price: BigDecimal)

trait SquishyFruit {
  val squishy: Boolean = true
}

trait HardFruit {
  val squishy: Boolean = false
}

case object Apple extends Item("Apple", 0.20) with SquishyFruit


abstract class Item2(val name: String, val price: BigDecimal)
abstract class Fruit2(val squishy: Boolean)


case object Apple2 extends Item2("Apple", 0.20) with HardFruit
case object Banana extends Item2("Banana", 0.10) with SquishyFruit


object AdtExamples extends App {

  println("" + Apple.name)
  println("" + Apple.price)
  println("" + Apple.squishy)


  println("" + Apple2.name)
  println("" + Apple2.price)
  println("" + Apple2.squishy)

  println("" + Banana.name)
  println("" + Banana.price)
  println("" + Banana.squishy)

}
