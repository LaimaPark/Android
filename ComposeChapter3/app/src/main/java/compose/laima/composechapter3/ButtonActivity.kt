package compose.laima.chapter_3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.laima.composechapter3.ui.theme.ComposeChapter3Theme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ButtonExample(onButtonClicked = {
                        Toast.makeText(this, "Send Click", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
    Column {

        // Step 1: Click 시, Toast 띄우기
        Button(onClick = onButtonClicked /* 외부에서 받아옴 */) {
            Text(text = "Send")
        }

        // Step 2: Icon 추가해보기
        Button(onClick = onButtonClicked /* 외부에서 받아옴 */) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )
            Text(text = "Send")
        }

        // Step 3: Icon - Text 사이 띄우기
        Button(onClick = onButtonClicked) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )
            /* ButtonDefaults.IconSpacing : 기본적인 icon 너비 */
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//            Spacer(modifier = Modifier.size(30.dp))
            Text(text = "Send")
        }

        // Step 4: enabled
        Button(
            onClick = onButtonClicked,
            enabled = false /* 색상도 회색으로 변함 */
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        // Step 5: border stroke
        Button(
            onClick = onButtonClicked,
            enabled = true,
            border = BorderStroke(10.dp, Color.Magenta)
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        // Step 6: shape 설정
        Button(
            onClick = onButtonClicked,
            enabled = true,
            border = BorderStroke(10.dp, Color.Magenta),
            shape = CircleShape /* RoundedCornerShape */
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        // Step 7: contentPadding
        Button(
            onClick = onButtonClicked,
            border = BorderStroke(10.dp, Color.Magenta),
            shape = CircleShape,
            contentPadding = PaddingValues(20.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ComposeChapter3Theme {
        ButtonExample(onButtonClicked = { })
    }
}