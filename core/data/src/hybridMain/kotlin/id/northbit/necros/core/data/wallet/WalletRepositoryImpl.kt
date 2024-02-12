package id.northbit.necros.core.data.wallet

import id.northbit.necros.core.data.wallet.model.Wallet
import id.northbit.necros.core.database.DatabaseDriverFactory
import id.northbit.necros.core.database.data.AppDatabase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class WalletRepositoryImpl(
    private val db: AppDatabase
) : WalletRepository {
    override fun getAllWallet(): Flow<List<Wallet>> = flow {
        emit(db.walletQueries.getAll().executeAsList().map { Wallet(it.id.toInt(), it.name) })
//        trySend(db.walletQueries.getAll().executeAsList().map { Wallet(it.id.toInt(), it.name) })
//        awaitClose { 
//            
//        }
    }
}