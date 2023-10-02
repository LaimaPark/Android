package compose.laima.chapter_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.laima.composechapter3.ui.theme.ComposeChapter3Theme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                BoxExample()
            }
        }
    }
}

@Composable
fun BoxExample() {
    /* FrameLayout 대체용도로도 가능하다. */
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(
//            text = "Hello Laima!",
//            modifier = Modifier.align(Alignment.Center) /* Box 내에서 정렬 가능 */
//        )
//    }

    Column {

        // Step 1: Text 두개를 Box 안에 배치해보기
        /* Box Scope 안에서만 Modifier 가능 */
        Box(modifier = Modifier.size(100.dp)) {
            Text(
                text = "Hello !",
                modifier = Modifier.align(Alignment.Center)
            )
            Text(
                text = "Laima!",
                modifier = Modifier.align(Alignment.TopStart)
            )
        }


        // Step 2: 2개의 Box를 Box 안에 배치하고 사이즈, 색상 지정해보기
        /* 밑에 있는게 더 위에 배치된다. */
        Box(modifier = Modifier.size(100.dp)) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color.Cyan)
                    .align(Alignment.CenterStart)
            ) {
            }
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color.Yellow)
                    .align(Alignment.BottomEnd)
            ) {
            }
        }

        // Step 3: 부모 Box Modifier 설정
        /* BoxScope 안에는 Align 과 matchParentSize interface 가 있다. */
        /* Box parent size 를 정해주지 않으면 자식의 최대값을 따라간다. */
        Box {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Cyan)
                    .align(Alignment.CenterStart)
            ) {
            }
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color.Yellow)
                    .align(Alignment.BottomEnd)
            ) {
            }
        }


    }

}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    ComposeChapter3Theme {
        BoxExample()
    }
}