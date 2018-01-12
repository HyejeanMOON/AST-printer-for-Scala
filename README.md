# AST-printer-for-Scala
get AST from compiler

It's a simple compiler plugin for Scala. Using this plugin, you could get AST from Scala Compiler.

You should import this project by IntelliJ IDEA.
And then input command as below to package source code to Runnable Jar File.

```
sbt package
```

Last step is run it.
Command as below.

```
scalac -Xplugin:[plugin name].jar [target file name]
```
Please remove "[" and "]".

* scala version of plugin is 2.10.6


For example about result:

```

           AST (Token style)
---------------------------------------

PackageDef(Select(Select(Select(Ident(MOON), MOON.OCEAN), scala), MOON.OCEAN.scala.util), List(ClassDef(Modifiers(MODULE), newTypeName("Timer"), List(), Template(List(Select(Ident(scala), newTypeName("AnyRef"))), emptyValDef, List(DefDef(Modifiers(), nme.CONSTRUCTOR, List(), List(List()), TypeTree(), Block(List(Apply(Select(Super(This(newTypeName("Timer")), tpnme.EMPTY), nme.CONSTRUCTOR), List())), Literal(Constant(())))), DefDef(Modifiers(), newTermName("Hello"), List(), List(), TypeTree().setOriginal(Select(Ident(scala), scala.Unit)), Apply(Select(Select(This(newTypeName("scala")), scala.Predef), newTermName("print")), List(Literal(Constant("hello"))))), DefDef(Modifiers(), newTermName("World"), List(), List(), TypeTree().setOriginal(Select(Ident(scala), scala.Unit)), Block(List(Select(This(newTypeName("Timer")), newTermName("Hello"))), Apply(Select(Select(This(newTypeName("scala")), scala.Predef), newTermName("print")), List(Literal(Constant(" world")))))))))))
---------------------------------------

           AST (Desugar style)
---------------------------------------

Set(package MOON.OCEAN.scala.util {
  object Timer extends scala.AnyRef {
    def <init>(): MOON.OCEAN.scala.util.Timer.type = {
      Timer.super.<init>();
      ()
    };
    def Hello: Unit = scala.this.Predef.print("hello");
    def World: Unit = {
      Timer.this.Hello;
      scala.this.Predef.print(" world")
    }
  }
})
----------------------------------------

```
