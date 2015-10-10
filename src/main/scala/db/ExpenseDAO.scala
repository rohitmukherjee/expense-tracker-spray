package db

import org.joda.time.LocalDate
import com.github.tototoshi.slick.HsqldbJodaSupport.localDateTypeMapper
import models.Expense
import slick.driver.HsqldbDriver.api.anyToToShapedValue
import slick.driver.HsqldbDriver.api.Column
import slick.driver.HsqldbDriver.api.doubleColumnType
import slick.driver.HsqldbDriver.api.intColumnType
import slick.driver.HsqldbDriver.api.stringColumnType
import slick.driver.HsqldbDriver.api.Table
import slick.lifted.Tag
import slick.lifted.TableQuery

class ExpenseTable(tag: Tag) extends Table[Expense](tag, "expense") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def amount = column[Double]("amount")
  def date = column[LocalDate]("date")
  def description = column[String]("description", O.Default("miscellaneous"))
  def * = (id, amount, date, description) <> (Expense.tupled, Expense.unapply)
}

object ExpenseDAO extends DAO {
  val table = TableQuery[ExpenseTable]


}
