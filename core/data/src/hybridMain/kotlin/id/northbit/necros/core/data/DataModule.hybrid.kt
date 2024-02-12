package id.northbit.necros.core.data

import id.northbit.necros.core.data.wallet.WalletRepository
import id.northbit.necros.core.data.wallet.WalletRepositoryImpl
import id.northbit.necros.core.database.DatabaseDriverFactory
import id.northbit.necros.core.database.data.AppDatabase

actual class DataModule(private val db: AppDatabase) {
    actual fun provideWalletRepository(): WalletRepository = WalletRepositoryImpl(db)
}