package com.clairedl.scala

object Main extends App {
  // val loaderTest = new CurrentAccountTransactionLoader
  val loaderTest = new CsvTransactionLoader("test.csv", false)
  val loadedTest = loaderTest.load()
  println(loadedTest.mkString("\n"))
}
