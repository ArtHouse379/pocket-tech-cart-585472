package skdevicehub.smartphones.pockettechcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import skdevicehub.smartphones.pockettechcart.ui.composable.approot.AppRoot
import skdevicehub.smartphones.pockettechcart.ui.theme.UOWJDAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UOWJDAppTheme {
                AppRoot()
            }
        }
    }
}
