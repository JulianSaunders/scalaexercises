package Fiddle

import java.io.File

import scala.util.Try

object RecoverDemo{

  def filePath(path: String): Try[File] =
  //Creating new File with null results in NullPointerException which is an unchecked exception
  //Try[A] always returns either Success[A] or Failure[A]
    Try(new File(path))

  def run(): Unit = {
    val filePaths = List("/", "/home", "/tmp", null)
    val fileObjs =
      filePaths
        //Create List[Try[File]]
        .map(filePath)
        //Iterate over List[Try[File]]
        .map(_.recover({
        //recover for each Failure[File]
        case e: NullPointerException => filePath("/").get
      }))
    println(fileObjs)
  }
}