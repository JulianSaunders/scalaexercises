package secondeditionodersky

abstract class Element {
  def contents: Array[String]

  def height = contents.length
  def width = if (height == 0) 0 else contents(0).length
}

class ArrayElement(val contents: Array[String]) extends Element

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}


object ElementExample extends App {

  val c1 = new LineElement("John")
  c1.contents

//
  println("c1.contents = " + c1.contents.mkString(","))
//  println("c2 myName  = " + c2.myName)
//  println("c3 name = " + c3.name)
//


}
