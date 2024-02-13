package id.northbit.necros.core.data.wallet

import id.northbit.necros.core.data.wallet.model.WalletModel
import kotlinx.coroutines.flow.Flow

interface WalletRepository {
    
    fun getAllWallet(): Flow<List<WalletModel>>
}
