package id.northbit.necros.core.data.wallet

import id.northbit.necros.core.data.wallet.model.Wallet
import kotlinx.coroutines.flow.Flow

class WalletRepositoryImpl : WalletRepository {
    override fun getAllWallet(): Flow<List<Wallet>> {
        TODO("Not yet implemented")
    }
}