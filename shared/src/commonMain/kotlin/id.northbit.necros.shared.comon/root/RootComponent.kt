package id.northbit.necros.shared.comon.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootComponent {
    
    val childStack: Value<ChildStack<*, Any>>
    
    sealed class Child {
//        class TransactionsChild(val component: TransactionsComponent) : Child()
    }
    
}