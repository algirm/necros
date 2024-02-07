package id.northbit.necros

import androidx.lifecycle.ViewModel
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import id.northbit.necros.core.database.DatabaseDriverFactory
import id.northbit.necros.shared.transactions.TransactionsComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
//    private val transactionsComponent: TransactionsComponent
) : ViewModel() {
}

//internal class TransactionsComponentImpl() : TransactionsComponent {
//
//    val _transactions: MutableValue<List<String>> = MutableValue(listOf("user1", "user2"))
//
//    override val transactions: StateFlow<List<String>>
//        get() = _transactions
//
//    override fun onItemClick(item: String) {
//        
//    }
//
//}