package ScalaClub

object BankOCR2 {

  def convertEntryToNumber(entry: String): String = {

    val lines = entry.split("\n")


    lines.map { e =>
      println(e)

      val convertedStr = extract(e, 1, 1,"","","","","","","","","")

    }


    ""
  }

  def extract(e: String, digit: Int, line: Int, ds1: String, ds2: String, ds3: String, ds4: String, ds5: String, ds6: String, ds7: String, ds8: String, ds9: String): String = {

    println("E=->"+e+"<-")

    val startPos = (digit * ((digit-1)*3))
    println("F0="+startPos)
    val digChunk = e.substring(startPos, startPos+3)

    println("F1="+startPos + "  ->"+digChunk+"<-")

    digit match {
      case 1 => ds1
    }
    ""
  }

  def extract2(e: String, digit: Int, endStr: String, line: Int): String = {

    println("E=->"+e+"<-")

    val startPos = (digit * ((digit-1)*3))
    println("F0="+startPos)
    val digChunk = e.substring(startPos, startPos+3)

    println("F1="+startPos + "  ->"+digChunk+"<-")


    val newStr = endStr.substring(1, startPos*line)
    println("F2="+digit * ((digit-1)*3)*line + "  ->"+ newStr)
    ""
  }
}
