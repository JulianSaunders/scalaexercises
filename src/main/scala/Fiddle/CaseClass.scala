package Fiddle

object CaseClass {

  abstract case class class1 private[class1](str1: String, optStr2: Option[String])
//   abstract case class class1 (str1: String, optStr2: Option[String])

  object class1{
    def apply(str1: String, optStr2: Option[String]):class1 = {
      new class1(str1.toUpperCase, optStr2.map(a=>a.toUpperCase)){}
    }
  }
  def run = {
    val a = class1("lower", Some("lower"))
    println(a)

//    val b = new class1("lower", Some("lower")){} // this won't work unless you remove private[class1]
//    println(b)

  }
}
