package id.northbit.necros.core.data.maney

import idnorthbitnecroscoredatabase.AppDatabaseQueries

actual class ManeyLocalDataSourceImpl(
    private val queries: AppDatabaseQueries
) : ManeyLocalDataSource {
    override fun getAllWallet(): List<String> {
        return queries.getAllWallet().executeAsList().map { it.name }
    }
}