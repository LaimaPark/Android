package compose.laima.chapter_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import compose.laima.chapter_3.ui.theme.ComposeChapter3Theme

class NetworkImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                // A surface container using the 'background' color from the theme
                CoilExample()
            }
        }
    }
}

@Composable
fun CoilExample() {
    // rememberImagePainter Ver
    val painter = rememberImagePainter(data = "URL")
    Image(painter = painter, contentDescription = "엔텔로프 캐넌")

    // AsyncImage Ver
    AsyncImage(model = "URL", contentDescription = "엔텔로프 캐넌")

}

@Preview(showBackground = true)
@Composable
fun CoilPreview() {
    ComposeChapter3Theme {
        CoilExample()
    }
}