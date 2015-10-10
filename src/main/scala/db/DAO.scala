package db

import slick.driver.HsqldbDriver.api._
import com.typesafe.config.ConfigFactory
import Database._
import slick.lifted.TableQuery
import com.typesafe.config.Config
import com.mchange.v2.c3p0.ComboPooledDataSource

abstract class DAO {
  private val config = ConfigFactory.load
  private val driver = config.getString("db.driver")
  private val user = config.getString("db.user")
  private val password = config.getString("db.password")
  private val dbUrl = config.getString("db.url")
  private val minimumPoolSize = config.getInt("db.connectionPool.minimumPoolSize")
  private val maximumPoolSize = config.getInt("db.connectionPool.maximumPoolSize")
  private val increment = config.getInt("db.connectionPool.increment")

  val databae = {
    val dataSource = new ComboPooledDataSource
    dataSource.setDriverClass(driver)
    dataSource.setJdbcUrl(dbUrl)
    dataSource.setUser(user)
    dataSource.setPassword(password)
    dataSource.setMinPoolSize(minimumPoolSize)
    dataSource.setMaxPoolSize(maximumPoolSize)
    dataSource.setAcquireIncrement(increment)
    dataSource.setMinPoolSize(minimumPoolSize)
    dataSource
  }

}