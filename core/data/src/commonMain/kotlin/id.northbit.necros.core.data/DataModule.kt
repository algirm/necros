package id.northbit.necros.core.data

import id.northbit.necros.core.data.wallet.WalletRepository
import org.koin.core.module.Module

//expect class DataModule {
//    fun provideWalletRepository(): WalletRepository
//}

expect fun dataModule(): Module
