import id.northbit.necros.shared.comon.Platform

class JsPlatform: Platform {
    override val name: String = "Web with Kotlin/JS"
}
actual fun getSomeInt(): Int = 0
actual fun getPlatform(): Platform = JsPlatform()