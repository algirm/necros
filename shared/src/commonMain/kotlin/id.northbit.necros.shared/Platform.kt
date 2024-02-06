package id.northbit.necros.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getSomeInt(): Int