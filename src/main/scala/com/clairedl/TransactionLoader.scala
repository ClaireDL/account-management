package com.clairedl.scala

import scala.io._
import _root_.scala.io.Source

trait TransactionLoader {
  def load(): List[Transaction]
}

class CsvTransactionLoader(filePath: String, header: Boolean) extends TransactionLoader {
  def load(): List[Transaction] = {
    header match {
      case true   => splitCsv().drop(1)
      case false  => splitCsv()
    }
  }

  private def splitCsv(): List[Transaction] = {
    Source
      .fromFile(filePath)
      .getLines()
      .map { line =>
        val split = line.split(",")
        Transaction(split(0), split(1), split(2).toDouble, split(3), split(4), split(5))
      }
    .toList
  }
}

class CurrentAccountTransactionLoader extends TransactionLoader {
  def load(): List[Transaction] = {
    Source
      .fromFile("CurrentAccount.csv")
      .getLines()
      .map { line =>
        val split = line.split(",")
        Transaction(
          split(0),
          TransactionConverter.simplifyReference(split(1)),
          TransactionConverter.stringToDouble(split(2)),
          "detailedCat",
          TransactionConverter.matchCategory(split(4)),
          "currentAccount")
      }
    .toList
  }

}
