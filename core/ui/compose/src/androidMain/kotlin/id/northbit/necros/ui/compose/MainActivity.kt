package id.northbit.necros.ui.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import id.northbit.necros.core.data.wallet.WalletRepository
import id.northbit.necros.core.database.data.AppDatabase
import idnorthbitnecroscoredatabase.data.Wallet
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    
    private val walletRepository: WalletRepository by inject()
    private val db: AppDatabase by inject()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            Column {
                App()
                Button(onClick = {
                    db.walletQueries.insert(Wallet(-1, "Wallet ${Random.nextInt(9)}"))
                }) {
                    Text("Add new wallet")
                }
            }
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