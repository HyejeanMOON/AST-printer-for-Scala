package printer


import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}


class ASTPrinterPlugin(val global: Global) extends Plugin with ASTPrinter with OutputDesugar with OutputToken{

  import global._

  val name = "AST_Printer"
  val description = "Generate a Abstract Syntax Tree"
  val components = List[PluginComponent](Component)

  object Component extends PluginComponent {
    val global: ASTPrinterPlugin.this.global.type = ASTPrinterPlugin.this.global

    val runsAfter: List[String] = List("refchecks")
    val phaseName = "AST_Printer_phase"
    val description = ASTPrinterPlugin.this.description

    def newPhase(prev: Phase) = new ASTPrinterPhase(prev)

    class ASTPrinterPhase(prev: Phase) extends StdPhase(prev) {
      override def name = ASTPrinterPlugin.this.name

      def apply(unit: CompilationUnit): Unit = {
        assert(assertion = false)
      }

      var ast:String = ""

      override def run = {
        println("")
        println("           AST (desugar style)")
        println("----------------------------------------")
        println("           AST (Token Style)")
        println("---------------------------------------")
        println("")
        
        var trees = Set[Tree]()
        trees ++= global.currentRun.units.map(_.body)

        for(t <- trees){
          ast = ast + showRaw(t)
          println(ast)
          print(showRaw(t))
        }

        println("")
        println("---------------------------------------")
        println("")
        println("           AST (Token style)")
        println("---------------------------------------")
        println("")
        print(showRaw(trees))
        println("")
        println("----------------------------------------")
        println("")
        println("           AST Visualization")
        println("---------------------------------------")
        Run(ast)
        println("")
        println("---------------------------------------")
        println("")
        println("Output File...")

        OutputTokenFile(ast)
        OutputDesugarFile(showRaw(trees))

      }
    }

  }

}
