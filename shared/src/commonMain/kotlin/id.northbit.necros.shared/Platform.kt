package id.northbit.necros.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getSomeInt(): Int

expect fun getDispatcherProvider(): DispatcherProvider
  
enum class AppDispatcher {
    MAIN, IO
}