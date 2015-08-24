package db

import slick.driver.HsqldbDriver.api.anyToToShapedValue
import slick.driver.HsqldbDriver.api.Column
import slick.driver.HsqldbDriver.api.intColumnType
import slick.driver.HsqldbDriver.api.Table
import slick.lifted.ProvenShape.proveShapeOf
import slick.lifted.Tag
import models.ExpenseWithTag

class ExpenseWithTagTable(tag: Tag) extends Table[ExpenseWithTag](tag, "expense_tag") {
  def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
  def expense = column[Int]("expense")
  def expenseTag = column[Int]("tag")
  def * = (id, expense, expenseTag) <> (ExpenseWithTag.tupled, ExpenseWithTag.unapply)
}