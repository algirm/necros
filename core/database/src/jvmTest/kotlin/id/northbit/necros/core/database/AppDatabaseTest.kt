package id.northbit.necros.core.database

import idnorthbitnecroscoredatabase.Wallet
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AppDatabaseTest {
    
//    private lateinit var db: AppDatabase
    val db: AppDatabase = AppDatabase(DatabaseDriverFactory().createDriver())
    
    @BeforeTest
    fun setup() {
//        db = AppDatabase(DatabaseDriverFactory().createDriver())
    }
    
    @Test
    fun `get all wallet from database initial data`() {
        val result = db.appDatabaseQueries.getAllWallet().executeAsList()
        println(result.toString())
        assertEquals(
            expected = true,
            actual = result.size == 1
        )
        assertEquals(
            expected = "Cash",
            actual = result.first().name
        )
    }
    
    @Test
    fun `insert one wallet and get all wallet should get 2 data`() {
        db.appDatabaseQueries.insertWallet(Wallet(0, "Wallet Two"))
        val result = db.appDatabaseQueries.getAllWallet().executeAsList()
        assertEquals(
            expected = true,
            actual = result.size == 2
        )
        assertEquals(
            expected = "Cash",
            actual = result.first().name
        )
        assertEquals(
            expected = "Wallet Two",
            actual = result.last().name
        )
    }
}