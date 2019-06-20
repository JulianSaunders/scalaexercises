package Fiddle

import scala.annotation.tailrec

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object BinaryGap {

  def run() = {
    //for (a <- 1 to 1000){
    //  println(Solution.solution(a) + "\r\n")
    //}

    BinaryGap.solution(74901729)

  }


  def solution(n: Int): Int = {
    // write your code in Scala 2.12

    val b = n.toBinaryString
    println("binary="+b)

    recf(b, b.length, 0,0,0)

  }

  @tailrec
  def recf(origB: String, leng: Int, posi: Int, maxGap: Int, currentGap: Int): Int = {
    if (posi == leng) {
      maxGap
    } else {
      if (origB(posi) == '1') {
        println(s"1--- $origB : $leng : $posi : $maxGap : $currentGap :  ${currentGap max maxGap}")
        recf(origB, leng, posi + 1, currentGap max maxGap, 0)
      }else{
        println(s"0--- $origB : $leng : $posi : $maxGap : $currentGap :  ${currentGap max maxGap}")
        recf(origB, leng, posi + 1, maxGap, currentGap + 1)
      }
    }
  }
}