package Fiddle.apptest


object MyApp {
  def main( args: Array[String]){
    println("Hello World! ")
    args.foreach(str => println(s"arg is $str"))
  }
}