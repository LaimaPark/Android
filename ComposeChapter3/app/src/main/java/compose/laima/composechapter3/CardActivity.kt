package compose.laima.chapter_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import compose.laima.chapter_3.ui.theme.ComposeChapter3Theme

class CardActivity : ComponentActivity() {

    companion object {
        val cardData = CardData(
            imageUri = "Uri",
            imageDescription = "엔텔로프 캐년",
            author = "Dali",
            description = "멋진 엔텔로프 캐년"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        CardExample(cardData)
                        CardExample(cardData)
                    }
                }
            }
        }
    }
}

@Composable
fun CardExample(cardData: CardData) {
    val placeHolder = Color(0x33000000)

    Card(elevation = 8.dp, modifier = Modifier.padding(4.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = cardData.imageUri, 
                contentDescription = cardData.imageDescription,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(text = cardData.author)
                Spacer(modifier = Modifier.size(4.dp)) /* 4의 배수로 넣는 경우가 많음 */
                Text(text = cardData.description)
            }

            AsyncImage(
                model = cardData.imageUri,
                contentScale = ContentScale.Crop, /**/
                contentDescription = cardData.imageDescription,
                placeholder = ColorPainter(placeHolder), /**/
                modifier = Modifier.size(32.dp).clip(CircleShape) /**/
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(text = cardData.author)
                Spacer(modifier = Modifier.size(4.dp)) /* 4의 배수로 넣는 경우가 많음 */
                Text(text = cardData.description)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ComposeChapter3Theme {
        CardExample(cardData = CardActivity.cardData)
    }
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)