package id.northbit.necros.core.data.wallet

import id.northbit.necros.core.data.wallet.model.Wallet
import kotlinx.coroutines.flow.Flow

interface WalletRepository {
    
    fun getAllWallet(): Flow<List<Wallet>>
}
