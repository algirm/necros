package id.northbit.necros.shared

import kotlinx.coroutines.CoroutineDispatcher

annotation class MainDispatcher
annotation class IoDispatcher
annotation class DefaultDispatcher

data class DispatcherProvider(
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher,
    val default: CoroutineDispatcher,
)
