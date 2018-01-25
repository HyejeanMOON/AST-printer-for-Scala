package printer



trait ASTPrinter {

  private var showLine = true
  private var tabSize = 4

  def Run(input:String):Unit ={

    val result = input
    pprintAST(result)

  }

  def pprintAST(input: String) = {
    var level = 0
    input.foreach {
      case '(' =>
        level += 1
        println()
        if (showLine) {
          print(("|" + " "*(tabSize-1)) * (level-1))
          print("|" + "-"*(tabSize-1))
        } else {
          print(" " * tabSize * level)
        }
      case ')' =>
        level -= 1
      case ',' =>
        println()
        if (showLine) {
          print(("|" + " "*(tabSize-1)) * (level-1))
          print("|" + "-"*(tabSize-1))
        } else {
          print(" " * tabSize * level)
        }
      case ' ' =>
      case f => print(f)
    }
  }

}

