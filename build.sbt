name := "algebra-sobre-scala3"

version := "0.1"

scalaVersion := "3.1.1"

scalacOptions ++= Seq("-feature")

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.0.0"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.2.11" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.15.4" % "test"

libraryDependencies += "com.lihaoyi" %% "sourcecode" % "0.2.8" // Scala-JVM