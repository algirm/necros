package id.northbit.necros.core.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).also { driver -> 
        AppDatabase.Schema.create(driver)
    }
}