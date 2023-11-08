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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.laima.composelec.ui.theme.ComposeLecTheme

class ConstraintBarrierChainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLecTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConstraintBarrierChainEx()
                }
            }
        }
    }
}

@Composable
fun ConstraintBarrierChainEx() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) { }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) { }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) { }
        )

        // 세 박스 Ref 를 연결해서 사용 : 세로로 일렬 & 가로로 일렬
        // 둘이 동시에 쓰면 대각선으로 정렬
//        createVerticalChain(redBox, yellowBox, magentaBox)
//        createHorizontalChain(redBox, yellowBox, magentaBox)

        //  ChainStyle.Spread       | - - 1 - - 2 - - 3 - - |
        //  ChainStyle.SpreadInside | 1 - - - - 2 - - - - 3 |
        //  ChainStyle.Packed       | - - - - 1 2 3 - - - - |
        createHorizontalChain(redBox, yellowBox, magentaBox, chainStyle = ChainStyle.SpreadInside)

        // 기준 선이 만들어짐 (View 로 만들었던 것과 동일)
        // TopBarrier, BottomBarrier, Start ...
        val barrier = createBottomBarrier(redBox, yellowBox, magentaBox)

        Text(
            text = "test test",
            modifier = Modifier.constrainAs(text) {
                // top 은 bottom, top barrier 와 매칭 가능
                top.linkTo(barrier)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeLecTheme {
        ConstraintBarrierChainEx()
    }
}