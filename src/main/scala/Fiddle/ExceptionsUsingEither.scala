package Fiddle

import scala.util.Try

case class FailureReason(msg: String)

object ExceptionsUsingEither {

  //By convention failure values are left in Either
  def divide(a: Int, b: Int): Either[FailureReason, Int] =
  //Try(a / b).toEither
    try {
      Right(a / b)
    } catch {
      case _ => Left(FailureReason("Cannot divide by zero"))
    }

  def run: Unit =
    divide(5, 0).fold(
      error => println("failed"),
      success => println(s"$success")
    )
}
