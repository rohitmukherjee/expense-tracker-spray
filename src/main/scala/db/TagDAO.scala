package db

import models.{ Tag => ExpenseTag }
import slick.driver.HsqldbDriver.api.anyToToShapedValue
import slick.driver.HsqldbDriver.api.Column
import slick.driver.HsqldbDriver.api.intColumnType
import slick.driver.HsqldbDriver.api.stringColumnType
import slick.driver.HsqldbDriver.api.Table
import slick.lifted.Tag
import slick.lifted.TableQuery

class TagTable(tag: Tag) extends Table[ExpenseTag](tag, "tag") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def * = (id, name) <> (ExpenseTag.tupled, ExpenseTag.unapply)
}

object TagDAO {
  val table = TableQuery[TagTable]
}