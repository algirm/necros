package id.northbit.necros.shared.root


interface RootComponent {
    
//    val childStack: Value<ChildStack<*, Any>>
    
    sealed class Child {
//        class TransactionsChild(val component: TransactionsComponent) : Child()
    }
    
}