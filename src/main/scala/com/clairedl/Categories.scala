package com.clairedl.scala

object Categories {
  // val categories: Map[String, List[Map[String, List[String]]]] = 
  //   ("bills", 
  //     ("council tax", ("Council tax","CC tax")),
  //     ("electricity",	("Good energy","Eon","Scottish power")),
  //     ("insurance",	("HSBC assurance")),
  //     ("internet", ("BT","Internet","Plusnet")),
  //     ("netflix",	("Netflix")),
  //     ("phone",	("Telephone","H3G\\s+DD")),
  //     ("rent", ("Loyer","Colonna\\s+Rent"))
  //   )

  val catSimple: Map[String, String] = 
    Map(
      ("council tax" -> "Council tax"),
      ("electricity" ->	"Scottish power")
    )
}