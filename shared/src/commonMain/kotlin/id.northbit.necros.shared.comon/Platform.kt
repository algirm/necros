package id.northbit.necros.shared.comon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getSomeInt(): Int