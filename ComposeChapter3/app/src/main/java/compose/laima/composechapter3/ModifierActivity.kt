package compose.laima.chapter_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.laima.chapter_3.ui.theme.ComposeChapter3Theme

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                ModifierExample()
            }
        }
    }
}

@Composable
fun ModifierExample() {
    Column {

        // Step 1: fillMaxSize
        Button(
            onClick = { },
//            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search" /* 가능하면 써주는게 좋음 */
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                text = "Search"
            )
        }

        // Step 2: Modifier.height
        Button(
            onClick = { },
            modifier = Modifier.height(100.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search" /* 가능하면 써주는게 좋음 */
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                text = "Search"
            )
        }

        // Step 3: height & width
        Button(
            onClick = { },
            modifier = Modifier
                .height(100.dp)
                .width(200.dp) /* Chaining */
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search" /* 가능하면 써주는게 좋음 */
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                text = "Search"
            )
        }

        // Step 4: size
        Button(
            onClick = { },
            modifier = Modifier
                .size(width = 200.dp, height = 50.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search" /* 가능하면 써주는게 좋음 */
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                text = "Search"
            )
        }

        // Step 5: background
        Button(
            onClick = { },
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red) /* 바뀌지 않음!! */
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search" /* 가능하면 써주는게 좋음 */
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                text = "Search"
            )
        }

        // Step 6: Color Param
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta /* 버튼 자체의 색상*/,
                contentColor = Color.Cyan       /* 내용 색상 */
            ),
            onClick = { },
            modifier = Modifier
                .size(100.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search" /* 가능하면 써주는게 좋음 */
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                text = "Search"
            )
        }


        // Step 7: Modifier 를 통한 Padding
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta ,
                contentColor = Color.Cyan
            ),
            onClick = { },
            modifier = Modifier
                .padding(10.dp) /* Padding */
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search" /* 가능하면 써주는게 좋음 */
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                text = "Search"
            )
        }

        // Step 8: enabled = false + clickable
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta ,
                contentColor = Color.Cyan
            ),
            onClick = { },
            enabled = false,
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search" /* 가능하면 써주는게 좋음 */
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                text = "Search",
                modifier = Modifier.clickable {  } /* 버튼 전체가 아닌 Text만 click 가능 */
            )
        }

        // Step 9: modifier offset 설정
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta ,
                contentColor = Color.Cyan
            ),
            onClick = { },
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search" /* 가능하면 써주는게 좋음 */,
                modifier = Modifier.background(Color.Blue)
            )
            Spacer(
                modifier = Modifier
                    .size(ButtonDefaults.IconSpacing)
                    .background(Color.Green)
            )
            Text(
                text = "Search",
                modifier = Modifier
                    .offset(x = 10.dp)
                    .background(Color.Black)
           )
        }


    }

}

@Preview(showBackground = true)
@Composable
fun ModifierPreview() {
    ComposeChapter3Theme {
        ModifierExample()
    }
}