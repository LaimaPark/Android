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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.laima.composelec.ui.theme.ComposeLecTheme

class ConstraintSetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLecTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConstraintSetEx("Android")
                }
            }
        }
    }
}

@Composable
fun ConstraintSetEx(name: String) {

    val constraintSet = ConstraintSet {
        // Step 1: createRefFor 를 통해 박스들을 위한 Ref 를 만든다
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")

        // Step 2: 'constrain'을 열고 만들었던 Ref 들을 param 으로 넣는다.
        constrain(redBox) {
            bottom.linkTo(parent.bottom, margin = 8.dp)
            end.linkTo(parent.end, margin = 4.dp)
        }

        constrain(magentaBox) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(greenBox) {
            centerTo(parent)
        }
    }


    ConstraintLayout(
        // Step 4: ConstraintLayout param으로 ConstraintSet 을 넘긴다.
        constraintSet,
        modifier = Modifier.fillMaxSize()
    ) {

        // Step 3: modifier 를 통해 layoutId 지정한다
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
        )
        Box(

            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
        )


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeLecTheme {
        ConstraintSetEx("Android")
    }
}