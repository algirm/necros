package id.northbit.necros.ui.compose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import id.northbit.necros.core.data.maney.ManeyLocalDataSourceImpl
import id.northbit.necros.core.data.maney.ManeyRepositoryImpl
import id.northbit.necros.core.database.AppDatabase
import id.northbit.necros.core.database.DatabaseDriverFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val maneyRepositoryImpl = ManeyRepositoryImpl(
            ManeyLocalDataSourceImpl(
                AppDatabase(DatabaseDriverFactory(applicationContext).createDriver()).appDatabaseQueries
            )
        )
        Toast.makeText(
            this,
            "Your wallet ${maneyRepositoryImpl.getAllWallet()}",
            Toast.LENGTH_SHORT
        ).show()
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