import java.lang.management.OperatingSystemMXBean

actual fun getSomeInt(): Int = 0
actual fun getPlatform(): Platform = JvmPlatform()
class JvmPlatform : Platform {
    override val name: String = "Jvm "
}