package id.northbit.necros.core.data.wallet

import id.northbit.necros.core.data.wallet.model.WalletModel
import kotlinx.coroutines.flow.Flow

class FakeWalletRepository : WalletRepository {
    
    override fun getAllWallet(): Flow<List<WalletModel>> {
        TODO("Not yet implemented")
    }
}
