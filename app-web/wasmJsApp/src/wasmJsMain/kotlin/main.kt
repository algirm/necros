import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import id.northbit.necros.compose.App
import id.northbit.necros.shared.transactions.TransactionsComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        DefaultComponentContext(
            lifecycle = LifecycleRegistry()
        )
        App()
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