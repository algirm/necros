package id.northbit.necros.shared

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
    
    fun greetList(): List<String> = buildList { 
        add("Hello, ${platform.name}!")
        add(newYearPhrase())
    }
}