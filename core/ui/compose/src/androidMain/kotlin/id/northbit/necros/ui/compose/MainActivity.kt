package id.northbit.necros.ui.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import id.northbit.necros.core.database.AppDatabase
import id.northbit.necros.core.database.DatabaseDriverFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = DatabaseDriverFactory(applicationContext)
        val dbDriver = AppDatabase(db.createDriver())
        val resultDb = dbDriver.appDatabaseQueries.getAllWallet().executeAsList()
        Log.d("TESTTAG", resultDb.toString())
        setContent {
            App()
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun AppAndroidPreview() {
    App()
}