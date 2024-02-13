package id.northbit.necros.shared

import kotlinx.coroutines.Dispatchers

class JsPlatform : Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getSomeInt(): Int = 0

actual fun getPlatform(): Platform = JsPlatform()

actual fun getDispatcherProvider(): DispatcherProvider = DispatcherProvider(
    main = Dispatchers.Main,
    io = Dispatchers.Default,
    default = Dispatchers.Default
)