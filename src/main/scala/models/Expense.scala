package models

import org.joda.time.LocalDate

import spray.json.DefaultJsonProtocol
import spray.json.JsString
import spray.json.JsValue
import spray.json.RootJsonFormat

case class Expense(id: Int, amount: Double, date: LocalDate, description: String)

object ExpenseCompanion extends DefaultJsonProtocol {
  implicit def toJson = jsonFormat4(Expense.apply)

  implicit val jodaLocalDateFormat = new RootJsonFormat[LocalDate] {
    def write(value: LocalDate) = JsString(value.toString)
    def read(value: JsValue): LocalDate = value match {
      case JsString(s) =>
        try LocalDate.parse(s)
        catch {
          case e: Throwable => throw new RuntimeException("Couldn't convert '" + s + "' to a local date: " + e.getMessage)
        }
      case s => throw new RuntimeException("Couldn't convert '" + s + "' to a local date")
    }
  }

}