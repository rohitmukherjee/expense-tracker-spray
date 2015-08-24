package models

import org.joda.time.LocalDate

case class Expense(id: Int, amount: Double, date: LocalDate, description: String)
