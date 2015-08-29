package db

import slick.driver.HsqldbDriver.api.tableQueryToTableQueryExtensionMethods
import slick.lifted.TableQuery

object Schema {
  def main(args: Array[String]): Unit = {
    val tables = Seq(TableQuery[ExpenseTable], TableQuery[TagTable], TableQuery[ExpenseWithTagTable])
    tables.map(_.schema.createStatements.foreach(println))
  }
}