package db

import slick.driver.HsqldbDriver.api.anyToToShapedValue
import slick.driver.HsqldbDriver.api.ForeignKeyAction
import slick.driver.HsqldbDriver.api._
import slick.driver.HsqldbDriver.api.Column
import slick.driver.HsqldbDriver.api.intColumnType
import slick.driver.HsqldbDriver.api.Table
import slick.lifted.Tag
import models.ExpenseWithTag

class ExpenseWithTagTable(tag: Tag) extends Table[ExpenseWithTag](tag, "expense_tag") {
  def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
  def expense = column[Int]("expense")
  def expenseTag = column[Int]("tag")
  def expenseKey = foreignKey("expense_with_tag_expense_fk", expense, ExpenseDAO.table)(_.id)
  def tagKey = foreignKey("expense_with_tag_tag_fk", expenseTag, TagDAO.table)(_.id)
  def * = (id, expense, expenseTag) <> (ExpenseWithTag.tupled, ExpenseWithTag.unapply)
}

object ExpenseWithTagDAO extends DAO {
  val table = TableQuery[ExpenseWithTagTable]

}