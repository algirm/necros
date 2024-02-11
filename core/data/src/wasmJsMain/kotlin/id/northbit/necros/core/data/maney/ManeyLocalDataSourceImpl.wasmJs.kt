package id.northbit.necros.core.data.maney

actual class ManeyLocalDataSourceImpl : ManeyLocalDataSource {
    override fun getAllWallet(): List<String> {
        return listOf("Cash WasmJs")
    }
}