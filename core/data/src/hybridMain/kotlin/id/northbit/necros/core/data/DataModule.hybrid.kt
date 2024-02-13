package id.northbit.necros.core.data

import id.northbit.necros.core.data.wallet.WalletRepository
import id.northbit.necros.core.data.wallet.WalletRepositoryImpl
import id.northbit.necros.shared.IoDispatcher
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual fun dataModule() = module {
    single<WalletRepository> {
        WalletRepositoryImpl(
            db = get(),
            ioDispatcher = get(named<IoDispatcher>())
        )
    }
}