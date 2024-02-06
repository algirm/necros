package id.northbit.necros.shared

actual fun getSomeInt(): Int = 0
actual fun getPlatform(): Platform = JvmPlatform()
class JvmPlatform : Platform {
    override val name: String = "Jvm ${System.getProperty("os.name")}"
}