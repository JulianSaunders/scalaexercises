package Exercism.FlattenArray

object FlattenArray {
  def flatten(listIn:List[Any]):List[Any] = {
    listIn.flatMap( {
      case i: Int => List(i)
      case l2: List[Any] => flatten(l2)
      case _ => Nil
    })
  }
}
