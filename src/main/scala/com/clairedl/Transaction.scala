package com.clairedl.scala

case class Transaction(
  date: String,
  reference: String,
  amount: Double,
  detailedCat: String,
  category: String,
  account: String
) {

  override def toString(): String = {
    s"$date, $account, $reference, $amount, $category, $detailedCat"
  }
}
