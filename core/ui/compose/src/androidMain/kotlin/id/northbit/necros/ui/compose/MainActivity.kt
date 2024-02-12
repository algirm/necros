package id.northbit.necros.ui.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import id.northbit.necros.core.data.DataModule
import id.northbit.necros.core.database.DatabaseDriverFactory
import id.northbit.necros.core.database.data.AppDatabase
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val walletRepository = DataModule(AppDatabase(DatabaseDriverFactory(this).createDriver())).provideWalletRepository()
        lifecycleScope.launch {
            walletRepository.getAllWallet().collect {
                Toast.makeText(
                    this@MainActivity,
                    "Your wallet ${it}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
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