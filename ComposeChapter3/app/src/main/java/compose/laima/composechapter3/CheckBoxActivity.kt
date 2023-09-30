package compose.laima.composechapter3

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
    Row(verticalAlignment = Alignment.CenterVertically) {
        // 수직정렬을 위해 verticalAlignment

//        var checked = remember { mutableStateOf(false) }
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = {
//                checked.value = !checked.value
//                // 값이 바뀌어야 recomposition
//            }
//        )

        // delegated properties (by)
        // checked 가 property 인것 처럼
        // .value 인것 처럼 하는 것
        var checked by remember { mutableStateOf(false) }
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = !checked
                // 값이 바뀌어야 recomposition
            }
        )


        // destruction
        // var (a, b) =  listOf(1, 2)
//        var (checked2, setChecked) = remember { mutableStateOf(false) }
//        Checkbox(
//            checked = checked2,
////            onCheckedChange = {
////                // it 이 반전된 값을 줌
////                setChecked(it)
////                // 값이 바뀌어야 recomposition
////            }
//            onCheckedChange = setChecked // 이렇게 가능
//        )
        val (getter, setter) = remember { mutableStateOf(false) }
        Checkbox(
            checked = getter,
            onCheckedChange = setter // 이렇게 가능
        )

        Text(
            text = "프로그래머입니까?",
            modifier = Modifier.clickable {
                setter(!getter)
            }
        )
        
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    ComposeChapter3Theme {
        CheckBoxExample()
    }
}