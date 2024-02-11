package id.northbit.necros.core.data.maney

class ManeyRepositoryImpl(
    private val maneyLocalDataSource: ManeyLocalDataSource
) {
    fun getAllWallet(): List<String> {
        return maneyLocalDataSource.getAllWallet()
    }
}