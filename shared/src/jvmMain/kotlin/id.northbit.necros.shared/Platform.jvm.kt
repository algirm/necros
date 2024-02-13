package id.northbit.necros.shared

import kotlinx.coroutines.Dispatchers

class JvmPlatform : Platform {
    override val name: String = "Jvm ${System.getProperty("os.name")}"
}

actual fun getPlatform(): Platform = JvmPlatform()

actual fun getSomeInt(): Int = 0

actual fun getDispatcherProvider(): DispatcherProvider = DispatcherProvider(
    main = Dispatchers.Main,
    io = Dispatchers.IO,
    default = Dispatchers.Default
)