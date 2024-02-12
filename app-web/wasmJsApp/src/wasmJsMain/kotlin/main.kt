import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.CanvasBasedWindow
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import id.northbit.necros.core.data.DataModule
import id.northbit.necros.ui.compose.App
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
fun main() {
    val walletRepository = DataModule().provideWalletRepository()
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        DefaultComponentContext(
            lifecycle = LifecycleRegistry()
        )
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            val wallet by walletRepository.getAllWallet().collectAsState(emptyList())
            App()
            Image(painterResource("dog.xml"), null)
            Button(
                onClick = {
                    window.alert("Your wallet is ${wallet}")
                }
            ) {
                Text("Get Wallet")
            }
        }
//        MaterialTheme {
//            var showContent by remember { mutableStateOf(false) }
//            
//            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                Button(onClick = { showContent = !showContent }) {
//                    Text("Click me!")
//                }
//                AnimatedVisibility(showContent) {
//                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                        Image(painterResource("compose-multiplatform.xml"), null)
//                        Text("Click me!")
//                    }
//                }
//            }
//        }
    }
}