package com.clairedl.scala

case class Transaction(
  date: String,
  reference: String,
  amount: Double,
  subCat: String,
  category: String,
  account: String
) {

  override def toString(): String = {
    s"$date, $reference, $amount, $category, $subCat, $account, "
  }
}
