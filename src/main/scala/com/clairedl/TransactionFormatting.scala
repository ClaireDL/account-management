package com.clairedl.scala

import scala.util.matching.Regex
import org.json4s._

object TransactionFormatting {
  def stringToDouble(s: String): Double = {
    val string = s.replace("\"", "")
    val comma = new Regex(",")
    // val formattedAmount = comma replaceAllIn(s, "")
    // formattedAmount.toDouble
    (comma replaceAllIn(string, "")).toDouble
  }

  def simplifyReference(s: String): String = {
    val extraSpace = new Regex("\\s+")
    val noExtraSpace = extraSpace replaceAllIn(s, " ")
    val closingBracket = new Regex("\\)+")
    (closingBracket replaceAllIn(noExtraSpace, ""))
  }
}
