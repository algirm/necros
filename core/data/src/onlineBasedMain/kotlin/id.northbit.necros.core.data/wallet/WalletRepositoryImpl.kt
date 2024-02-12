package id.northbit.necros.core.data.wallet

import id.northbit.necros.core.data.wallet.model.Wallet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class WalletRepositoryImpl : WalletRepository {
    override fun getAllWallet(): Flow<List<Wallet>> {
        return emptyFlow()
    }
}