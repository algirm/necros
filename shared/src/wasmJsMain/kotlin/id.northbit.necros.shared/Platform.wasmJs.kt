package id.northbit.necros.shared

import kotlinx.coroutines.Dispatchers

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()

actual fun getSomeInt(): Int = 1997

actual fun getDispatcherProvider(): DispatcherProvider = DispatcherProvider(
    main = Dispatchers.Main,
    io = Dispatchers.Default,
    default = Dispatchers.Default
)