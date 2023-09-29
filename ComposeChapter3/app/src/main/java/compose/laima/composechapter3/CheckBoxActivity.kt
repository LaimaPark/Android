package compose.laima.composechapter3

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

        var checked = false
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = !checked
            }
        )

        Text(text = "프로그래머입니까?")
        
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    ComposeChapter3Theme {
        CheckBoxExample()
    }
}