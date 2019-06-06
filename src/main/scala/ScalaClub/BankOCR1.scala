package ScalaClub

object BankOCR1 {

  def convertEntryToNumber(entry: String): String = {

    val lines = entry.split("\n")

    val num1 = lines(0).substring(0, 3) + lines(1).substring(0, 3) + lines(2).substring(0, 3)
    val num2 = lines(0).substring(3, 6) + lines(1).substring(3, 6) + lines(2).substring(3, 6)
    val num3 = lines(0).substring(6, 9) + lines(1).substring(6, 9) + lines(2).substring(6, 9)
    val num4 = lines(0).substring(9, 12) + lines(1).substring(9, 12) + lines(2).substring(9, 12)
    val num5 = lines(0).substring(12, 15) + lines(1).substring(12, 15) + lines(2).substring(12, 15)
    val num6 = lines(0).substring(15, 18) + lines(1).substring(15,18) + lines(2).substring(15,18)
    val num7 = lines(0).substring(18, 21) + lines(1).substring(18, 21) + lines(2).substring(18, 21)
    val num8 = lines(0).substring(21, 24) + lines(1).substring(21, 24) + lines(2).substring(21, 24)
    val num9 = lines(0).substring(24, 27) + lines(1).substring(24, 27) + lines(2).substring(24, 27)

    println(num1)
    println(num2)
    println(num3)
    println(num4)
    println(num5)
    println(num6)
    println(num7)
    println(num8)
    println(num9)


    val digits = List(num1,num2,num3,num4,num5,num6,num7,num8,num9)

    val endResult = digits.map{ d=>
      println("D=>"+d+"<")
      println(      convertEncToDigit(d))
      convertEncToDigit(d)
    }.mkString

    println("endResult="+endResult)
    endResult
  }

  def convertEncToDigit(enc:String):String =
    enc match {
      case " _ | ||_|" => "0"
      case "     |  |" => "1"
      case " _  _||_ " => "2"
      case " _  _| _|" => "3"
      case "   |_|  |" => "4"
      case " _ |_  _|" => "5"
      case " _ |_ |_|" => "6"
      case " _   |  |" => "7"
      case " _ |_||_|" => "8"
      case " _ |_| _|" => "9"
      case _@err => "ERROR >"+err+"<"
    }
}
