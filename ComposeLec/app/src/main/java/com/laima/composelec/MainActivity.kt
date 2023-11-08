package com.laima.composelec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.laima.composelec.ui.theme.ComposeLecTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLecTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConstrainLayoutEx()
                }
            }
        }
    }
}

@Composable
fun ConstrainLayoutEx() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        // Step 1: createRefs() 를 사용해서 아래 박스들의 Ref 들을 가져온다.
        // createRefs() 는 여러개의 Ref 를 return 하기 때문에 destruction 으로 분해해준다.
        // 한번에 16개까지 가져올 수 있고, 그 이상일 경우 두번 이상 호출해주면 된다.

        // ConstraintLayout 내에서 사용 가능한 함수
        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        Box(
            // Step 2 : constrainsAs modifier 추가해서 Ref 전달하기
            // 후행 lamda로 top, start, end, bottom 앵커지정 후 lintTo 호출
            // param 으로 parent의 앵커 전달

            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(/* 박스 위치를 지정해줌*/ redBox) {
                    /* linkTo = bob tot 같은 얘들 */
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        )
        Box(

            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(

            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)
                    /* 4개를 다 지정할 필요없이 center 로 가능 */
                    centerTo(parent)
                }
        )
        Box(

            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    start.linkTo(magentaBox.end)
                    top.linkTo(magentaBox.bottom)
                }
        )


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLecTheme {
        ConstrainLayoutEx()
    }
}