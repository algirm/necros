package id.northbit.necros.core.data

import id.northbit.necros.core.data.wallet.WalletRepository
import id.northbit.necros.core.data.wallet.WalletRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun dataModule() = module {
    singleOf(::WalletRepositoryImpl) { bind<WalletRepository>() }
}