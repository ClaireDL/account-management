package com.clairedl.scala

import scala.io._
import _root_.scala.io.Source

trait TransactionLoader {
  def load(): List[Transaction]
}

class CsvTransactionLoader(val filePath: String, val header: Boolean) extends TransactionLoader {
  def load(): List[Transaction] = {
    header match {
      case true   => withHeader()
      case false  => noHeader()
    }
  }

  private def withHeader(): List[Transaction] = {
    Source
      .fromFile(filePath)
      .getLines()
      .drop(1)
      .map { line =>
        val split = line.split(",")
        Transaction(split(0), split(1), split(2).toDouble, split(3), split(4), split(5))
      }
    .toList
  }

    private def noHeader(): List[Transaction] = {
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
          TransactionFormatting.simplifyReference(split(1)),
          TransactionFormatting.stringToDouble(split(2)),
          "detailedCat",
          "category",
          "currentAccount")
      }
    .toList
  }

}
