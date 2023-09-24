package compose.laima.composechapter3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import compose.laima.composechapter3.ui.theme.ComposeChapter3Theme

class WebImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WebImageExample("Android")
                }
            }
        }
    }
}

@Composable
fun WebImageExample(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun WebImagePreview() {
    ComposeChapter3Theme {
        WebImageExample("Android")
    }
}