import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ui.theme.ComposeIMTheme

class AppViewModel : ViewModel() {

    var theme by mutableStateOf(ComposeIMTheme.Theme.Light)

}