package Fiddle

//https://riptutorial.com/scala/example/4874/using-sealed-trait-and-case-objects

sealed trait WeekDay1T { val name: String }
object WeekDay1 {

  case object Mon extends WeekDay1T {
    val name = "Monday"
  }

  case object Tue extends WeekDay1T {
    val name = "Tuesday"
  }

}

sealed case class WeekDay2(name: String) {

  object WeekDay2 {

    object Mon extends WeekDay2("Monday")

    object Tue extends WeekDay2("Tuesday")

  }

}

object SealedCase1 {

  def run ={

    println(WeekDay1.Mon.name)

    println(WeekDay2.apply("Monday")) // ???

    println(WeekDay2("Monday"))  ///???


  }
}
