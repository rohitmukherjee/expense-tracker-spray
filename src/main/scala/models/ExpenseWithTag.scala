package models

import spray.json.DefaultJsonProtocol

case class ExpenseWithTag(id: Int, expense: Int, tag: Int)

object ExpenseWithTagCompanion extends DefaultJsonProtocol {
  implicit def toJson = jsonFormat3(ExpenseWithTag.apply)
}
