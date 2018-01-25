package printer

import java.io.{PrintStream,PrintWriter}

trait OutputDesugar {

  def OutputDesugarFile(input:String):Unit={

    val rpw = new PrintWriter("AST-DESUGAR.txt")
    val rps = new PrintStream("AST-DESUGAR.txt")

    rps.print(input)

    rps.close()

  }

}
