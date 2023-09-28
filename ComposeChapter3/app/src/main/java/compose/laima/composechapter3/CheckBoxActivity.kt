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

class CheckBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxExample()
        }
    }
}

@Composable
fun CheckBoxExample() {
    Text(text = "Hello!")
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    ComposeChapter3Theme {
        CheckBoxExample()
    }
}