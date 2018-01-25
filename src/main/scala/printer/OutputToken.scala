package printer

import java.io.{PrintStream,PrintWriter}

trait OutputToken {

  def OutputTokenFile(input:String):Unit= {

    val rpw = new PrintWriter("AST-TOKEN.txt")
    val rps = new PrintStream("AST-TOKEN.txt")

    rps.print(input)

    rps.close()

  }

}
