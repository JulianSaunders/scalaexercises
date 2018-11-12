package Fiddle

object OptionMap {

  def run() = {

    case class User(
                     id: Int,
                     firstName: String,
                     lastName: String,
                     age: Int,
                     gender: Option[String])

    object UserRepository {
      private val users = Map(
        1 -> User(1, "John", "Doe", 32, Some("male")),
        2 -> User(2, "Johanna", "Doe", 30, None),
        3 -> User(3, "Dave", "Doe", 36, None),
        4 -> User(4, "Anne", "Doe", 40, Some("female"))
      )

      def findById(id: Int): Option[User] = users.get(id)

      def findAll = users.values
    }

    UserRepository.findById(2).foreach(user => println(user.firstName)) // prints "Johanna"

    val age = UserRepository.findById(1).map(_.age) // age is Some(32)
    println(age)


    val gender1 = UserRepository.findById(1).map(_.gender) // gender is an Option[Option[String]]
    println(gender1)

    val gender2 = UserRepository.findById(1).flatMap(_.gender) // gender is an Option[Option[String]]
    println(gender2)


    val genderNO1 = UserRepository.findById(10).map(_.gender) // gender is an Option[Option[String]]
    println(genderNO1)

    val genderNO2 = UserRepository.findById(10).flatMap(_.gender) // gender is an Option[Option[String]]
    println(genderNO2)

    println("\n---b")
    println(UserRepository.findById(1).filter(_.age > 30)) // Some(user), because age is > 30
    println(UserRepository.findById(2).filter(_.age > 30)) // None, because age is <= 30
    println(UserRepository.findById(3).filter(_.age > 30)) // None, because user is already None

    println("\n---c   FOR")
    for {
      user <- UserRepository.findById(1)
      gender <- user.gender
    } yield {
      // results in Some("male")
      println("c in yield")
      println(gender)
      println(Some(gender))
    }

    println("\n---c2")
    for {
      userc2 <- UserRepository.findById(2)
      genderc2 <- userc2.gender
    } yield {
      // results in None
      println("c2 in yield")
      println(genderc2)
    }

    println("\n---c3 findALL")
    for {
      userc3 <- UserRepository.findAll
      genderc3 <- userc3.gender
    } yield {
      println("c3 in yield")
      println(genderc3)
    }

    println("\n---c4 findALL assign to val")
    val c4All = for {
      userc3 <- UserRepository.findAll
      genderc3 <- userc3.gender
    } yield {
      println("c3 in yield")
      println(genderc3)
      genderc3
    }
    println("c4all = " + c4All)

    println("\n---c5 findALL assign to val using a pattern")
    val c5All = for {
      User(_,fname,_,age,_) <- UserRepository.findAll
      if age == 36
    } yield {
      println("c5 in yield")
      println(fname)
      fname
    }
    println("c5all = " + c5All)

  }
}
