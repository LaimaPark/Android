package compose.laima.chapter_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import compose.laima.composechapter3.ui.theme.ComposeChapter3Theme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                ImageExample()
            }
        }
    }
}

@Composable
fun ImageExample() {
    Column {
        // Step 1: Image 만들기
        Image(
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "엔텔로프 캐넌"
        )

        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )


    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    ComposeChapter3Theme {
        ImageExample()
    }
}