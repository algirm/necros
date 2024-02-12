package id.northbit.necros

import id.northbit.necros.core.database.DatabaseDriverFactory
import id.northbit.necros.core.database.data.AppDatabase
import org.koin.dsl.module

val androidAppModule = module { 
    single { AppDatabase(DatabaseDriverFactory(get()).createDriver()) }
}