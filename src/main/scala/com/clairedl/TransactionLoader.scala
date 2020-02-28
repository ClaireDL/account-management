package com.clairedl.scala

import scala.io._
import _root_.scala.io.Source

trait TransactionLoader {
  def load(): List[Transaction]
}


/**
* Temporary version with known input
*/
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
        
        val reference = TransactionConverter.simplifyReference(split(1))

        val category: String = 
          split.length match {
            case 3 => "?"
            case _ => split(4)
          }

        val detailedCat: String = 
          split.length match {
            case 3 => TransactionConverter.matchCategory(reference)
            case _ => split(3)
          }
        
        val currentAccount: String =
          split.length match {
            case 3 | 5 => "?"
            case _ => split(5)
          }

        Transaction(
          split(0),
          reference,
          TransactionConverter.stringToDouble(split(2)),
          category,
          detailedCat,
          currentAccount
        )
      }
    .toList
  }
}
