package compose.laima.chapter_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.laima.chapter_3.ui.theme.ComposeChapter3Theme

class BoxWithConstrainsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                // A surface container using the 'background' color from the theme
                Outer()
            }
        }
    }
}

@Composable
fun Outer() {
    /* 이렇게 위에서 modifier width 을 제한해버리면 밑에서 크게 키워도 150이 최대다 */
    Column(modifier = Modifier.width(150.dp)) {
        // Step 2: Inner의 인자로 Modifier 전달
        Inner(
            modifier = Modifier
                .width(250.dp)
                .height(160.dp)
        ) /* Modifier Companion Object */
        Inner(
            modifier = Modifier
                .width(250.dp)
                .height(100.dp)
        ) /* Modifier Companion Object */
    }
}

// Step 1: Inner 인자로 modifier를 전달 => 기본값을 Modifier 로 지정

@Composable
private fun Inner(modifier: Modifier = Modifier) { /* parameter로 넘어오지 않으면 기본값 Modifier 로 해주기 */
    BoxWithConstraints(modifier) {/* 전달받은 Modifier 의 min max 값 보여주기 */
        // 전달받은 maxHeight 값이 150 넘을때만 텍스트 추가 출력
        if (maxHeight > 150.dp) {
            Text(
                text = "여기 꽤 길군요",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        
        Text(text = "maxW:$maxWidth maxH:$maxHeight minW:$minWidth minH:$minHeight")
    }
}

@Preview(showBackground = true)
@Composable
fun BoxWithConstrainsPreview() {
    ComposeChapter3Theme {
        Outer()
    }
}