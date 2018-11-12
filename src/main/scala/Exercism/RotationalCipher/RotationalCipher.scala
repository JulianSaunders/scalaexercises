package Exercism.RotationalCipher

object RotationalCipher {

  val letters = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')

  def rotate(str: String, rot: Int): String = {
    val positions = str.toLowerCase map { letters.indexOf(_) }
    val rotatedPositions = positions map { p => (p + rot) % letters.length }
    val rotatedChars = rotatedPositions.zipWithIndex.map {
      case (p,i) if str(i).isUpper => letters(p).toUpper
      case (p,i) if str(i).isLower => letters(p).toLower
      case (p,i) => str(i)
    }

    rotatedChars.mkString
  }
}
