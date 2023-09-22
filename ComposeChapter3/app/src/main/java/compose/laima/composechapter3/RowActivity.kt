package compose.laima.chapter_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.laima.chapter_3.ui.theme.ComposeChapter3Theme

class RowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                RowExample()
            }
        }
    }
}

@Composable
fun RowExample() {

    Column {

        Row(modifier = Modifier.height(40.dp)) {
            Text(text = "First!")
            Text(text = "Second!")
            Text(text = "Third!")
        }

        // Step 1: 각 Text의 Modifier Align
        // Text align 는 진행방향과 반대로만 움직인다
        // Row -> modifier.align = vertical
        Row(modifier = Modifier.height(40.dp)) {
            Text(text = "First!", modifier = Modifier.align(Alignment.Top))
            Text(text = "Second!", modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = "Third!",  modifier = Modifier.align(Alignment.Bottom))
        }

        // Step 2: Row verticalAlignment
        // 각각 설정하는게 아니라 한번에 하고싶으면 Row 에서 align
        // 그 이후에 개별적으로 align 적용도 할 수 있다.
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(40.dp)
        ) {
            Text(text = "First!", modifier = Modifier.align(Alignment.Top))
            Text(text = "Second!")
            Text(text = "Third!")
        }


        // Step 3: Horizontal Arrangement
        // Arrangment 는 Row의 가는 방향(수평) 과 동일하다
        // Arrangment 에는 Start, End, SpaceAround, SpaceEvenly 가 있다.
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(40.dp)
                .width(200.dp)
        ) {
            Text(text = "Arr!", modifier = Modifier.align(Alignment.Top))
            Text(text = "Space!")
            Text(text = "Around!")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(40.dp)
                .width(200.dp)
        ) {
            Text(text = "Arr!", modifier = Modifier.align(Alignment.Top))
            Text(text = "Space!")
            Text(text = "Evenly!")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(40.dp)
                .width(200.dp)
        ) {
            Text(text = "Arr!", modifier = Modifier.align(Alignment.Top))
            Text(text = "Space!")
            Text(text = "Between!")
        }

        // Step 4: Weight
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(40.dp)
                .width(200.dp)
        ) {
            Text(
                text = "3f!",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Top)
                    .weight(3f)
                    .background(Color.Magenta)
            )
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "추가",
                modifier = Modifier.weight(1f)
                    .background(Color.Cyan)
            )
            Text(
                text = "3f!",
                modifier = Modifier
                    .weight(3f)
            )
        }


        // Step 5: Text => Icon


    }


}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    ComposeChapter3Theme {
        RowExample()
    }
}