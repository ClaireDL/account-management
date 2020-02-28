package com.clairedl.scala

case class Transaction(
  date: String,
  reference: String,
  amount: Double,
  category: String,
  subCat: String,
  account: String
) {

  override def toString(): String = {
    s"$date, $reference, $amount, $category, $subCat, $account, "
  }
}
