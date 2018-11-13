package Fiddle

import scala.collection.mutable
import scala.collection.mutable.{HashMap, MultiMap, Set}

object CollectCase {

  def run() = {
    trait OrderedMultimap[A, B] extends MultiMap[A, B] {
      override def makeSet: Set[B] = new mutable.LinkedHashSet[B]
    }

    sealed trait gameObjectT {
      val optionVal: String
      val description: String
    }

    case class Weapon(optionVal: String, description: String) extends gameObjectT {}
    case class OtherObject(optionVal: String, description: String) extends gameObjectT {}
    case class Person(optionVal: String, description: String) extends gameObjectT {}
    case class Animal(optionVal: String, description: String) extends gameObjectT {}

    val allLocationObject = new HashMap[String, Set[gameObjectT]] with OrderedMultimap[String, gameObjectT]
    allLocationObject.addBinding("aa", OtherObject("1", "Crisp packet"))
    allLocationObject.addBinding("aa", Weapon("2", "Tree branch"))
    allLocationObject.addBinding("aa", Animal("3", "Horse"))
    allLocationObject.addBinding("aa", Person("4", "Police person on horseback"))

    val objs: Option[Set[gameObjectT]] = allLocationObject.get("aa")

    objs.foreach { objects =>
      println("objects=" + objects)

      for {
        obj <- objects
      }
        yield {
          println(obj)
        }
    }

    objs.foreach { objects =>
      println("objects=" + objects)

      println("********************")
      println(objects.collect({ case o: gameObjectT if o.description.equals("Horse") => o }))
      println(objects.collect { case o@(_: Weapon | _: OtherObject) => o }.size)
    }
  }
}
