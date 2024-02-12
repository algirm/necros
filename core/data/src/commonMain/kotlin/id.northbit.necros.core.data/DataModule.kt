package id.northbit.necros.core.data

import id.northbit.necros.core.data.wallet.WalletRepository

expect class DataModule {
    fun provideWalletRepository(): WalletRepository
}
