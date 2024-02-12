package id.northbit.necros.core.data

import id.northbit.necros.core.data.wallet.WalletRepository
import id.northbit.necros.core.data.wallet.WalletRepositoryImpl
import id.northbit.necros.core.database.DatabaseDriverFactory
import id.northbit.necros.core.database.data.AppDatabase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

//actual class DataModule(private val db: AppDatabase) {
//    actual fun provideWalletRepository(): WalletRepository = WalletRepositoryImpl(db)
//}
actual fun dataModule() = module { 
    singleOf(::WalletRepositoryImpl) { bind<WalletRepository>() }
}