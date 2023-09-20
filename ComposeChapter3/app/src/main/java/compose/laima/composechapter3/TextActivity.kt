package compose.laima.chapter_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.laima.composechapter3.ui.theme.ComposeChapter3Theme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextExample("Android")
                }
            }
        }
    }
}

@Composable
fun TextExample(name: String) {
    Column {
        Text(text = "Hello $name!")

        // Step 1: 색상 지정을 위해 color param 에 값 전달
        Text(color = Color.Red, text = "Hello $name")

        // Step 2: 색상 지정(Color 객체를 이용한 Hash 값 전달)
        Text(color = Color(0xffff9944), text = "Hello $name")

        // Step 3: fontSize param
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp
        )

        // Step 4: fontWeight param
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
        )

        // Step 5: letter spacing 지정
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            letterSpacing = 2.sp /* 자간 : sp 기준으로 해야함! */
        )

        // Step 6: maxLines
        Text(
            color = Color.Red,
            text =  "Hello $name\nHello $name\nHello $name",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            maxLines = 2
        )

        // Step 7: textDecoration - UnderLine
        Text(
            color = Color.Red,
            text =  "Hello $name\nHello $name\nHello $name",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            maxLines = 2,
            textDecoration = TextDecoration.Underline
        )

        // Step 8: text Align
        Text(
            color = Color.Red,
            text =  "Hello $name\nHello $name\nHello $name",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            maxLines = 2,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center
        )

        // Step 9: Modifier
        Text(
            /* Modifier.size = 가로세로 동시에 */
//            modifier = Modifier.size(300.dp /* 여기선 dp! */ ),
            modifier = Modifier.width(300.dp /* 여기선 dp! */ ),
            color = Color.Red,
            text =  "Hello $name\nHello $name\nHello $name",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            maxLines = 2,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center
        )

    }


}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    ComposeChapter3Theme {
        TextExample("Android")
    }
}