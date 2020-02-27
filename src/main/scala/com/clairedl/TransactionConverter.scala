package com.clairedl.scala

import scala.util.matching.Regex

object TransactionConverter {

  def stringToDouble(s: String): Double = {
    val string = s.replace("\"", "")
    val separator = new Regex(",")
    // val formattedAmount = separator.replaceAllIn(s, "")
    // formattedAmount.toDouble
    separator.replaceAllIn(string, "").toDouble
  }

  /**
  * Removes unnecessary characters in a string
  * (e.g. consecutive spaces)
  */
  def simplifyReference(s: String): String = {
    val extraSpace = new Regex("\\s+")
    var simplified = extraSpace.replaceAllIn(s, " ")
    val closingBracket = new Regex("\\)+")
    closingBracket.replaceAllIn(simplified, "")
  }

  /**
  * Returns the main category the reference belongs to
  * if it is found in the list of categories and subcategories
  */
  def matchCategory(s: String): Option[(String, String)] = {
    val category = 
      Matches.catSimple.get(
        { case (key, value) => value == s}
      )
    def matchedCategory: String = category match {
      case Some(value) => value
      case None => "?"
    }

    matchedCategory
  }
}
