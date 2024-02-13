package id.northbit.necros.core.data.wallet

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import id.northbit.necros.core.data.wallet.model.WalletModel
import id.northbit.necros.core.database.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest

class WalletRepositoryImpl(
    private val db: AppDatabase
) : WalletRepository {
    
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getAllWallet(): Flow<List<WalletModel>> = db
        .walletQueries
        .getAll()
        .asFlow()
        .mapToList(Dispatchers.IO)
        .mapLatest { wallets -> 
            wallets.map { wallet -> WalletModel(wallet.id.toInt(), wallet.name)  } 
        }
    
}
