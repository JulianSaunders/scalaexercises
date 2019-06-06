package Fiddle

import java.io.{File, IOException}

import scala.util.Try

object BasicTryValueDemo  {

  def filePath(path: String): Try[File] =
  // creating an File object with null throws NullPointerException which is an unchecked exception
  //Try[A] always returns either Success[A] or Failure[A]
    Try(new File(path))

  def run(): Unit = {

    //using a getOrElse to provide a safe value if function returns Failure[File]
    val file = filePath(null).getOrElse(new File("/"))
    println(file.toString)

    //assert failure
    assert(filePath(null).isFailure)

  }

}
