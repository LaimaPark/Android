package compose.laima.composechapter3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.laima.composechapter3.ui.theme.ComposeChapter3Theme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter3Theme {
                // A surface container using the 'background' color from the theme
                TextFieldExample()
            }
        }
    }
}

@Composable
fun TextFieldExample() {
    var name by remember { mutableStateOf("Tom") }
    Column(modifier = Modifier.padding(16.dp)) {
        // Step 1: TextField 를 Text 위에 만들기
        TextField(value = "Tom", onValueChange = {})

        // Step 2: TextField 출력하기
        TextField(value = name, onValueChange = { name = it })

        // Step 3: label 추가하기
        // 입력 란 위에 설명
        TextField(
            value = name,
            label = {
                Text(text = "이름")
            },
            onValueChange = { name = it },
        )

        // Step 4: Spacer
        TextField(
            value = name,
            label = {
                Text(text = "이름")
            },
            onValueChange = { name = it },
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Hello $name")


        // Step 5: OutlineTextField 으로 변경해보기
        // 디자인이 다름! 테투리만 있음
        OutlinedTextField(
            value = name,
            label = {
                Text(text = "이름")
            },
            onValueChange = { name = it },
        )
        Spacer(modifier = Modifier.size(8.dp))
    }

    
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeChapter3Theme {
        TextFieldExample()
    }
}