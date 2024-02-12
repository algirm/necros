package id.northbit.necros.core.data

import id.northbit.necros.core.data.wallet.WalletRepository
import id.northbit.necros.core.data.wallet.WalletRepositoryImpl

actual class DataModule {
    actual fun provideWalletRepository(): WalletRepository = WalletRepositoryImpl()
}