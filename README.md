# AST-printer-for-Scala
get AST from compiler

It's a simple compiler plugin for Scala. Using this plugin, you could get AST from Scala Compiler.

You should import this project by IntelliJ IDEA.
And then input command as below to package source code to runnable jar file.

```
sbt package
```

Last step is run it.
Command as below.

```
scalac -Xplugin:[plugin name].jar [target file name]
```
Please remove "[" and "]".

* scala version is 2.10.6

