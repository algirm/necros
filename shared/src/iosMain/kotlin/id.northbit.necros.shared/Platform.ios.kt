package id.northbit.necros.shared

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun getSomeInt(): Int = 1

actual fun getDispatcherProvider(): DispatcherProvider = DispatcherProvider(
    main = Dispatchers.Main,
    io = Dispatchers.IO,
    default = Dispatchers.Default
)