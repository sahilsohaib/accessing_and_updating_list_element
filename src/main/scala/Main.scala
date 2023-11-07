object ListAccessUpdateProgram {
  def main(args: Array[String]): Unit = {
    var myList: List[Int] = List(1, 2, 3, 4, 5)

    while (true) {
      println("Options:")
      println("1. Access an element")
      println("2. Update an element")
      println("3. Show the list")
      println("4. Exit")
      print("Enter your choice (1/2/3/4): ")
      val choice = scala.io.StdIn.readLine()

      choice match {
        case "1" =>
          println("Enter the index to access:")
          val index = scala.io.StdIn.readInt()
          if (isValidIndex(index, myList)) {
            val element = myList(index)
            println(s"Element at index $index: $element")
          } else {
            println("Invalid index.")
          }

        case "2" =>
          println("Enter the index to update:")
          val index = scala.io.StdIn.readInt()
          if (isValidIndex(index, myList)) {
            println(s"Enter the new value:")
            val newValue = scala.io.StdIn.readInt()
            myList = updateElement(index, newValue, myList)
            println(s"Element at index $index updated to $newValue")
          } else {
            println("Invalid index.")
          }

        case "3" =>
          println("Current list elements:")
          myList.foreach(println)

        case "4" =>
          println("Exiting the program.")
          sys.exit(0)

        case _ =>
          println("Invalid choice. Please enter 1, 2, 3, or 4.")
      }
    }
  }

  def isValidIndex(index: Int, list: List[Int]): Boolean = {
    index >= 0 && index < list.length
  }

  def updateElement(index: Int, value: Int, list: List[Int]): List[Int] = {
    if (isValidIndex(index, list)) {
      val (prefix, suffix) = list.splitAt(index)
      prefix ++ (value :: suffix.tail)
    } else {
      list
    }
  }
}
