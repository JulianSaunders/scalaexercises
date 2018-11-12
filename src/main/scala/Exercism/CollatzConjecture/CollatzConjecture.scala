package Exercism.CollatzConjecture

object CollatzConjecture {
  def steps(value: Int, count: Int = 0): Option[Int] = {
    value match {
      case v if v < 1 => None
      case 1 => Some(count)
      case v => if ((v % 2) == 0) steps(v / 2, count + 1) else steps((v * 3) + 1, count + 1)
    }
  }
}