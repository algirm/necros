package id.northbit.necros.core.data.wallet

import id.northbit.necros.core.data.wallet.model.WalletModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class WalletRepositoryImpl : WalletRepository {
    override fun getAllWallet(): Flow<List<WalletModel>> {
        return emptyFlow()
    }
}